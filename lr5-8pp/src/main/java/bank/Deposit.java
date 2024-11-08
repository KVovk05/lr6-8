package bank;

public class Deposit {
    private int bankId;
    private int minPeriod;
    private int maxPeriod;
    private double interestRate;

    public Deposit() {

    }

    public Deposit(int bankId, int minPeriod, int maxPeriod, double interestRate) {
        this.bankId = bankId;
        this.minPeriod = minPeriod;
        this.maxPeriod = maxPeriod;
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return "\n\nDeposit\n" +
                "bankId: " + bankId +
                "\nminimal Period: " + minPeriod +
                "\nmaximal period: " + maxPeriod +
                "\ninterest rate: " + interestRate * 100;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
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
}
