/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.rest;

import com.microsoft.rest.credentials.ServiceClientCredentials;
import com.microsoft.rest.protocol.Environment;
import com.microsoft.rest.protocol.ResponseBuilder;
import com.microsoft.rest.protocol.SerializerAdapter;
import com.microsoft.rest.v2.http.ChannelHandlerConfig;
import com.microsoft.rest.v2.http.HttpClient;
import com.microsoft.rest.v2.http.RxNettyAdapter;
import com.microsoft.rest.v2.policy.CredentialsPolicy;
import com.microsoft.rest.v2.policy.LoggingPolicy;
import com.microsoft.rest.v2.policy.RequestPolicy;
import com.microsoft.rest.v2.policy.RetryPolicy;
import com.microsoft.rest.v2.policy.UserAgentPolicy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * An instance of this class stores configuration for setting up specific service clients.
 */
public final class RestClient {

    private final HttpClient httpClient;
    private final String baseURL;
    private final String userAgent;
    private final long readTimeoutMillis;
    private final long connectionTimeoutMillis;
    private final SerializerAdapter<?> serializerAdapter;
    private final ResponseBuilder.Factory responseBuilderFactory;
    private final ServiceClientCredentials credentials;
    private LogLevel logLevel;

    private final List<RequestPolicy.Factory> customPolicyFactories;

    private RestClient(RestClient.Builder builder) {
        this.baseURL = builder.baseUrl;
        this.userAgent = builder.userAgent;
        this.readTimeoutMillis = builder.readTimeoutMillis;
        this.connectionTimeoutMillis = builder.connectionTimeoutMillis;
        this.serializerAdapter = builder.serializerAdapter;
        this.responseBuilderFactory = builder.responseBuilderFactory;
        this.credentials = builder.credentials;
        this.logLevel = builder.logLevel;
        this.customPolicyFactories = builder.customPolicyFactories;

        this.httpClient = new RxNettyAdapter(createPolicyFactories(), Collections.<ChannelHandlerConfig>emptyList());
    }

    private List<RequestPolicy.Factory> createPolicyFactories() {
        List<RequestPolicy.Factory> allFactories = new ArrayList<>();
        allFactories.add(new UserAgentPolicy.Factory(userAgent));
        allFactories.add(new RetryPolicy.Factory());
        allFactories.add(new LoggingPolicy.Factory(logLevel));
        allFactories.add(new CredentialsPolicy.Factory(credentials));
        allFactories.addAll(customPolicyFactories);
        return allFactories;
    }

    /**
     * @return the user-defined request policy factories.
     */
    public List<RequestPolicy.Factory> customPolicyFactories() {
        return customPolicyFactories;
    }

    /**
     * @return the current serializer adapter.
     */
    public SerializerAdapter<?> serializerAdapter() {
        return serializerAdapter;
    }

    /**
     * @return the current respnose builder factory.
     */
    public ResponseBuilder.Factory responseBuilderFactory() {
        return responseBuilderFactory;
    }

    /**
     * @return the {@link HttpClient} instance
     */
    public HttpClient httpClient() {
        return httpClient;
    }

    /**
     * @return the base URL to make requests to.
     */
    public String baseURL() {
        return baseURL;
    }

    /**
     * @return the connection timeout for HTTP connections in milliseconds.
     */
    public long connectionTimeoutMillis() {
        return connectionTimeoutMillis;
    }

    /**
     * @return the credentials attached to this REST client
     */
    public ServiceClientCredentials credentials() {
        return credentials;
    }

    /**
     * @return the current HTTP traffic logging level
     */
    public LogLevel logLevel() {
        return logLevel;
    }

    /**
     * Create a new builder for a new Rest Client with the same configurations on this one.
     * @return a RestClient builder
     */
    RestClient.Builder newBuilder() {
        return new Builder(this);
    }

    /**
     * @return The user agent string to send in HTTP requests.
     */
    public String userAgent() {
        return userAgent;
    }

    /**
     * The builder class for building a REST client.
     */
    public static class Builder {
        private final long defaultReadTimeoutMillis = 10000;
        private final long defaultConnectionTimeoutMillis = 10000;

        /** The dynamic base URL with variables wrapped in "{" and "}". */
        private String baseUrl;
        /** The credentials to authenticate. */
        private ServiceClientCredentials credentials;

        private List<RequestPolicy.Factory> customPolicyFactories = new ArrayList<>();

        /** The value for 'User-Agent' header. */
        private String userAgent;
        private long readTimeoutMillis = defaultReadTimeoutMillis;
        private long connectionTimeoutMillis = defaultConnectionTimeoutMillis;
        /** The adapter for serializations and deserializations. */
        private SerializerAdapter<?> serializerAdapter;
        /** The builder factory for response builders. */
        private ResponseBuilder.Factory responseBuilderFactory;
        /** The logging level to use. */
        private LogLevel logLevel = LogLevel.NONE;

