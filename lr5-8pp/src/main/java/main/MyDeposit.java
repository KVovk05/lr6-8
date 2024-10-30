package main;
import bank.Deposit;
import java.util.ArrayList;
public class MyDeposit extends Deposit {

    private int myPeriod;
    private int myInvestment;
    public MyDeposit(String name, double interestRate, int minPeriod, int maxPeriod, int maxInvest, int minInvest, int myPeriod, int myInvestment) {
        super(name, interestRate, minPeriod, maxPeriod, maxInvest, minInvest);
        this.myPeriod = myPeriod;
        this.myInvestment = myInvestment;
    }

    public MyDeposit(int myPeriod, int myInvestment) {
        this.myPeriod = myPeriod;
        this.myInvestment = myInvestment;
    }

    public int getMyPeriod() {
        return myPeriod;
    }

    public void setMyPeriod(int myPeriod) {
        this.myPeriod = myPeriod;
    }

    public int getMyInvestment() {
        return myInvestment;
    }

    public void setMyInvestment(int myInvestment) {
        this.myInvestment = myInvestment;
    }
}
