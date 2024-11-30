package menu;

import bank.MyDeposit;

import java.util.ArrayList;

class ShowMyDeposit implements Command {
    private ArrayList<MyDeposit> myDeposits;

    public ShowMyDeposit(ArrayList<MyDeposit> myDeposits) {
        this.myDeposits = myDeposits;
    }

    @Override
    public void execute() {
        System.out.println(myDeposits);

    }

    public String getDesc() {
        return "Show my deposit";
    }

}
