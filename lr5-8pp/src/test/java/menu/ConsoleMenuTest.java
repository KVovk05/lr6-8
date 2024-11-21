
package menu;
import bank.Deposit;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsoleMenuTest {

    @Test
    void testAddDeposits() {

        ArrayList<Deposit> deposits = new ArrayList<>();
        ConsoleMenu.addDeposits(deposits);
        deposits.add(new Deposit(1, 3, 12, 0.023));

        assertEquals(6, deposits.size());

        assertEquals(1, deposits.get(0).getBankId());
        assertEquals(3, deposits.get(0).getMinPeriod());
        assertEquals(12, deposits.get(0).getMaxPeriod());
        assertEquals(0.023, deposits.get(0).getInterestRate());

        assertEquals(4, deposits.get(4).getBankId());
        assertEquals(1, deposits.get(4).getMinPeriod());
        assertEquals(6, deposits.get(4).getMaxPeriod());
        assertEquals(0.02, deposits.get(4).getInterestRate(), 0.00001);
    }
}
