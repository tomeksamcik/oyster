package oyster;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

public class OysterCard {

    @Getter
    private final List<Double> transactions = new ArrayList<>();

    public void addTransaction(double amount) {
        transactions.add(amount);
    }

    public void removeLastTransaction() {
        transactions.remove(transactions.size() - 1);
    }

    public Double getBalance() {
        return transactions.stream().reduce(0.0, (a, b) -> a + b);
    }
}
