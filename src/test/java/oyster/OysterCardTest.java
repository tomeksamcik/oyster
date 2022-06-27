package oyster;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("OysterCard class test")
class OysterCardTest {

    private final OysterCard card = new OysterCard();

    @Test
    @DisplayName("Add transaction test")
    void addTransactionTest() {
        card.addTransaction(30);

        assertThat(card.getTransactions(), contains(30.0));
    }

    @Test
    @DisplayName("Remove transaction test")
    void removeLastTransactionTest() {
        card.addTransaction(20);
        card.addTransaction(30);
        card.removeLastTransaction();

        assertThat(card.getTransactions(), not(contains(30.0)));
    }

    @Test
    @DisplayName("Get no transacions balance test")
    void getZeroBalanceTest() {
        assertThat(card.getBalance(), is(0.0));
    }

    @Test
    @DisplayName("Get non-zero balance test")
    void getNonZeroBalanceTest() {
        card.addTransaction(10);
        card.addTransaction(-2.5);
        card.addTransaction(-5);

        assertThat(card.getBalance(), is(2.5));
    }
}