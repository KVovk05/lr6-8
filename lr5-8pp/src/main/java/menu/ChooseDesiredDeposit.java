package menu;

import bank.Deposit;
import bank.MyDeposit;

import java.util.ArrayList;
import java.util.Scanner;

class ChooseDesiredDeposit implements Command {
    private ArrayList<Deposit> deposits;
    private ArrayList<MyDeposit> myDeposits;

    public ChooseDesiredDeposit(ArrayList<Deposit> deposits, ArrayList<MyDeposit> myDeposits) {
        this.deposits = deposits;
        this.myDeposits = myDeposits;
    }

    public void execute() {
        System.out.println("Select a deposit to add:");
        for (int i = 0; i < deposits.size(); i++) {
            System.out.println((i + 1) + ". " + deposits.get(i));
        }
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt() - 1;

        if (choice >= 0 && choice < deposits.size()) {
            System.out.println("Choose period of your deposit:");
            int term = sc.nextInt();
            MyDeposit myDeposit = new MyDeposit(deposits.get(choice));
            myDeposit.setMyPeriod(term);
            myDeposits.add(myDeposit);
            System.out.println("Deposit added: " + deposits.get(choice));
        } else {
            System.out.println("Invalid selection.");
        }
    }
    public String getDesc(){
        return "Add deposit";
    }

}
