package bank;

public class Deposit extends Bank {
private double interestRate;
private int minPeriod;
private int maxPeriod;
private int maxInvest;



    private int minInvest;
private double moneyInDeposit;

    public Deposit(String name, double interestRate, int minPeriod, int maxPeriod, int maxInvest, int minInvest) {
        super(name);
        this.interestRate = interestRate;
        this.minPeriod = minPeriod;
        this.maxPeriod = maxPeriod;
        this.maxInvest = maxInvest;
        this.minInvest = minInvest;
    }
    public Deposit(){

    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getMinPeriod() {
        return minPeriod;
    }

    public void setMinPeriod(int minPeriod) {
        this.minPeriod = minPeriod;
    }

    public int getMaxPeriod() {
        return maxPeriod;
    }

    public void setMaxPeriod(int maxPeriod) {
        this.maxPeriod = maxPeriod;
    }
    public void setMoneyInDeposit(double moneyInDeposit) {
        this.moneyInDeposit = moneyInDeposit;
    }

    public int getMaxInvest() {
        return maxInvest;
    }

    public void setMaxInvest(int maxInvest) {
        this.maxInvest = maxInvest;
    }

    public int getMinInvest() {
        return minInvest;
    }

    public void setMinInvest(int minInvest) {
        this.minInvest = minInvest;
    }
    public double getMoneyInDeposit() {
        return moneyInDeposit;
    }
    @Override
    public String toString() {
        return "\n\nBank: " +getName()+
                "\ninterestRate=" + interestRate +
                "\nminPeriod=" + minPeriod +
                "\nmaxPeriod=" + maxPeriod +
                "\nmaxInvest=" + maxInvest +
                "\nminInvest=" + minInvest ;
    }
}
