/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 * 
 * Code generated by Microsoft (R) AutoRest Code Generator 0.11.0.0
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package fixtures.azurespecials;

import com.microsoft.rest.credentials.ServiceClientCredentials;

/**
 * The interface for AutoRestAzureSpecialParametersTestClient class.
 */
public interface AutoRestAzureSpecialParametersTestClient {
    /**
     * Gets the URI used as the base for all cloud service requests.
     * @return The BaseUri value.
     */
    String getBaseUri();

    /**
     * Gets The management credentials for Azure..
     *
     * @return the credentials value.
     */
    ServiceClientCredentials getCredentials();

    /**
     * Gets The subscription id, which appears in the path, always modeled in credentials. The value is always '1234-5678-9012-3456'.
     *
     * @return the subscriptionId value.
     */
    String getSubscriptionId();

    /**
     * Sets The subscription id, which appears in the path, always modeled in credentials. The value is always '1234-5678-9012-3456'.
     *
     * @param subscriptionId the subscriptionId value.
     */
    void setSubscriptionId(String subscriptionId);

    /**
     * Gets The api version, which appears in the query, the value is always '2015-07-01-preview'.
     *
     * @return the apiVersion value.
     */
    String getApiVersion();

    /**
     * Gets Gets or sets the preferred language for the response..
     *
     * @return the acceptLanguage value.
     */
    String getAcceptLanguage();

    /**
     * Sets Gets or sets the preferred language for the response..
     *
     * @param acceptLanguage the acceptLanguage value.
     */
    void setAcceptLanguage(String acceptLanguage);

    /**
     * Gets The retry timeout for Long Running Operations..
     *
     * @return the longRunningOperationRetryTimeout value.
     */
    int getLongRunningOperationRetryTimeout();

    /**
     * Sets The retry timeout for Long Running Operations..
     *
     * @param longRunningOperationRetryTimeout the longRunningOperationRetryTimeout value.
     */
    void setLongRunningOperationRetryTimeout(int longRunningOperationRetryTimeout);

    /**
     * Gets the XMsClientRequestId object to access its operations.
     * @return the xMsClientRequestId value.
     */
    XMsClientRequestId getXMsClientRequestId();

    /**
     * Gets the SubscriptionInCredentials object to access its operations.
     * @return the subscriptionInCredentials value.
     */
    SubscriptionInCredentials getSubscriptionInCredentials();

    /**
     * Gets the SubscriptionInMethod object to access its operations.
     * @return the subscriptionInMethod value.
     */
    SubscriptionInMethod getSubscriptionInMethod();

    /**
     * Gets the ApiVersionDefault object to access its operations.
     * @return the apiVersionDefault value.
     */
    ApiVersionDefault getApiVersionDefault();

    /**
     * Gets the ApiVersionLocal object to access its operations.
     * @return the apiVersionLocal value.
     */
    ApiVersionLocal getApiVersionLocal();

    /**
     * Gets the SkipUrlEncoding object to access its operations.
     * @return the skipUrlEncoding value.
     */
    SkipUrlEncoding getSkipUrlEncoding();

}
