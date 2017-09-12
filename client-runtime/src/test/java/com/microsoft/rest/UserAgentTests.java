/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.rest;

import com.microsoft.rest.v2.http.HttpClient;
import com.microsoft.rest.v2.http.HttpRequest;
import com.microsoft.rest.v2.http.HttpResponse;
import com.microsoft.rest.v2.http.MockHttpResponse;
import com.microsoft.rest.v2.policy.RequestPolicy;
import com.microsoft.rest.v2.policy.UserAgentPolicy;
import org.junit.Assert;
import org.junit.Test;

import rx.Single;

import java.util.Collections;

public class UserAgentTests {
    @Test
    public void defaultUserAgentTests() throws Exception {
        HttpClient client = new HttpClient(Collections.<RequestPolicy.Factory>singletonList(new UserAgentPolicy.Factory("AutoRest-Java"))) {
            @Override
            public Single<? extends HttpResponse> sendRequestInternalAsync(HttpRequest request) {
                Assert.assertEquals(
                        request.headers().value("User-Agent"),
                        "AutoRest-Java");
                return Single.<HttpResponse>just(new MockHttpResponse(200));
            }
        };

        HttpResponse response = client.sendRequest(new HttpRequest(
                "defaultUserAgentTests",
                "GET", "http://localhost"));

        Assert.assertEquals(200, response.statusCode());
    }

    @Test
    public void customUserAgentTests() throws Exception {
        HttpClient client = new HttpClient(Collections.<RequestPolicy.Factory>singletonList(new UserAgentPolicy.Factory("Awesome"))) {
            @Override
            public Single<HttpResponse> sendRequestInternalAsync(HttpRequest request) {
                String header = request.headers().value("User-Agent");
                Assert.assertEquals("Awesome", header);
                return Single.<HttpResponse>just(new MockHttpResponse(200));
            }
        };

        HttpResponse response = client.sendRequest(new HttpRequest("customUserAgentTests", "GET", "http://localhost"));
        Assert.assertEquals(200, response.statusCode());
    }
}
