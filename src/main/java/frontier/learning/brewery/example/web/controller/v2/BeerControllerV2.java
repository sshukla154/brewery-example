package frontier.learning.brewery.example.web.controller.v2;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import frontier.learning.brewery.example.services.v2.BeerServiceV2;
import frontier.learning.brewery.example.web.model.v2.BeerDTOV2;
import lombok.RequiredArgsConstructor;
import lombok.val;
import lombok.var;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {

	private final BeerServiceV2 beerServiceV2;

//	public BeerControllerV2(BeerServiceV2 beerServiceV2) {
//		this.beerServiceV2 = beerServiceV2;
//	}

	@GetMapping("/{beerId}")
	public ResponseEntity<BeerDTOV2> getBeer(@PathVariable("beerId") UUID beerId) {
		log.debug("BeerControllerV2.getBeer()---");
		return new ResponseEntity<>(beerServiceV2.getBeerById(beerId), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<BeerDTOV2> saveNewBeer(@RequestBody BeerDTOV2 beerDTOV2) {
		log.debug("BeerControllerV2.saveNewBeer()---");
		//BeerDTOV2 savedBeer = beerServiceV2.saveNewBeer(beerDTOV2);
		val savedBeer = beerServiceV2.saveNewBeer(beerDTOV2);
		//HttpHeaders httpHeaders = new HttpHeaders();
		var httpHeaders = new HttpHeaders();
		// Add hostname to URL
		httpHeaders.add("Location", "/api/v2/beer" + savedBeer.getId().toString());

		return new ResponseEntity<BeerDTOV2>(httpHeaders, HttpStatus.CREATED);
	}

	/* We can use @ResponseStatus */
	@PutMapping("/{beerId}")
	public ResponseEntity<BeerDTOV2> handleUpdate(@PathVariable("beerId") UUID beerId, @RequestBody BeerDTOV2 beerDTOV2) {
		log.debug("BeerControllerV2.handleUpdate()---");
		beerServiceV2.updateBeer(beerId, beerDTOV2);
		return new ResponseEntity<BeerDTOV2>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/{beerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBeer(@PathVariable UUID beerId) {
		log.debug("BeerControllerV2.deleteBeer()---");
		beerServiceV2.deleteById(beerId);
	}

}
