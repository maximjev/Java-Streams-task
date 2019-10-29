import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Supplier;

import static java.time.temporal.ChronoUnit.HOURS;

class ResultsService {

	static final Supplier<Segment> SEG_AMS_LHR_KLM = () -> new Segment(
			"KLM-1",
			"AMS",
			"LHR",
			LocalDateTime.of(2020, 8, 15, 8, 0, 0),
			LocalDateTime.of(2020, 8, 15, 9, 0, 0),
			Duration.of(2, HOURS)
	);

	static final Supplier<Segment> SEG_LHR_AMS_KLM = () -> new Segment(
			"KLM-1",
			"LHR",
			"AMS",
			LocalDateTime.of(2020, 8, 20, 17, 0, 0),
			LocalDateTime.of(2020, 8, 20, 20, 0, 0),
			Duration.of(2, HOURS)
	);


	static final Supplier<Segment> SEG_AMS_CDG_AF = () -> new Segment(
			"AF-1",
			"AMS",
			"CDG",
			LocalDateTime.of(2020, 8, 15, 7, 0, 0),
			LocalDateTime.of(2020, 8, 15, 8, 0, 0),
			Duration.of(1, HOURS)
	);

	static final Supplier<Segment> SEG_CDG_LHR_AF = () -> new Segment(
			"AF-2",
			"CDG",
			"LHR",
			LocalDateTime.of(2020, 8, 15, 9, 0, 0),
			LocalDateTime.of(2020, 8, 15, 9, 0, 0),
			Duration.of(1, HOURS)
	);

	static final Supplier<Segment> SEG_LHR_CDG_AF = () -> new Segment(
			"AF-3",
			"LHR",
			"CDG",
			LocalDateTime.of(2020, 8, 20, 18, 0, 0),
			LocalDateTime.of(2020, 8, 20, 20, 0, 0),
			Duration.of(1, HOURS)
	);

	static final Supplier<Segment> SEG_CDG_AMS_AF = () -> new Segment(
			"AF-4",
			"CDG",
			"AMS",
			LocalDateTime.of(2020, 8, 20, 21, 0, 0),
			LocalDateTime.of(2020, 8, 20, 22, 0, 0),
			Duration.of(1, HOURS)
	);

	static final Supplier<Segment> SEG_AMS_FRA_LH = () -> new Segment(
			"LH-1",
			"AMS",
			"FRA",
			LocalDateTime.of(2020, 8, 15, 8, 0, 0),
			LocalDateTime.of(2020, 8, 15, 9, 0, 0),
			Duration.of(1, HOURS)
	);

	static final Supplier<Segment> SEG_FRA_LHR_LH = () -> new Segment(
			"LH-2",
			"FRA",
			"LHR",
			LocalDateTime.of(2020, 8, 15, 10, 0, 0),
			LocalDateTime.of(2020, 8, 15, 10, 0, 0),
			Duration.of(1, HOURS)
	);

	static final Supplier<Segment> SEG_LHR_FRA_LH = () -> new Segment(
			"LH-3",
			"LHR",
			"FRA",
			LocalDateTime.of(2020, 8, 20, 18, 0, 0),
			LocalDateTime.of(2020, 8, 20, 20, 0, 0),
			Duration.of(1, HOURS)
	);

	static final Supplier<Segment> SEG_FRA_AMS_LH = () -> new Segment(
			"LH-4",
			"FRA",
			"LHR",
			LocalDateTime.of(2020, 8, 20, 21, 0, 0),
			LocalDateTime.of(2020, 8, 20, 22, 0, 0),
			Duration.of(1, HOURS)
	);

	static final Supplier<Sector> SEC_OUT_KLM = () -> new Sector(Duration.of(2, HOURS), List.of(SEG_AMS_LHR_KLM.get()));

	static final Supplier<Sector> SEC_IN_KLM = () -> new Sector(Duration.of(2, HOURS), List.of(SEG_LHR_AMS_KLM.get()));

	static final Supplier<Sector> SEC_OUT_AF = () -> new Sector(Duration.of(3, HOURS), List.of(SEG_AMS_CDG_AF.get(), SEG_CDG_LHR_AF.get()));

	static final Supplier<Sector> SEC_IN_AF = () -> new Sector(Duration.of(3, HOURS), List.of(SEG_LHR_CDG_AF.get(), SEG_CDG_AMS_AF.get()));

