package menu;
import bank.Bank;
import bank.BankList;
import bank.Deposit;
import main.MyDeposit;
import menu.Invoker;
import java.util.Scanner;
import java.util.ArrayList;
public class ConsoleMenu {
    private ArrayList<Bank> bankList = new ArrayList<>(10);
    private ArrayList<Deposit> deposits = new ArrayList<>(10);
    private ArrayList<MyDeposit> myDeposits = new ArrayList<>(3);
    public  void menu(){

    addDeposits(deposits);
    Invoker invoker = new Invoker();
    invoker.addComands(deposits,myDeposits,bankList);
        int choose = 0;
        while(choose !=9) {

            System.out.println("\nMENU");
            System.out.println("1.Show list of available deposits");
            System.out.println("2.Add deposit");
            System.out.println("3.Replenish my deposit");
            System.out.println("4.Withdraw money");
            System.out.println("5.Show my deposit");
            System.out.println("6.Calculate income");
            System.out.println("7.Find bank by ID");
            System.out.println("8.Delete my deposit");
            System.out.println("9.Exit");
            Scanner sc = new Scanner(System.in);
            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    Command ShowDepositList = invoker.getCommand("Show list of available deposits");
                    ShowDepositList.execute();//+ sort list by parameters
                    break;
                case 2:
                    Command ChooseDesiredDeposit = invoker.getCommand("Add deposit");
                    ChooseDesiredDeposit.execute();
                    break;
                case 3:
                    Command Replenishment = invoker.getCommand("Replenish my deposit");
                    Replenishment.execute();
                    break;
                case 4:
                    Command WithdrawMoney = invoker.getCommand("Withdraw money");
                    WithdrawMoney.execute();
                    break;
                case 5:
                    Command ShowMyDeposit = invoker.getCommand("Show my deposit");
                    ShowMyDeposit.execute();
                    break;
                case 6:
                    Command CalculateIncome = invoker.getCommand("Calculate income");
                    CalculateIncome.execute();
                    break;
                case 7:
                    Command FindBankById = invoker.getCommand("Find bank by ID");
                    FindBankById.execute();
                    break;
                case 8:
                    Command DeleteMyDeposit = invoker.getCommand("Delete my Deposit");
                    DeleteMyDeposit.execute();
                    break;
            }
        }

    }
    static void addDeposits(ArrayList<Deposit> deposits){
        deposits.add(new Deposit(1,3,12,0.023));
        deposits.add(new Deposit(2,5,36,0.0299));
        deposits.add(new Deposit(3,12,120,0.04));
        deposits.add(new Deposit(4,24,126,0.055));
        deposits.add(new Deposit(4,1,6,0.02));
    }
//    public ArrayList<Deposit> getMyDeposits(){
//        return myDeposits;
//    }

}
