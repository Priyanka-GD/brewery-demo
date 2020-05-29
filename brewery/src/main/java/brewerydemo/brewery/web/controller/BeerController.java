package brewerydemo.brewery.web.controller;

import brewerydemo.brewery.services.BeerService;
import brewerydemo.brewery.web.model.BeerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Validated
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    public final BeerService beerservice;

    public BeerController(BeerService beerservice) {
        this.beerservice = beerservice;
    }


    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId){

        return new ResponseEntity<>(beerservice.getBeerById(beerId), HttpStatus.OK);

    }
    @PostMapping
    public ResponseEntity handlePost(@Valid @RequestBody BeerDto beerDto)
    {
        BeerDto savedDto=beerservice.savedNewBeer(beerDto);
        HttpHeaders headers=new HttpHeaders();
        headers.add("Location","http://localhost:8080/api/v1/beer"+ savedDto.getId().toString());
        return new ResponseEntity(headers,HttpStatus.CREATED);
    }
   @PutMapping({"/{beerId}"})
    public ResponseEntity updateBeer(@PathVariable("beerId") UUID beerId,@Valid @RequestBody BeerDto beerDto)
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
