package frontier.learning.brewery.web.mappers;

import org.mapstruct.Mapper;

import frontier.learning.brewery.domain.Beer;
import frontier.learning.brewery.web.model.BeerDTO;

@Mapper(uses= {Datemapper.class})
public interface BeerMapper {

	BeerDTO beerToBeerDTO(Beer beer);

	Beer beerDTOToBeer(BeerDTO beerDTO);

}
