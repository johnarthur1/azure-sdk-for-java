package com.microsoft.rest.v2;

import com.microsoft.rest.v2.http.ChannelHandlerConfig;
import com.microsoft.rest.v2.http.HttpClient;
import com.microsoft.rest.v2.http.RxNettyAdapter;
import com.microsoft.rest.v2.policy.RequestPolicy;

import java.util.Collections;

public class RestProxyWithRxNettyTests extends RestProxyTests {
    @Override
    protected HttpClient createHttpClient() {
        return new RxNettyAdapter(Collections.<RequestPolicy.Factory>emptyList(), Collections.<ChannelHandlerConfig>emptyList());
    }
}
