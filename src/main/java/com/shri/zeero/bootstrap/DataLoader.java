package com.shri.zeero.bootstrap;

import com.shri.zeero.domain.Beer;
import com.shri.zeero.repository.BeerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by zeeroiq on 9/8/20, 5:17 AM
 */

@Component
@Slf4j
public class DataLoader implements CommandLineRunner {

    private final BeerRepository repository;

    public DataLoader(BeerRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadObjects();
    }

    private void loadObjects() {

        if(repository.count() == 0) {
            repository.save(Beer.builder()
                    .beerName("CORONA")
                    .beerStyle("PALE_LAGER")
                    .quantityToBrew(200)
                    .minOnHand(20)
                    .upc(32321232132L)
                    .price(new BigDecimal("120.00"))
                    .build());
            repository.save(Beer.builder()
                    .beerName("BIRA")
                    .beerStyle("LAGER")
                    .quantityToBrew(100)
                    .minOnHand(25)
                    .upc(3232123431320L)
                    .price(new BigDecimal("130.00"))
                    .build());
            repository.save(Beer.builder()
                    .beerName("TUBORG")
                    .beerStyle("MALT")
                    .quantityToBrew(10)
                    .minOnHand(20)
                    .upc(323212343132L)
                    .price(new BigDecimal("190.00"))
                    .build());

            log.debug(">>>>> Number of beers in inventory: "+ repository.count());
        }
    }
}
