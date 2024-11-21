package menu;
import bank.MyDeposit;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import java.io.*;
import java.util.ArrayList;



public class DeleteMyDepositTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private ArrayList<MyDeposit> myDeposits;

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
    public void testExecuteValidDeletion() {

        String userInput = "2\n";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        DeleteMyDeposit command = new DeleteMyDeposit(myDeposits);
        command.execute();

        assertEquals(4, myDeposits.size());
        assertEquals(1, myDeposits.get(0).getBankId());
        assertEquals(3, myDeposits.get(1).getBankId());

    }

    @Test
    public void testExecuteInvalidSelection() {

        String userInput = "8\n";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));


        DeleteMyDeposit command = new DeleteMyDeposit(myDeposits);
        command.execute();
        assertEquals(5, myDeposits.size());
        String output = outContent.toString();
        assertTrue(output.contains("Invalid selection."));
    }

    @Test
    public void testExecuteEmptyList() {

        myDeposits.clear();

        String userInput = "1\n";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        DeleteMyDeposit command = new DeleteMyDeposit(myDeposits);
        command.execute();

        assertEquals(0, myDeposits.size());

        String output = outContent.toString();
        assertTrue(output.contains("Select a deposit to delete:"));
        assertTrue(output.contains("Invalid selection."));
    }
}
