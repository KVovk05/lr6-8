package menu;
import bank.Deposit;


import java.util.Scanner;
import java.util.ArrayList;
public class ConsoleMenu {
    private ArrayList<Deposit> deposits = new ArrayList<>(10);
    private ArrayList<MyDeposit> myDeposits = new ArrayList<>(3);
    public  void menu(){

    addDeposits(deposits);
        int choose = 0;
        while(choose !=7) {

            System.out.println("MENU");
            System.out.println("1.Show list of available deposits");
            System.out.println("2.Add deposit");
            System.out.println("3.Replenish my deposit");
            System.out.println("4.Withdraw money");
            System.out.println("5.Show my deposit");
            System.out.println("6.Calculate income");
            System.out.println("7.Exit");
            Scanner sc = new Scanner(System.in);
            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    Command ShowDepositList = new ShowDepositList(deposits);
                    ShowDepositList.execute();//+ sort list by parameters
                    break;
                case 2:
                    Command ChooseDesiredDeposit = new ChooseDesiredDeposit(deposits, myDeposits);
                    ChooseDesiredDeposit.execute();
                    break;
                case 3:
                    Command Replenishment = new Replenishment(myDeposits);
                    Replenishment.execute();
                    break;
                case 4:
                    Command WithdrawMoney = new WithdrawMoney();
                    WithdrawMoney.execute();
                    break;
                case 5:
                    Command ShowMyDeposit = new ShowMyDeposit(myDeposits);
                    ShowMyDeposit.execute();
                    break;
                case 6:
                    Command CalculateIncome = new CalculateIncome();
                    CalculateIncome.execute();
                    break;
            }
        }

    }
    static void addDeposits(ArrayList<Deposit> deposits){
        deposits.add(new Deposit("Union bank",0.023,3,12,100000,1000));
        deposits.add(new Deposit("monobank",0.0299,5,36,1000000,10000));
        deposits.add(new Deposit("Goldman Sachs",0.04,12,120,10000000,100000));
        deposits.add(new Deposit("Bank of America",0.055,24,126,10000000,100000));
        deposits.add(new Deposit("Bank of America",0.02,1,6,100000,100));
    }
    public ArrayList<Deposit> getMyDeposits(){
        return myDeposits;
    }

}
