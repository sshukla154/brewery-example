package frontier.learning.brewery.domain;

import java.sql.Timestamp;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Beer {

	private UUID id;

	private String beerName;

	private String beerStyle;

	private Long upc;

	// Preferred dateTime for database
	private Timestamp createdDate;

	private Timestamp lastUpdatedDate;

}
