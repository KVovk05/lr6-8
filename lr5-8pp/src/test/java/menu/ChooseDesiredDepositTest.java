package menu;
import  bank.Deposit;
import bank.MyDeposit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


import java.io.*;
import java.util.ArrayList;



public class ChooseDesiredDepositTest {
    private ArrayList<Deposit> deposits;
    private ArrayList<MyDeposit> myDeposits;
    @BeforeEach
    public void setUp() {
        deposits = new ArrayList<>();
        deposits.add(new Deposit(1, 3, 12, 0.023));
        deposits.add(new Deposit(2, 5, 36, 0.0299));
        deposits.add(new Deposit(3, 12, 120, 0.04));
        deposits.add(new Deposit(4, 24, 126, 0.055));
        deposits.add(new Deposit(4, 1, 6, 0.02));

        myDeposits = new ArrayList<>();
    }

    @Test
    public void testExecuteValidSelection() {

        String userInput = "1\n12\n";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        ChooseDesiredDeposit command = new ChooseDesiredDeposit(deposits, myDeposits);
        command.execute();


        assertEquals(1, myDeposits.size());
        assertEquals(1, myDeposits.get(0).getBankId());
        assertEquals(12, myDeposits.get(0).getMyPeriod());


    }

    @Test
    public void testExecuteInvalidSelection() {

        String userInput = "6\n";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));


        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        ChooseDesiredDeposit command = new ChooseDesiredDeposit(deposits, myDeposits);
        command.execute();

        assertEquals(0, myDeposits.size());

        String output = outContent.toString();
        assertTrue(output.contains("Invalid selection."));
    }

    @Test
    public void testExecuteEmptyDeposits() {
        deposits.clear();

        String userInput = "1\n";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        ChooseDesiredDeposit command = new ChooseDesiredDeposit(deposits, myDeposits);
        command.execute();


        assertEquals(0, myDeposits.size());
        String output = outContent.toString();
        assertTrue(output.contains("Invalid selection."));
    }
}

