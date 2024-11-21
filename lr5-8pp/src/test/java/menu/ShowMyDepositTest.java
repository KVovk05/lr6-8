package menu;
import bank.MyDeposit;
import org.junit.jupiter.api.*;
import java.io.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ShowMyDepositTest {

    private ArrayList<MyDeposit> myDeposits;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
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
        System.setOut(originalOut);
        myDeposits.clear();
    }
    @Test
    public void testExecuteWithDeposits() {

        ShowMyDeposit command = new ShowMyDeposit(myDeposits);
        command.execute();
        String output = outContent.toString();
        assertTrue(output.contains("\n\nDeposit\n" +
                "bankId: 1" +
                "\nminimal Period: 3" +
                "\nmaximal period: 12" +
                "\ninterest rate: 2.3" +
                "\nmy Period:12" +
                "\nmy Investment:1000"));

    }
    @Test
    public void testGetDesc() {

        ShowMyDeposit command = new ShowMyDeposit(myDeposits);
        assertEquals("Show my deposit", command.getDesc());
    }
}
