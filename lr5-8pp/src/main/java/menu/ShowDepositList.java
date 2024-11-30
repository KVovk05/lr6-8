package menu;

import bank.Deposit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

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
