package frontier.learning.brewery.services;

import java.util.UUID;

import frontier.learning.brewery.web.model.BeerDTO;

public interface BeerService {

	BeerDTO getBeerById(UUID beerId);

	BeerDTO saveNewBeer(BeerDTO beerDTO);

	void updateBeer(UUID beerId, BeerDTO beerDTO);

	void deleteById(UUID beerId);

}
