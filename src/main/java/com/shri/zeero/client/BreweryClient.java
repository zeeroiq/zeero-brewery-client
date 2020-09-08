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

    // get request
    public BeerDto getBeerById(UUID beerId) {
        return restTemplate.getForObject(apihost + BEER_API_V1 + beerId.toString(), BeerDto.class);
    }

    // post request
    public URI addBeer(BeerDto beer) {
        return restTemplate.postForLocation(apihost + BEER_API_V1, beer);
    }

    // put request
    public void updateBeer(UUID id, BeerDto beerDto) {
        restTemplate.put(apihost + BEER_API_V1 + id.toString(), beerDto);
    }

    // delete request
    public void deleteBeer(UUID id) {
        restTemplate.delete(apihost + BEER_API_V1 + id.toString());
    }


    // get request
    public CustomerDto getClientById(UUID clientId) {
        return restTemplate.getForObject(apihost + CUSTOMER_API_V1 + clientId, CustomerDto.class);
    }

    // post request
    public URI addCustomer(CustomerDto dto) {
        return restTemplate.postForLocation(apihost + CUSTOMER_API_V1, dto);
    }

    // put request
    public void updateCustomer(UUID id, CustomerDto dto) {
        restTemplate.put(apihost + CUSTOMER_API_V1 + id.toString(), dto);
    }

    // delete request
    public void deleteCustomer(UUID id) {
        restTemplate.delete(apihost + CUSTOMER_API_V1 + id.toString());
    }
}
