package menu;

import java.util.Scanner;

class CalculateIncome implements Command {
    private int money;
    private int periodMonths;
    private double years;
    private int monthsInYear = 12;
    private double interestRate;
    private double moneyAfterPeriod;
    private double replenishment;

    @Override
    public void execute() {

        System.out.println("\n\t\t\t\t--COMPOUND INTEREST CALCULATOR--\n");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter money amount: ");
        money = sc.nextInt();
        double moneyBeforePeriod = money;
        System.out.println("Enter period in months: ");
        periodMonths = sc.nextInt();
        years = periodMonths / monthsInYear;
        System.out.println("Enter interest rate %: ");
        interestRate = sc.nextDouble();
        interestRate /= 100;
        System.out.println("How much money in month do you want to add to your deposit?");
        replenishment = sc.nextDouble();
        if (replenishment == 0) {
            calculate();
        } else {
            calculateWithAdd();
        }
        System.out.println("Your investment after: " + periodMonths + "months: " + moneyAfterPeriod + "\nTotal income:" + (moneyAfterPeriod - moneyBeforePeriod));
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getPeriodMonths() {
        return periodMonths;
    }

    public void setPeriodMonths(int periodMonths) {
        this.periodMonths = periodMonths;
    }

    public double getYears() {
        return years;
    }

    public void setYears(double years) {
        this.years = years;
    }

    public int getMonthsInYear() {
        return monthsInYear;
    }

    public void setMonthsInYear(int monthsInYear) {
        this.monthsInYear = monthsInYear;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getMoneyAfterPeriod() {
        return moneyAfterPeriod;
    }

    public void setMoneyAfterPeriod(double moneyAfterPeriod) {
        this.moneyAfterPeriod = moneyAfterPeriod;
    }

    public double getReplenishment() {
        return replenishment;
    }

    public void setReplenishment(double replenishment) {
        this.replenishment = replenishment;
    }

    public void calculateWithAdd() {
        moneyAfterPeriod = money * Math.pow((1 + interestRate / monthsInYear), monthsInYear * years);
        moneyAfterPeriod += replenishment * ((Math.pow((1 + interestRate / monthsInYear), monthsInYear * years) - 1) / (interestRate / monthsInYear));
    }

    public void calculate() {
        moneyAfterPeriod = money * Math.pow((1 + interestRate / monthsInYear), monthsInYear * years);
    }

    public String getDesc() {
        return "Calculate income";
    }

}
