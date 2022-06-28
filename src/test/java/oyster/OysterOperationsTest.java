package oyster;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import oyster.model.Station;
import oyster.model.Trip;
import oyster.model.TripType;

@DisplayName("OysterOperations class test")
class OysterOperationsTest {

    private final OysterOperations ops = new OysterOperations();

    @Test
    @DisplayName("Charge oyster cards test")
    void chargeOysterCard() {
        ops.chargeOysterCard(30.0);

        assertThat(ops.getCard().getBalance().floatValue(), equalTo(30.0f));
    }

    @Test
    @DisplayName("Enter station test")
    void enterStation() {
        ops.chargeOysterCard(30.0);
        ops.enterStation();

        assertThat(ops.getCard().getBalance().floatValue(), equalTo(26.8f));
    }

    @Test
    @DisplayName("Exit station test")
    void exitStation() {
        ops.chargeOysterCard(30.0);
        ops.enterStation();
        ops.exitStation(Trip.builder()
                .type(TripType.TUBE)
                .from(Station.HOLBORN)
                .to(Station.EARLS_COURT).build());

        assertThat(ops.getCard().getBalance().floatValue(), equalTo(27.5f));
    }

    @Test
    @DisplayName("Tree trips test")
    void threeTripsTest() {
        ops.chargeOysterCard(30.0);
        ops.enterStation();
        ops.exitStation(Trip.builder()
                .type(TripType.TUBE)
                .from(Station.HOLBORN)
                .to(Station.EARLS_COURT).build()); //2.5
        ops.enterStation();
        ops.exitStation(Trip.builder()
                .type(TripType.BUS)
                .from(Station.EARLS_COURT)
                .to(Station.CHELSEA).build()); //1.8
        ops.enterStation();
        ops.exitStation(Trip.builder()
                .type(TripType.TUBE)
                .from(Station.EARLS_COURT)
                .to(Station.HAMMERSMITH).build()); //2.0

        assertThat(ops.getCard().getBalance().floatValue(), equalTo(23.7f));
    }
}