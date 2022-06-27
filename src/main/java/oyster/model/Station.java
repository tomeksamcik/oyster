package oyster.model;

import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
public enum Station {
    HOLBORN("Holborn", List.of(1)),
    EARLS_COURT("Earl's Court", List.of(1, 2)),
    WIMBLEDON("Wimbledon", List.of(3)),
    HAMMERSMITH("Hammersmith", List.of(2)),
    CHELSEA("Chelsea", List.of());

    private final String name;

    @Getter
    private final List<Integer> zones;
}
