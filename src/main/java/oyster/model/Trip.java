package oyster.model;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Singular;
import lombok.ToString;

@Builder
@ToString
@RequiredArgsConstructor
public class Trip {

    @Getter
    private final TripType type;

    @Getter
    @Singular
    private final List<Station> stations;
}
