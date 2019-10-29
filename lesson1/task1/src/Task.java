import java.time.Duration;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.rangeClosed;

class Task {

    static Offer getShortestOffer(Results results) {
        return results.getOffers()
                .stream()
                .min(comparing(o -> o.getSectors()
                                .stream()
                                .map(Sector::getDuration)
                                .reduce(Duration.ZERO, Duration::plus),
                        Duration::compareTo))
                .orElse(null);
    }

    static List<Segment> getListOfDistinctSegments(Results results) {
        return results
                .getOffers()
                .stream()
                .flatMap(o -> o.getSectors().stream())
                .flatMap(s -> s.getSegments().stream())
                .distinct()
                .collect(toList());
    }

    static List<List<Sector>> getDistinctSectorsGroupedByIndex(Results results) {
        return rangeClosed(0, 1)
                .mapToObj(i -> results.getOffers()
                        .stream()
                        .map(Offer::getSectors)
                        .filter(s -> s.size() > i)
                        .map(s -> s.get(i))
                        .distinct()
                        .collect(toList()))
                .filter(l -> !l.isEmpty())
                .collect(toList());
    }
}