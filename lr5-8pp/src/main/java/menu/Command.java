package menu;

import bank.Bank;
import bank.Deposit;
import main.MyDeposit;

import java.util.*;

public interface Command {
    void execute();
    String getDesc();
}

class WithdrawMoney implements Command {
    private ArrayList<MyDeposit> myDeposits;
    double amount;

    public WithdrawMoney(ArrayList<MyDeposit> myDeposits) {
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
                myDeposits.get(choice).setMyInvestment(myDeposits.get(choice).getMyInvestment() - money);
            } else {
                System.out.println("Invalid selection.");
            }
        } else {
            System.out.println("How much money do you want to witdraw?");
            Scanner sc = new Scanner(System.in);
            double money = sc.nextDouble();
            myDeposits.get(0).setMyInvestment(myDeposits.get(0).getMyInvestment() - money);
        }

        System.out.println("Money has withdrawed");
    }

    public String getDesc(){
        return "Withdraw money";
    }


}

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

class ShowDepositList implements Command {

    private ArrayList<Deposit> deposits;

    public ShowDepositList(ArrayList<Deposit> deposits) {
        this.deposits = deposits;
    }

    public void execute() {
        howToSortList();
        System.out.println(deposits);
    }

    public void howToSortList() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Sort by:\n 1.Interest rate(asc)\n2.By minimal period(asc)\n3.By maximal period");
        int choose = sc.nextInt();
        switch (choose) {
            case 1:
                Collections.sort(deposits, Comparator.comparingDouble(d -> d.getInterestRate()));
                break;
            case 2:
                Collections.sort(deposits, Comparator.comparingDouble(d -> d.getMinPeriod()));
                break;
            case 3:
                Collections.sort(deposits, Comparator.comparingDouble(d -> d.getMaxPeriod()));
                break;
        }
    }
    public String getDesc(){
        return "Show list of available deposits";
    }

}

class CalculateIncome implements Command {
    private int money;
    private int periodMonths;
    private double years;
    private int monthsInYear = 12;
    private double interestRate;
    private double moneyAfterPeriod;
    private double replenishment;

    @Override
    public void execute() {

        System.out.println("\n\t\t\t\t--COMPOUND INTEREST CALCULATOR--\n");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter money amount: ");
        money = sc.nextInt();
        double moneyBeforePeriod = money;
        System.out.println("Enter period in months: ");
        periodMonths = sc.nextInt();
        years = periodMonths / monthsInYear;
        System.out.println("Enter interest rate %: ");
        interestRate = sc.nextDouble();
        interestRate /= 100;
        System.out.println("How much money in month do you want to add to your deposit?");
        replenishment = sc.nextDouble();
        if (replenishment == 0) {
            calculate();
        } else {
            calculateWithAdd();
        }
        System.out.println("Your investment after: " + periodMonths + "months: " + moneyAfterPeriod + "\nTotal income:" + (moneyAfterPeriod - moneyBeforePeriod));
    }

    public void calculateWithAdd() {
        moneyAfterPeriod = money * Math.pow((1 + interestRate / monthsInYear), monthsInYear * years);
        moneyAfterPeriod += replenishment * ((Math.pow((1 + interestRate / monthsInYear), monthsInYear * years) - 1) / (interestRate / monthsInYear));
    }

    public void calculate() {
        moneyAfterPeriod = money * Math.pow((1 + interestRate / monthsInYear), monthsInYear * years);
    }
    public String getDesc(){
        return "Calculate income";
    }

}

class FindBankById implements Command {
    private Map<Integer, Bank> map = new HashMap<>();
    private int id;

    public void execute() {
        AddBanks();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id of a bank!");
        id = sc.nextInt();
        System.out.println(map.get(id));
    }

    public void AddBanks() {
        map.put(1, new Bank("Monobank", 1));
        map.put(2, new Bank("Union bank", 2));
        map.put(3, new Bank("Bank of America", 3));
        map.put(4, new Bank("First European Bank", 4));
    }
    public String getDesc(){
        return "Find bank by ID";
    }
}

class ShowMyDeposit implements Command {
    private ArrayList<MyDeposit> myDeposits;

    public ShowMyDeposit(ArrayList<MyDeposit> myDeposits) {
        this.myDeposits = myDeposits;
    }

    @Override
    public void execute() {
        System.out.println(myDeposits);

    }
    public String getDesc(){
        return "Show my deposit";
    }
}

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
    public String getDesc(){
        return "Delete my Deposit";
    }
}
