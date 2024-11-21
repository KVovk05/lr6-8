package menu;
import bank.MyDeposit;
import org.junit.jupiter.api.*;
import java.io.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class WithdrawMoneyTest {

    private ArrayList<MyDeposit> myDeposits;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));

        myDeposits = new ArrayList<>();
        myDeposits.add(new MyDeposit(1, 3, 12, 0.023,12,1000));
        myDeposits.add(new MyDeposit(2, 5, 36, 0.0299,36,10000));
        myDeposits.add(new MyDeposit(3, 12, 120, 0.04,100,150000));
        myDeposits.add(new MyDeposit(4, 24, 126, 0.055,120,98000));
        myDeposits.add(new MyDeposit(4, 1, 6, 0.02,5,500));
    }

    @AfterEach
    public void tearDown() {
        System.setIn(originalIn);
        System.setOut(originalOut);
        myDeposits.clear();
    }

    @Test
    public void testExecuteWithMultipleDepositsValidSelection() {

        String userInput = "2\n500\n";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));


        WithdrawMoney command = new WithdrawMoney(myDeposits);
        command.execute();

        assertEquals(1000, myDeposits.get(0).getMyInvestment());
        assertEquals(9500, myDeposits.get(1).getMyInvestment());

        String output = outContent.toString();
        assertTrue(output.contains("Select a deposit to add money:"));
        assertTrue(output.contains("Money has withdrawed"));
    }

    @Test
    public void testExecuteWithMultipleDepositsInvalidSelection() {

        String userInput = "7\n";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));


        WithdrawMoney command = new WithdrawMoney(myDeposits);
        command.execute();

        assertEquals(1000, myDeposits.get(0).getMyInvestment());
        assertEquals(10000, myDeposits.get(1).getMyInvestment());

        String output = outContent.toString();
        assertTrue(output.contains("Invalid selection."));
    }

    @Test
    public void testExecuteWithSingleDeposit() {

        myDeposits = new ArrayList<>();
        myDeposits.add(new MyDeposit(1, 3, 12, 0.023,12,1000));

        String userInput = "300\n";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        WithdrawMoney command = new WithdrawMoney(myDeposits);
        command.execute();

        assertEquals(700, myDeposits.get(0).getMyInvestment());

        String output = outContent.toString();
        assertTrue(output.contains("How much money do you want to witdraw?"));
        assertTrue(output.contains("Money has withdrawed"));
    }

    @Test
    public void testGetDesc() {

        WithdrawMoney command = new WithdrawMoney(myDeposits);
        assertEquals("Withdraw money", command.getDesc());
    }
}
