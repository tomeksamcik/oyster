package oyster.model;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Builder
@ToString
@RequiredArgsConstructor
public class Trip {

    @Getter
    private final TripType type;

    @Getter
    private final Station from;

    @Getter
    private final Station to;
}
