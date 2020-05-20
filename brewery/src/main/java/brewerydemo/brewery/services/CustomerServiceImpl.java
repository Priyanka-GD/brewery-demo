package brewerydemo.brewery.services;

import brewerydemo.brewery.web.model.CustomerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDTO getCustById(UUID id) {
        return CustomerDTO.builder().custId(UUID.randomUUID())
                .custName("Kristen").build();
    }

    @Override
    public CustomerDTO handlePost(CustomerDTO customerDTO) {
        return CustomerDTO.builder()
                .custId(UUID.randomUUID())
                .build();
    }


    @Override
    public void deleteCustomer(UUID custId) {
        log.debug("Deleting customer..");
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDTO customerDTO) {

    }
}
