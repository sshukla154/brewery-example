package frontier.learning.brewery.example.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import frontier.learning.brewery.example.web.model.BeerDTO;

@Service
public class BeerServiceImpl implements BeerService {

	@Override
	public BeerDTO getBeerById(UUID beerId) {
		return BeerDTO.builder().id(UUID.randomUUID()).beerName("Galaxy Cat").beerStyle("Pale Ale").build();
	}

	@Override
	public BeerDTO saveNewBeer(BeerDTO beerDTO) {
		return BeerDTO.builder().id(UUID.randomUUID()).build();		
	}

	@Override
	public void updateBeer(UUID beerId, BeerDTO beerDTO) {
		// TODO :  Would add a real implementation to update beer
	}

}
