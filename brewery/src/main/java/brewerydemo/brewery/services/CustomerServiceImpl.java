package brewerydemo.brewery.services;

import brewerydemo.brewery.web.model.CustomerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDTO getCustomerById(UUID id) {
        return CustomerDTO.builder().customerId(UUID.randomUUID())
                .customerName("Kristen").build();
    }

    @Override
    public CustomerDTO handlePost(CustomerDTO customerDTO) {
        return CustomerDTO.builder()
                .customerId(UUID.randomUUID())
                .build();
    }


    @Override
    public void deleteCustomer(UUID customerId) {
        log.debug("Deleting customer..");
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDTO customerDTO) {

    }
}
