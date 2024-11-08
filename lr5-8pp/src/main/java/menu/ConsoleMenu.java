package menu;

import bank.Bank;
import bank.Deposit;
import main.MyDeposit;

import java.util.ArrayList;

public class ConsoleMenu {
    private ArrayList<Bank> bankList = new ArrayList<>(10);
    private ArrayList<Deposit> deposits = new ArrayList<>(10);
    private ArrayList<MyDeposit> myDeposits = new ArrayList<>(3);

    public void menu() {
        addDeposits(deposits);

        Invoker invoker = new Invoker();
        invoker.addComands(deposits, myDeposits, bankList);
        invoker.execute();
    }

    static void addDeposits(ArrayList<Deposit> deposits) {
        deposits.add(new Deposit(1, 3, 12, 0.023));
        deposits.add(new Deposit(2, 5, 36, 0.0299));
        deposits.add(new Deposit(3, 12, 120, 0.04));
        deposits.add(new Deposit(4, 24, 126, 0.055));
        deposits.add(new Deposit(4, 1, 6, 0.02));
    }
}
