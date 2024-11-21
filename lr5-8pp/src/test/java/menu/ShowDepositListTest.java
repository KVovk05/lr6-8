package menu;
import bank.Deposit;

import org.junit.jupiter.api.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ShowDepositListTest {

    private ArrayList<Deposit> deposits;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));

        deposits = new ArrayList<>(Arrays.asList(
                new Deposit(1, 3, 12, 0.03),
                new Deposit(2, 1, 6, 0.05),
                new Deposit(3, 6, 24, 0.04)
        ));
    }

    @AfterEach
    public void tearDown() {
        System.setIn(originalIn);
        System.setOut(originalOut);
        deposits.clear();
    }

    @Test
    public void testHowToSortListByInterestRate() {

        String userInput = "1\n";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));


        ShowDepositList command = new ShowDepositList(deposits);
        command.howToSortList();


        assertEquals(0.03, deposits.get(0).getInterestRate());
        assertEquals(0.04, deposits.get(1).getInterestRate());
        assertEquals(0.05, deposits.get(2).getInterestRate());
    }

    @Test
    public void testHowToSortListByMinimalPeriod() {

        String userInput = "2\n";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));


        ShowDepositList command = new ShowDepositList(deposits);
        command.howToSortList();


        assertEquals(1, deposits.get(0).getMinPeriod());
        assertEquals(3, deposits.get(1).getMinPeriod());
        assertEquals(6, deposits.get(2).getMinPeriod());
    }

    @Test
    public void testHowToSortListByMaximalPeriod() {

        String userInput = "3\n";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));


        ShowDepositList command = new ShowDepositList(deposits);
        command.howToSortList();


        assertEquals(6, deposits.get(0).getMaxPeriod());
        assertEquals(12, deposits.get(1).getMaxPeriod());
        assertEquals(24, deposits.get(2).getMaxPeriod());
    }

    @Test
    public void testHowToSortListInvalidChoice() {

        String userInput = "99\n";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));


        ShowDepositList command = new ShowDepositList(deposits);
        command.howToSortList();


        assertEquals(1, deposits.get(0).getBankId());
        assertEquals(2, deposits.get(1).getBankId());
        assertEquals(3, deposits.get(2).getBankId());
    }

    @Test
    public void testGetDesc() {

        ShowDepositList command = new ShowDepositList(deposits);
        assertEquals("Show list of available deposits", command.getDesc());
    }
}
