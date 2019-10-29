import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Tests {

	@Test
	public void testGetShortestOffer() {
		Offer shortestOffer = Task.getShortestOffer(ResultsService.getRoundTripResults());
		assertThat(shortestOffer.getId()).isEqualTo(ResultsService.OFFER_KLM.get().getId());
	}

	@Test
	public void testGetShortestOfferOneWay() {
		Offer shortestOffer = Task.getShortestOffer(ResultsService.getOneWayResults());
		assertThat(shortestOffer.getId()).isEqualTo(ResultsService.OFFER_OW_KLM.get().getId());
	}

	@Test
	public void testGetShortestOfferEmptyResults() {
		Offer shortestOffer = Task.getShortestOffer(ResultsService.getEmptyResults());
		assertThat(shortestOffer).isNull();
	}

	@Test
	public void testGetListOfDistinctSegments() {
		List<Segment> distinctSegments = Task.getListOfDistinctSegments(ResultsService.getRoundTripResults());
		assertThat(distinctSegments).hasSize(10);
		assertThat(distinctSegments).doesNotHaveDuplicates();
		assertThat(distinctSegments).containsExactlyInAnyOrderElementsOf(ResultsService.getAllSegments());
	}

	@Test
	public void testGetListOfDistinctSegmentsOneWay() {
		List<Segment> distinctSegments = Task.getListOfDistinctSegments(ResultsService.getOneWayResults());
		assertThat(distinctSegments).hasSize(5);
		assertThat(distinctSegments).doesNotHaveDuplicates();
		assertThat(distinctSegments).containsExactlyInAnyOrderElementsOf(ResultsService.getOutBoundSegments());
	}

	@Test
	public void testGetListOfDistinctSegmentsEmptyResults() {
		List<Segment> distinctSegments = Task.getListOfDistinctSegments(ResultsService.getEmptyResults());
		assertThat(distinctSegments).hasSize(0);
	}

	@Test
	public void testGetDistinctSectorsGroupedByIndex() {
		List<List<Sector>> sectorsGroupedByIndex = Task.getDistinctSectorsGroupedByIndex(ResultsService.getRoundTripResults());
		assertThat(sectorsGroupedByIndex).hasSize(2);
		sectorsGroupedByIndex.forEach(sectorsPerIndex -> {
			assertThat(sectorsPerIndex).hasSize(3);
		});
		assertThat(sectorsGroupedByIndex.get(0)).containsExactlyInAnyOrderElementsOf(ResultsService.getOutboundSectors());
		assertThat(sectorsGroupedByIndex.get(1)).containsExactlyInAnyOrderElementsOf(ResultsService.getInboundSectors());
	}

	@Test
	public void testGetDistinctSectorsGroupedByIndexOneWay() {
		List<List<Sector>> sectorsGroupedByIndex = Task.getDistinctSectorsGroupedByIndex(ResultsService.getOneWayResults());
		assertThat(sectorsGroupedByIndex).hasSize(1);
		assertThat(sectorsGroupedByIndex.get(0)).hasSize(3);
		assertThat(sectorsGroupedByIndex.get(0)).containsExactlyInAnyOrderElementsOf(ResultsService.getOutboundSectors());
	}

	@Test
	public void testGetDistinctSectorsGroupedByIndexEmptyResults() {
		List<List<Sector>> sectorsGroupedByIndex = Task.getDistinctSectorsGroupedByIndex(ResultsService.getEmptyResults());
		assertThat(sectorsGroupedByIndex).hasSize(0);
	}
}