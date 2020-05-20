package brewerydemo.brewery.services.v2;

import brewerydemo.brewery.services.BeerService;
import brewerydemo.brewery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@Slf4j
public class BeerServicev2Implv2 implements BeerServicev2 {

        @Override
        public BeerDto getBeerById(UUID beerId) {
            return BeerDto.builder().id(UUID.randomUUID()).
                    beerName("Galaxy Cat")
                    .beerStyle("Pale Ale")
                    .build();
        }

        @Override
        public BeerDto savedNewBeer(BeerDto beerDto) {
            return BeerDto.builder()
                    .id(UUID.randomUUID())
                    .build();
        }

        @Override
        public void updateBeer(UUID beerId, BeerDto beerDto) {
            //to-do
        }

        @Override
        public void deleteBeer(UUID beerId) {
            log.debug("Deleting beer...");
        }
    }


