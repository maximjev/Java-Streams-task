import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.Duration;
import java.util.List;

@Getter
@EqualsAndHashCode
class Sector {

	private final Duration duration;

	private final List<Segment> segments;

	Sector(Duration duration, List<Segment> segments) {
		this.duration = duration;
		this.segments = segments;
	}
}
