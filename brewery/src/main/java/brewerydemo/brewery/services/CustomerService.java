package brewerydemo.brewery.services;

import brewerydemo.brewery.web.model.CustomerDTO;

import java.util.UUID;

public interface CustomerService {
    CustomerDTO getCustById(UUID id);
    CustomerDTO handlePost(CustomerDTO customerDTO);
    void deleteCustomer(UUID custId);
    void updateCustomer(UUID customerId, CustomerDTO customerDTO);
}
