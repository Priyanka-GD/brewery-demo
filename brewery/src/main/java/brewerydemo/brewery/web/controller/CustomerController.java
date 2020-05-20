package brewerydemo.brewery.web.controller;

import brewerydemo.brewery.services.CustomerService;
import brewerydemo.brewery.web.model.CustomerDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    public final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping({"/{customerId}"})
        public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable("customerId")UUID customerId)
            {
               return new ResponseEntity<>(customerService.getCustById(customerId), HttpStatus.OK);
            }
    @PostMapping
    public ResponseEntity handlePost(@RequestBody CustomerDTO customerDTO)
    {
        CustomerDTO saveNewCust=customerService.handlePost(customerDTO);
        HttpHeaders headers=new HttpHeaders();
        headers.add("Customer","/api/v1/customer"+saveNewCust.getCustId().toString());
        return new ResponseEntity(headers,HttpStatus.CREATED);
    }
    @PutMapping({"/{customerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@PathVariable("customerId") UUID customerId,@RequestBody CustomerDTO customerDTO)
    {
       customerService.updateCustomer(customerId,customerDTO) ;
    }
    @DeleteMapping({"/{customerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable("customerId") UUID customerId)
    {
        customerService.deleteCustomer(customerId) ;
    }
}
