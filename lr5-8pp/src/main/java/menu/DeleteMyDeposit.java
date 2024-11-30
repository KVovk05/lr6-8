package menu;

import bank.MyDeposit;

import java.util.ArrayList;
import java.util.Scanner;

class DeleteMyDeposit implements Command {
    private ArrayList<MyDeposit> myDeposits;

    public DeleteMyDeposit(ArrayList<MyDeposit> myDeposits) {
        this.myDeposits = myDeposits;
    }

    public void execute() {
        System.out.println("Select a deposit to delete:");
        for (int i = 0; i < myDeposits.size(); i++) {
            System.out.println((i + 1) + ". " + myDeposits.get(i));
        }
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt() - 1;

        if (choice >= 0 && choice < myDeposits.size()) {

            myDeposits.remove(myDeposits.get(choice));

        } else {
            System.out.println("Invalid selection.");
        }
        System.out.println("Deposit was deleted");

    }

    public String getDesc() {
        return "Delete my Deposit";
    }
}
