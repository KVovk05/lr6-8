package main;
import bank.Deposit;
import java.util.ArrayList;
public class MyDeposit extends Deposit {

    private int myPeriod;
    private double myInvestment = 0;

    public MyDeposit(Deposit deposit){
        this.setMinPeriod(deposit.getMinPeriod());
        this.setMaxPeriod(deposit.getMaxPeriod());
        this.setInterestRate(deposit.getInterestRate());
        this.setBankId(deposit.getBankId());
    }

    public MyDeposit(int bankId, int minPeriod, int maxPeriod, double interestRate, int myPeriod, double myInvestment) {
        super(bankId, minPeriod, maxPeriod, interestRate);
        this.myPeriod = myPeriod;
        this.myInvestment = myInvestment;
    }

    public int getMyPeriod() {
        return myPeriod;
    }

    public void setMyPeriod(int myPeriod) {
        this.myPeriod = myPeriod;
    }

    public double getMyInvestment() {
        return myInvestment;
    }

    public void setMyInvestment(double myInvestment) {
        this.myInvestment = myInvestment;
    }

    @Override
    public String toString() {
        return super.toString()+
                "\nmy Period:" + myPeriod +
                "\nmy Investment:" + myInvestment;
    }
}
