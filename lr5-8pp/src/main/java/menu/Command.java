package menu;
import bank.BankList;
import bank.Deposit;
import main.MyDeposit;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public interface Command {
    void execute();
}
class WithdrawMoney implements Command{
    private ArrayList<Deposit> myDeposits;
    double amount;

    @Override
    public void execute() {
        if(myDeposits.size()>1) {
            System.out.println("Select a deposit to add money:");
            for (int i = 0; i < myDeposits.size(); i++) {
                System.out.println((i + 1) + ". " + myDeposits.get(i));
            }
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt() - 1;
            if (choice >= 0 && choice < myDeposits.size()) {
                System.out.println("How much money do you want to add?");
                double money = sc.nextDouble();
                myDeposits.get(choice).setMoneyInDeposit(myDeposits.get(choice).getMoneyInDeposit() - money);
            } else {
                System.out.println("Invalid selection.");
            }
        }
        else{
            System.out.println("How much money do you want to witdrad?");
            Scanner sc = new Scanner(System.in);
            double money = sc.nextDouble();
            myDeposits.get(0).setMoneyInDeposit(myDeposits.get(0).getMoneyInDeposit() - money);
        }

        System.out.println("Money has withdrawed");
    }

    }
class Replenishment implements Command{
    private ArrayList<MyDeposit> myDeposits;
    double amount;
    public Replenishment(ArrayList<MyDeposit> myDeposits){
        this.myDeposits = myDeposits;
    }
    @Override
    public void execute() {

        if(myDeposits.size()>1) {
            System.out.println("Select a deposit to add money:");
            for (int i = 0; i < myDeposits.size(); i++) {
                System.out.println((i + 1) + ". " + myDeposits.get(i));
            }
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt() - 1;
            if (choice >= 0 && choice < myDeposits.size()) {
                System.out.println("How much money do you want to add?");
                double money = sc.nextDouble();
                myDeposits.get(choice).setMoneyInDeposit(money+ myDeposits.get(choice).getMoneyInDeposit());
            } else {
                System.out.println("Invalid selection.");
            }
        }
        else{
            System.out.println("How much money do you want to add?");
            Scanner sc = new Scanner(System.in);
            double money = sc.nextDouble();
            myDeposits.get(0).setMoneyInDeposit(money+ myDeposits.get(0).getMoneyInDeposit());
        }

        System.out.println("You successfully added money to your deposit");
    }
}
class ChooseDesiredDeposit implements Command{
    private ArrayList<Deposit> deposits;
    private ArrayList<Deposit> myDeposits;
    public  ChooseDesiredDeposit(ArrayList<Deposit> deposits,ArrayList<Deposit> myDeposits){
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
            myDeposits.add(deposits.get(choice));
            System.out.println("Deposit added: " + deposits.get(choice));
        } else {
            System.out.println("Invalid selection.");
        }
    }

     }
class ShowDepositList implements Command{

    private ArrayList<Deposit> deposits;
    public ShowDepositList(ArrayList<Deposit> deposits){
        this.deposits = deposits;
    }
    public void execute() {
        howToSortList();
        System.out.println(deposits);
    }
    public  void howToSortList(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Sort by:\n 1.Interest rate(asc)\n2.By minimal period(asc)\n3.By maximal period");
        int choose = sc.nextInt();
        switch(choose){
            case 1:
                Collections.sort(deposits,Comparator.comparingDouble(d->d.getInterestRate()));
                break;
            case 2:
                Collections.sort(deposits,Comparator.comparingDouble(d->d.getMinPeriod()));
                break;
            case 3:
                Collections.sort(deposits,Comparator.comparingDouble(d->d.getMaxPeriod()));
                break;
        }
    }

}
class CalculateIncome implements Command{
    private CalculateIncome calc;
    @Override
    public void execute() {

        System.out.println("Calc");
    }
}
class ShowMyDeposit implements Command{
    private ArrayList<Deposit> myDeposits;
    public ShowMyDeposit(ArrayList<Deposit> myDeposits){
        this.myDeposits = myDeposits;
    }
    @Override
    public void execute() {
        System.out.println(myDeposits);

    }
}