package com.shri.zeero.client;

import com.shri.zeero.model.BeerDto;
import com.shri.zeero.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

/**
 * Created by zeeroiq on 9/8/20, 2:51 AM
 */
@Component
@ConfigurationProperties(value = "zeero.brewery", ignoreUnknownFields = false)
public class BreweryClient {

    private final String BEER_API_V1 = "/api/v1/beer/";
    private final String CUSTOMER_API_V1 = "/api/v1/customer/";
    private String apihost;
    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }
}
