import lombok.Getter;

import java.util.List;

@Getter
class Results {

	private final List<Offer> offers;

	Results(List<Offer> offers) {
		this.offers = offers;
	}

	List<Offer> getOffers() {
		return offers;
	}
}
