package frontier.learning.brewery.assignment;

import org.mapstruct.Mapper;

import frontier.learning.brewery.domain.Customer;

@Mapper
public interface CustomerMapper {

	CustomerDTO customerToCustomerDTO(Customer customer);

	Customer customerDTOToCustomer(CustomerDTO CustomerDTO);

}
