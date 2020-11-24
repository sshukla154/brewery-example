package frontier.learning.brewery.example.web.controller;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import frontier.learning.brewery.example.services.BeerService;
import frontier.learning.brewery.example.web.model.BeerDTO;

@Deprecated
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

	private final BeerService beerService;

	public BeerController(BeerService beerService) {
		this.beerService = beerService;
	}

	@GetMapping("/{beerId}")
	public ResponseEntity<BeerDTO> getBeer(@PathVariable("beerId") UUID beerId) {
		return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<BeerDTO> saveNewBeer(@Validated @RequestBody BeerDTO beerDTO) {
		BeerDTO savedBeer = beerService.saveNewBeer(beerDTO);

		HttpHeaders httpHeaders = new HttpHeaders();
		// Add hostname to URL
		httpHeaders.add("Location", "/api/v1/beer" + savedBeer.getId().toString());

		return new ResponseEntity<BeerDTO>(httpHeaders, HttpStatus.CREATED);
	}

	/*We can use @ResponseStatus*/
	@PutMapping("/{beerId}")
	public ResponseEntity<BeerDTO> handleUpdate(@PathVariable("beerId") UUID beerId, @Validated @RequestBody BeerDTO beerDTO) {
		beerService.updateBeer(beerId, beerDTO);
		return new ResponseEntity<BeerDTO>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/{beerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBeer(@PathVariable UUID beerId) {
		beerService.deleteById(beerId);
	}

}
