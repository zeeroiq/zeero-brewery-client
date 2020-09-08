package com.shri.zeero.config;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by zeeroiq on 9/8/20, 4:20 AM
 */
@Component
public class BlockingRestTemplateCustomizer implements RestTemplateCustomizer {

    private final int maxTotalConnection;
    private final int defaultMaxTotalConnection;
    private final int connectionRequestTimeout;
    private final int socketTimeout;

    public BlockingRestTemplateCustomizer(@Value("${zeero.maxTotalConnection}") int maxTotalConnection,
                                          @Value("${zeero.defaultMaxTotalConnection}") int defaultMaxTotalConnection,
                                          @Value("${zeero.connectionRequestTimeout}") int connectionRequestTimeout,
                                          @Value("${zeero.socketTimeout}") int socketTimeout) {
        this.maxTotalConnection = maxTotalConnection;
        this.defaultMaxTotalConnection = defaultMaxTotalConnection;
        this.connectionRequestTimeout = connectionRequestTimeout;
        this.socketTimeout = socketTimeout;
    }

    @Override
    public void customize(RestTemplate restTemplate) {
        restTemplate.setRequestFactory(this.clientHttpRequestFactory());
    }

    private ClientHttpRequestFactory clientHttpRequestFactory() {

        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(maxTotalConnection);
        connectionManager.setDefaultMaxPerRoute(defaultMaxTotalConnection);

        RequestConfig requestConfig = RequestConfig
                .custom()
                .setConnectionRequestTimeout(connectionRequestTimeout)
                .setSocketTimeout(socketTimeout)
                .build();
        CloseableHttpClient httpClient = HttpClients
                .custom()
                .setConnectionManager(connectionManager)
                .setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy())
                .setDefaultRequestConfig(requestConfig)
                .build();

        return new HttpComponentsClientHttpRequestFactory(httpClient);
    }
}
