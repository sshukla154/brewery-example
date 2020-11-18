package frontier.learning.brewery.example.services;

import java.util.UUID;

import frontier.learning.brewery.example.web.model.BeerDTO;

public interface BeerService {

	BeerDTO getBeerById(UUID beerId);

	BeerDTO saveNewBeer(BeerDTO beerDTO);

	void updateBeer(UUID beerId, BeerDTO beerDTO);

	void deleteById(UUID beerId);

}
