package menu;

import bank.Deposit;
import bank.MyDeposit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


class InvokerTest {

    private Invoker invoker;
    private ArrayList<Deposit> deposits;
    private ArrayList<MyDeposit> myDeposits;

    @BeforeEach
    void setUp() {
        invoker = new Invoker();
        deposits = new ArrayList<>();
        myDeposits = new ArrayList<>();
    }

    @Test
    void testAddCommands() {

        invoker.addComands(deposits, myDeposits);

        Map<String, Command> commandMap = invoker.commandMap;

        assertEquals(8, commandMap.size());

        assertTrue(commandMap.containsKey("show_list"));
        assertTrue(commandMap.containsKey("add"));
        assertTrue(commandMap.containsKey("replenish"));
        assertTrue(commandMap.containsKey("withdraw"));
        assertTrue(commandMap.containsKey("show_dep"));
        assertTrue(commandMap.containsKey("calculate"));
        assertTrue(commandMap.containsKey("find_bank"));
        assertTrue(commandMap.containsKey("delete"));
    }

    @Test
    void testGetCommand() {

        invoker.addComands(deposits, myDeposits);
        Command command = invoker.getCommand("show_list");
        assertEquals("ShowDepositList", command.getClass().getSimpleName());
    }

    @Test
    void testPrintMenu() {
        invoker.addComands(deposits, myDeposits);

        var outputStream = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outputStream));


        invoker.printMenu();

        String output = outputStream.toString();
        assertTrue(output.contains("MENU"));
        assertTrue(output.contains("show_list : "));
        assertTrue(output.contains("add : "));
        assertTrue(output.contains("exit: Exit"));

        System.setOut(System.out);
    }

}