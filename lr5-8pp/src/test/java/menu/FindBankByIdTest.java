package menu;
import bank.Bank;
import org.junit.jupiter.api.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class FindBankByIdTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void tearDown() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    public void testExecuteValidId() {
        String userInput = "2\n";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        FindBankById command = new FindBankById();
        command.execute();

        String output = outContent.toString();
        assertTrue(output.contains("Union bank"));
    }
    @Test
    public void testAddBanks() {
        FindBankById command = new FindBankById();
        command.AddBanks();

        Map<Integer,Bank> expectedMap = new HashMap<>();
        expectedMap.put(1, new Bank("Monobank", 1));
        expectedMap.put(2, new Bank("Union bank", 2));
        expectedMap.put(3, new Bank("Bank of America", 3));
        expectedMap.put(4, new Bank("First European Bank", 4));

        for (int id : expectedMap.keySet()) {
            assertTrue(command.getMap().containsKey(id));
            assertEquals(expectedMap.get(id).getName(), command.getMap().get(id).getName());
        }
    }
    @Test
    public void testExecuteInvalidId() {
        String userInput = "99\n";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        FindBankById command = new FindBankById();
        command.execute();


        String output = outContent.toString();
        assertTrue(output.contains("null"));
    }


}
