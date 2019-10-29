import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.Duration;
import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode
class Segment {

	private final String flightNumber;

	private final String origin;

	private final String destination;

	private final LocalDateTime departureTime;

	private final LocalDateTime arrivalTime;

	private final Duration flightDuration;


	Segment(
			String flightNumber,
			String origin,
			String destination,
			LocalDateTime departureTime,
			LocalDateTime arrivalTime,
			Duration flightDuration
	) {
		this.flightNumber = flightNumber;
		this.origin = origin;
		this.destination = destination;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.flightDuration = flightDuration;
	}
}
