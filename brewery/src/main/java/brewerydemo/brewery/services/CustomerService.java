package brewerydemo.brewery.services;

import brewerydemo.brewery.web.model.CustomerDTO;

import java.util.UUID;

public interface CustomerService {
    CustomerDTO getCustomerById(UUID id);
    CustomerDTO handlePost(CustomerDTO customerDTO);
    void deleteCustomer(UUID customerId);
    void updateCustomer(UUID customerId, CustomerDTO customerDTO);
}