	static final Supplier<Sector> SEC_OUT_LH = () -> new Sector(Duration.of(3, HOURS), List.of(SEG_AMS_FRA_LH.get(), SEG_FRA_LHR_LH.get()));

	static final Supplier<Sector> SEC_IN_LH = () -> new Sector(Duration.of(3, HOURS), List.of(SEG_LHR_FRA_LH.get(), SEG_FRA_AMS_LH.get()));


	static final Supplier<Offer> OFFER_KLM = () -> new Offer(
			"KLM",
			BigDecimal.valueOf(200L),
			List.of(SEC_OUT_KLM.get(), SEC_IN_KLM.get())
	);

	static final Supplier<Offer> OFFER_AF = () -> new Offer(
			"KLM-AF",
			BigDecimal.valueOf(120L),
			List.of(SEC_OUT_AF.get(), SEC_IN_AF.get())
	);

	static final Supplier<Offer> OFFER_KLM_AF = () -> new Offer(
			"KLM-AF",
			BigDecimal.valueOf(150L),
			List.of(SEC_OUT_KLM.get(), SEC_IN_AF.get())
	);

	static final Supplier<Offer> OFFER_AF_KLM = () -> new Offer(
			"KLM-AF",
			BigDecimal.valueOf(155L),
			List.of(SEC_OUT_AF.get(), SEC_IN_KLM.get())
	);

	static final Supplier<Offer> OFFER_LH = () -> new Offer(
			"LH",
			BigDecimal.valueOf(119L),
			List.of(SEC_OUT_LH.get(), SEC_IN_LH.get())
	);

	static final Supplier<Offer> OFFER_OW_KLM = () -> new Offer(
			"KLM",
			BigDecimal.valueOf(100L),
			List.of(SEC_OUT_KLM.get())
	);

	static final Supplier<Offer> OFFER_OW_AF = () -> new Offer(
			"KLM-AF",
			BigDecimal.valueOf(60L),
			List.of(SEC_OUT_AF.get())
	);

	static final Supplier<Offer> OFFER_OW_KLM_AF = () -> new Offer(
			"KLM-AF",
			BigDecimal.valueOf(75L),
			List.of(SEC_OUT_KLM.get())
	);

	static final Supplier<Offer> OFFER_OW_AF_KLM = () -> new Offer(
			"KLM-AF",
			BigDecimal.valueOf(78L),
			List.of(SEC_OUT_AF.get())
	);

	static final Supplier<Offer> OFFER_OW_LH = () -> new Offer(
			"LH",
			BigDecimal.valueOf(59L),
			List.of(SEC_OUT_LH.get())
	);


	static Results getRoundTripResults() {
		return new Results(List.of(
				OFFER_KLM.get(),
				OFFER_AF.get(),
				OFFER_KLM_AF.get(),
				OFFER_AF_KLM.get(),
				OFFER_LH.get()
		));
	}

	static Results getOneWayResults() {
		return new Results(List.of(
				OFFER_OW_KLM.get(),
				OFFER_OW_AF.get(),
				OFFER_OW_KLM_AF.get(),
				OFFER_OW_AF_KLM.get(),
				OFFER_OW_LH.get()
		));
	}

	static Results getEmptyResults() {
		return new Results(List.of());
	}

	static List<Segment> getAllSegments() {
		return List.of(
				SEG_AMS_LHR_KLM.get(),
				SEG_LHR_AMS_KLM.get(),
				SEG_AMS_CDG_AF.get(),
				SEG_CDG_LHR_AF.get(),
				SEG_LHR_CDG_AF.get(),
				SEG_CDG_AMS_AF.get(),
				SEG_FRA_LHR_LH.get(),
				SEG_FRA_AMS_LH.get(),
				SEG_AMS_FRA_LH.get(),
				SEG_LHR_FRA_LH.get()
		);
	}

	static List<Segment> getOutBoundSegments() {
		return List.of(
				SEG_AMS_LHR_KLM.get(),
				SEG_AMS_CDG_AF.get(),
				SEG_CDG_LHR_AF.get(),
				SEG_FRA_LHR_LH.get(),
				SEG_AMS_FRA_LH.get()
		);
	}


	static List<Sector> getOutboundSectors() {
		return List.of(
				SEC_OUT_AF.get(),
				SEC_OUT_KLM.get(),
				SEC_OUT_LH.get()
		);
	}

	static List<Sector> getInboundSectors() {
		return List.of(
				SEC_IN_AF.get(),
				SEC_IN_KLM.get(),
				SEC_IN_LH.get()
		);
	}
}
