package menu;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class CalculateIncomeTest {
    private CalculateIncome calc;
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
    public void testExecuteWithoutReplenishment() {

        String userInput = "1000\n12\n5\n0\n";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        CalculateIncome calculator = new CalculateIncome();
        calculator.execute();

        String output = outContent.toString();
        assertTrue(output.contains("Your investment after: 12months:"));
        assertTrue(output.contains("Total income:"));

        double expectedInvestment = 1000 * Math.pow(1 + 0.05 / 12, 12);
        assertTrue(output.contains(String.format("%.2f", expectedInvestment)));
    }

    @Test
    public void testExecuteWithReplenishment() {

        String userInput = "1000\n12\n5\n100\n";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        CalculateIncome calculator = new CalculateIncome();
        calculator.execute();

        String output = outContent.toString();
        assertTrue(output.contains("Your investment after: 12months:"));
        assertTrue(output.contains("Total income:"));

    }

    public void setting(CalculateIncome calc){

        calc.setMoney(1000);
        calc.setPeriodMonths(36);
        calc.setInterestRate(2.5);
        calc.setReplenishment(0);

    }

    @Test
    void calculateWithAdd() {
        calc = new CalculateIncome();
        setting(calc);
        calc.calculateWithAdd();
        assertEquals(calcMoneyAfterPeriod(),calc.getMoneyAfterPeriod());
    }
    private double calcMoneyAfterPeriod(){
        double moneyAfterPeriod;
        moneyAfterPeriod = calc.getMoney() * Math.pow((1 + calc.getInterestRate() / calc.getMonthsInYear()),calc.getMonthsInYear() * calc.getYears());
        moneyAfterPeriod += calc.getReplenishment() * ((Math.pow((1 + calc.getInterestRate() / calc.getMonthsInYear()), calc.getMonthsInYear() * calc.getYears()) - 1) / (calc.getInterestRate() / calc.getMonthsInYear()));
        return moneyAfterPeriod;
    }
    @Test
    void calculate() {
        calc = new CalculateIncome();
        setting(calc);
        calc.calculate();
        assertEquals(getCalc(),calc.getMoneyAfterPeriod());
    }
    private double getCalc(){
        return calc.getMoney() * Math.pow((1 + calc.getInterestRate() / calc.getMonthsInYear()),calc.getMonthsInYear() * calc.getYears());
    }
    @Test
    void getDesc() {
        calc = new CalculateIncome();
        assertEquals(getDescTest(),calc.getDesc());
    }
    private String getDescTest(){
        return "Calculate income";
    }
}