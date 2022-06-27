package oyster.rules;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import java.util.OptionalDouble;
import oyster.model.Trip;
import oyster.model.TripType;

public class Engine {

    private Rules rules;

    public Engine() {
        registerRules();
    }

    public OptionalDouble applyRules(Trip trip) {
        return rules.getRules().stream()
                .filter(r -> r.apply(trip))
                .mapToDouble(r -> r.getPrice())
                .min();
    }

    public OptionalDouble getMaxFare() {
        return rules.getRules().stream().mapToDouble(r -> r.getPrice()).max();
    }

    private void registerRules() {
        rules = Rules.builder()
                .rule(Rule.builder()
                        .description("Anywhere in Zone 1")
                        .rule(trip -> trip.getType() == TripType.TUBE &&
                                trip.getStations().stream().allMatch(s -> s.getZones().contains(1)))
                        .price(2.5f).build())
                .rule(Rule.builder()
                        .description("Any one zone outside zone 1")
                        .rule(trip -> trip.getType() == TripType.TUBE &&
                                trip.getStations().stream().anyMatch(s -> !s.getZones().contains(1)))
                        .price(2.0f).build())
                .rule(Rule.builder()
                        .description("Any two zones including zone 1")
                        .rule(trip -> trip.getType() == TripType.TUBE &&
                                trip.getStations().stream().filter(s -> s.getZones().contains(1)).collect(toList()).size() == 2)
                        .price(3.0f).build())
                .rule(Rule.builder()
                        .description("Any two zones excluding zone 1")
                        .rule(trip -> trip.getType() == TripType.TUBE &&
                                trip.getStations().stream().filter(s -> !s.getZones().contains(1)).collect(toList()).size() == 2)
                        .price(2.25f).build())
                .rule(Rule.builder()
                        .description("Any three zones")
                        .rule(trip -> trip.getType() == TripType.TUBE &&
                                trip.getStations().stream().flatMap(s -> s.getZones().stream()).collect(toSet()).size() == 3)
                        .price(3.2f).build())
                .rule(Rule.builder()
                        .description("Any bus journey")
                        .rule(trip -> trip.getType() == TripType.BUS)
                        .price(1.8f).build()).build();
    }
}
