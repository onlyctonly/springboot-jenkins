package com.example.beer.service;

import com.example.beer.dto.BeerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public void updateBeer(UUID beerId, BeerDTO beerDTO) {
        log.info("update {}", beerId);
    }

    @Override
    public void deleteBeer(UUID beerId) {
        log.info("delete {}", beerId);
    }

    @Override
    public BeerDTO getBeerById(UUID beerId) {
        return BeerDTO.builder().id(UUID.randomUUID())
                .beerName("helloBeer")
                .beerStyle("helloStyle")
                .upc(3l)
                .build();
    }

    @Override
    public BeerDTO saveNewBeer(BeerDTO beerDTO) {
        return BeerDTO.builder().id(UUID.randomUUID())
                .beerName("newBeer")
                .beerStyle("newStyle")
                .upc(3l)
                .build();
    }
}
