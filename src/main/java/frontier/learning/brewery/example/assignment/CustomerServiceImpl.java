package frontier.learning.brewery.example.assignment;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Override
	public CustomerDTO getCustomerById(UUID customerId) {
		return CustomerDTO.builder().id(UUID.randomUUID()).name("SShukla154").build();
	}

}
