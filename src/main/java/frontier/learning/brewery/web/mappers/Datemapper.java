package frontier.learning.brewery.web.mappers;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Component;

/*Converting Date format to-fro (BeerDTO and Beer) ie: Timestamp and OffsetDateTime*/
@Component
public class Datemapper {

	public OffsetDateTime asOffsetDateTime(Timestamp timestamp) {
		return timestamp != null ? OffsetDateTime.of(timestamp.toLocalDateTime().getYear(),
				timestamp.toLocalDateTime().getMonthValue(), timestamp.toLocalDateTime().getDayOfMonth(),
				timestamp.toLocalDateTime().getHour(), timestamp.toLocalDateTime().getMinute(),
				timestamp.toLocalDateTime().getSecond(), timestamp.toLocalDateTime().getNano(), ZoneOffset.UTC) : null;
	}

	public Timestamp asTimestamp(OffsetDateTime offsetDateTime) {
		return offsetDateTime != null
				? Timestamp.valueOf(offsetDateTime.atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime())
				: null;
	}

}
