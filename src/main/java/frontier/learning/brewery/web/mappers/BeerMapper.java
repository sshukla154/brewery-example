package frontier.learning.brewery.web.mappers;

import org.mapstruct.Mapper;

import frontier.learning.brewery.domain.Beer;
import frontier.learning.brewery.web.model.BeerDTO;

@Mapper
public interface BeerMapper {

	BeerDTO beerToBeerDTO(Beer beer);

	BeerDTO beerToBeerDTO(BeerDTO beerDTO);

}
