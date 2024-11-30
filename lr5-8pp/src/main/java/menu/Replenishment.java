package menu;

import bank.MyDeposit;

import java.util.ArrayList;
import java.util.Scanner;

class Replenishment implements Command {
    private ArrayList<MyDeposit> myDeposits;
    double amount;

    public Replenishment(ArrayList<MyDeposit> myDeposits) {
        this.myDeposits = myDeposits;
    }

    @Override
    public void execute() {

        if (myDeposits.size() > 1) {
            System.out.println("Select a deposit to add money:");
            for (int i = 0; i < myDeposits.size(); i++) {
                System.out.println((i + 1) + ". " + myDeposits.get(i));
            }
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt() - 1;
            if (choice >= 0 && choice < myDeposits.size()) {
                System.out.println("How much money do you want to add?");
                double money = sc.nextDouble();
                myDeposits.get(choice).setMyInvestment(money + myDeposits.get(choice).getMyInvestment());
            } else {
                System.out.println("Invalid selection.");
            }
        } else {
            System.out.println("How much money do you want to add?");
            Scanner sc = new Scanner(System.in);
            double money = sc.nextDouble();
            myDeposits.get(0).setMyInvestment(money + myDeposits.get(0).getMyInvestment());
        }

        System.out.println("You successfully added money to your deposit");
    }
     public String getDesc(){
        return "Replenish my deposit";
    }
}
