package oyster.rules;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import oyster.model.Trip;
import oyster.model.TripType;
import oyster.model.Station;

@DisplayName("Engine class test")
public class EngineTest {

    private final Engine engine = new Engine();

    private static Stream<Arguments> testFares() {
        return Stream.of(
                Arguments.of(Trip.builder()
                        .type(TripType.TUBE)
                        .from(Station.HOLBORN)
                        .to(Station.EARLS_COURT).build(), 2.5f, "Tube Holborn to Earl’s Court"),
                Arguments.of(Trip.builder()
                        .type(TripType.BUS).build(), 1.8f, "328 bus from Earl’s Court to Chelsea"),
                Arguments.of(Trip.builder()
                        .type(TripType.TUBE)
                        .from(Station.EARLS_COURT)
                        .to(Station.HAMMERSMITH).build(), 2f, "Tube Earl’s Court to Hammersmith"),
                Arguments.of(Trip.builder()
                        .type(TripType.TUBE)
                        .from(Station.HOLBORN)
                        .to(Station.WIMBLEDON).build(), 3.2f, "Tube Holborn to Wimbledon"));
    }

    @MethodSource("testFares")
    @ParameterizedTest(name = "{2}")
    @DisplayName("Test fares")
    public void testEngine(Trip trip, float expected, String display) {
        assertThat((float)engine.applyRules(trip).getAsDouble(), equalTo(expected));
    }
}