        private Builder(final RestClient restClient) {
            this.baseUrl = restClient.baseURL;
            this.userAgent = restClient.userAgent;
            this.responseBuilderFactory = restClient.responseBuilderFactory;
            this.connectionTimeoutMillis = restClient.connectionTimeoutMillis;
            this.readTimeoutMillis = restClient.readTimeoutMillis;
            this.serializerAdapter = restClient.serializerAdapter;
            this.credentials = restClient.credentials;
            this.customPolicyFactories = new ArrayList<>(restClient.customPolicyFactories);
            this.logLevel = restClient.logLevel;
        }

        /**
         * Creates an instance of the builder.
         */
        public Builder() { }

        /**
         * Sets the dynamic base URL.
         *
         * @param baseUrl the base URL to use.
         * @return the builder itself for chaining.
         */
        public Builder withBaseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
            return this;
        }

        /**
         * Sets the base URL with the default from the Environment.
         *
         * @param environment the environment to use
         * @param endpoint the environment endpoint the application is accessing
         * @return the builder itself for chaining
         */
        public Builder withBaseUrl(Environment environment, Environment.Endpoint endpoint) {
            this.baseUrl = environment.url(endpoint);
            return this;
        }

        /**
         * Sets the serialization adapter.
         *
         * @param serializerAdapter the adapter to a serializer
         * @return the builder itself for chaining
         */
        public Builder withSerializerAdapter(SerializerAdapter<?> serializerAdapter) {
            this.serializerAdapter = serializerAdapter;
            return this;
        }

        /**
         * Sets the response builder factory.
         *
         * @param responseBuilderFactory the response builder factory
         * @return the builder itself for chaining
         */
        public Builder withResponseBuilderFactory(ResponseBuilder.Factory responseBuilderFactory) {
            this.responseBuilderFactory = responseBuilderFactory;
            return this;
        }

        /**
         * Sets the credentials.
         *
         * @param credentials the credentials object.
         * @return the builder itself for chaining.
         */
        public Builder withCredentials(ServiceClientCredentials credentials) {
            if (credentials == null) {
                throw new NullPointerException("credentials == null");
            }
            this.credentials = credentials;
            return this;
        }

        /**
         * Sets the user agent header.
         *
         * @param userAgent the user agent header.
         * @return the builder itself for chaining.
         */
        public Builder withUserAgent(String userAgent) {
            this.userAgent = userAgent;
            return this;
        }

        /**
         * Sets the HTTP log level.
         *
         * @param logLevel the {@link LogLevel} enum.
         * @return the builder itself for chaining.
         */
        public Builder withLogLevel(LogLevel logLevel) {
            if (logLevel == null) {
                throw new NullPointerException("logLevel == null");
            }
            this.logLevel = logLevel;
            return this;
        }

        /**
         * Set the read timeout on the HTTP client. Default is 10 seconds.
         *
         * @param timeout the timeout numeric value
         * @param unit the time unit for the numeric value
         * @return the builder itself for chaining
         */
        public Builder withReadTimeout(long timeout, TimeUnit unit) {
            readTimeoutMillis = unit.toMillis(timeout);
            return this;
        }

        /**
         * Set the connection timeout on the HTTP client. Default is 10 seconds.
         *
         * @param timeout the timeout numeric value
         * @param unit the time unit for the numeric value
         * @return the builder itself for chaining
         */
        public Builder withConnectionTimeout(long timeout, TimeUnit unit) {
            connectionTimeoutMillis = unit.toMillis(timeout);
            return this;
        }

        /**
         * Set the maximum idle connections for the HTTP client. Default is 5.
         *
         * @param maxIdleConnections the maximum idle connections
         * @return the builder itself for chaining
         */
        public Builder withMaxIdleConnections(int maxIdleConnections) {
            // FIXME -- maybe by deleting this method?
            // Seems like a configuration on a concrete HTTP client
            throw new RuntimeException();
//            httpClientBuilder.connectionPool(new ConnectionPool(maxIdleConnections, 5, TimeUnit.MINUTES));
        }

        /**
         * Adds a custom RequestPolicyFactory to the request pipeline.
         * @param factory The Factory producing a custom user-defined RequestPolicy.
         * @return The builder.
         */
        public Builder addCustomPolicy(RequestPolicy.Factory factory) {
            customPolicyFactories.add(factory);
            return this;
        }

        /**
         * Build a RestClient with all the current configurations.
         *
         * @return a {@link RestClient}.
         */
        public RestClient build() {
            if (baseUrl == null) {
                throw new IllegalArgumentException("Please set base URL.");
            }
            if (responseBuilderFactory == null) {
                throw new IllegalArgumentException("Please set response builder factory.");
            }
            if (serializerAdapter == null) {
                throw new IllegalArgumentException("Please set serializer adapter.");
            }

            return new RestClient(this);
        }
    }
}
