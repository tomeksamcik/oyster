package oyster.rules;

import java.util.function.Predicate;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import oyster.model.Trip;

@Slf4j
@Builder
@RequiredArgsConstructor
public class Rule {

    @Getter
    private final Float price;

    private final String description;

    @Getter
    private final Predicate<Trip> rule;

    public Boolean apply(Trip trip) {
        Boolean result = rule.test(trip);

        log.debug("Applying rule '{}' to trip {} with result: {}", description, trip, result);

        return result;
    }
}
