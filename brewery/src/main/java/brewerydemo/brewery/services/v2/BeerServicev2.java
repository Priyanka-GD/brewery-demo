package brewerydemo.brewery.services.v2;

import brewerydemo.brewery.web.model.v2.BeerDtov2;

import java.util.UUID;

public interface BeerServicev2 {
    BeerDtov2 getBeerById(UUID beerId);

    BeerDtov2 savedNewBeer(BeerDtov2 beerDto);

    void updateBeer(UUID beerId, BeerDtov2 beerDto);

    void deleteBeer(UUID beerId);

}
