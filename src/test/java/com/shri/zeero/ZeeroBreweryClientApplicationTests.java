package com.shri.zeero;

import com.shri.zeero.client.BreweryClient;
import com.shri.zeero.model.BeerDto;
import com.shri.zeero.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ZeeroBreweryClientApplicationTests {

    @Autowired
    BreweryClient breweryClient;

    @Test
    void contextLoads() {
    }

    @Test
    void getBeerById() {
        BeerDto beer = breweryClient.getBeerById(UUID.randomUUID());
        assertNotNull(beer);
    }

    @Test
    void addBeer() {
        BeerDto beerDto = BeerDto.builder().beerName("Corona").build();
        URI uri = breweryClient.addBeer(beerDto);
        assertNotNull(uri);
        System.out.println(">>>>> uri from rest call: "+ uri.toASCIIString());
    }

    @Test
    void updateBeer() {
        BeerDto beer = BeerDto.builder().build();
        breweryClient.updateBeer(UUID.randomUUID(), beer);
    }

    @Test
    void deleteBeer() {
        breweryClient.deleteBeer(UUID.randomUUID());
    }

    @Test
    void getClientById() {
        CustomerDto dto = breweryClient.getClientById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void addCustomer() {
        CustomerDto dto = CustomerDto.builder().name("Zeero").build();
        URI uri = breweryClient.addCustomer(dto);
        assertNotNull(uri);
        System.out.println(">>>>> uri from rest call: "+ uri.toASCIIString());
    }

    @Test
    void updateClient() {
        CustomerDto dto = CustomerDto.builder().build();
        breweryClient.updateCustomer(UUID.randomUUID(), dto);
    }

    @Test
    void deleteClient() {
        breweryClient.deleteCustomer(UUID.randomUUID());
    }
}
