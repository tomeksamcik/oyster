package oyster;

import java.util.OptionalDouble;
import lombok.Getter;
import oyster.model.Trip;
import oyster.rules.Engine;

public class OysterOperations {

    private final Engine engine = new Engine();

    @Getter
    private final OysterCard card = new OysterCard();

    public void chargeOysterCard(double amount) {
        card.addTransaction(amount);
    }

    public void enterStation() {
        OptionalDouble charged = engine.getMaxFare();
        charged.ifPresent(d -> card.addTransaction(-d));
    }

    public void exitStation(Trip trip) {
        OptionalDouble fare = engine.applyRules(trip);
        fare.ifPresent(f -> {
            card.removeLastTransaction();
            card.addTransaction(-f);
        });
    }
}
