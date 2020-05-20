package brewerydemo.brewery.web.controller.v2;

import brewerydemo.brewery.services.BeerService;
import brewerydemo.brewery.services.v2.BeerServicev2;
import brewerydemo.brewery.web.model.BeerDto;
import brewerydemo.brewery.web.model.v2.BeerDtov2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v2/beer")
public class BeerControllerv2 {

    public final BeerServicev2 beerservice;

    public BeerControllerv2(BeerServicev2 beerservice) {
        this.beerservice = beerservice;
    }


    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDtov2> getBeer(@PathVariable("beerId") UUID beerId){

        return new ResponseEntity<>(beerservice.getBeerById(beerId), HttpStatus.OK);

    }
    @PostMapping
    public ResponseEntity handlePost(@RequestBody BeerDtov2 beerDto)
    {
        BeerDtov2 savedDto=beerservice.savedNewBeer(beerDto);
        HttpHeaders headers=new HttpHeaders();
        headers.add("Location","/api/v2/beer"+ savedDto.getId().toString());
        return new ResponseEntity(headers,HttpStatus.CREATED);
    }
    @PutMapping({"/{beerId}"})
    public ResponseEntity updateBeer(@PathVariable("beerId") UUID beerId,@RequestBody BeerDtov2 beerDto)
    {
        beerservice.updateBeer(beerId,beerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId")UUID beerId)
    {
        beerservice.deleteBeer(beerId);
    }
}

