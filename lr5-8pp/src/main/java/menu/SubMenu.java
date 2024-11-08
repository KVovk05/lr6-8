package menu;

import bank.Bank;
import bank.Deposit;
import main.MyDeposit;

import java.util.ArrayList;

public class SubMenu extends Invoker{

    public void addComands(ArrayList<Deposit> deposits, ArrayList<MyDeposit> myDeposits, ArrayList<Bank> banks){
        commandMap.put("show_list1",new ShowDepositList(deposits));
        commandMap.put("add1",new ChooseDesiredDeposit(deposits,myDeposits));
        commandMap.put("replenish1",new Replenishment(myDeposits));

    }
}
