package calc;

public class CalculateIncome {
    private double moneyAmount;
    private double interestRate;
    private int termMonth;
    private boolean reinvestIncome;
    private double monthlyAdd;

    public CalculateIncome(double moneyAmount, double interestRate, int termMonth, boolean reinvestIncome, double monthlyAdd) {
        this.moneyAmount = moneyAmount;
        this.interestRate = interestRate;
        this.termMonth = termMonth;
        this.reinvestIncome = reinvestIncome;
        this.monthlyAdd = monthlyAdd;
    }

    public double getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getTermMonth() {
        return termMonth;
    }

    public void setTermMonth(int termMonth) {
        this.termMonth = termMonth;
    }

    public boolean isReinvestIncome() {
        return reinvestIncome;
    }

    public void setReinvestIncome(boolean reinvestIncome) {
        this.reinvestIncome = reinvestIncome;
    }

    public double getMonthlyAdd() {
        return monthlyAdd;
    }



    public void setMonthlyAdd(double monthlyAdd) {
        this.monthlyAdd = monthlyAdd;
    }
}
