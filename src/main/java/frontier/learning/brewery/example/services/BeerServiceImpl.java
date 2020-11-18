package frontier.learning.brewery.example.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import frontier.learning.brewery.example.web.model.BeerDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

	@Override
	public BeerDTO getBeerById(UUID beerId) {
		log.debug("Get a beer...");
		return BeerDTO.builder().id(UUID.randomUUID()).beerName("Galaxy Cat").beerStyle("Pale Ale").build();
	}

	@Override
	public BeerDTO saveNewBeer(BeerDTO beerDTO) {
		log.debug("Save a new beer...");
		return BeerDTO.builder().id(UUID.randomUUID()).build();		
	}

	@Override
	public void updateBeer(UUID beerId, BeerDTO beerDTO) {
		log.debug("Updating a beer...");
		// TODO :  Would add a real implementation to update beer
	}

	@Override
	public void deleteById(UUID beerId) {
		log.debug("Deleting a beer...");
		
	}

}
