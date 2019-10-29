import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@EqualsAndHashCode
class Offer {

	private final String id;

	private final BigDecimal price;

	private final List<Sector> sectors;

	Offer(String id, BigDecimal price, List<Sector> sectors) {
		this.id = id;
		this.price = price;
		this.sectors = sectors;
	}
}
