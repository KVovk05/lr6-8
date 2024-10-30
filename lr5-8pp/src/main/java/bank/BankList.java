package bank;
import bank.Deposit;
import java.util.ArrayList;
public class BankList {
private ArrayList<Deposit> depositsList;

    public BankList(ArrayList<Deposit> depositsList) {
        this.depositsList = depositsList;
    }

    @Override
    public String toString() {
        return "BankList{" +
                "depositsList=" + depositsList +
                '}';
    }
    public void addDeposit(Deposit deposit){
        this.depositsList.add(deposit);
    }
    public ArrayList<Deposit> getDepositsList() {
        return depositsList;
    }

    public void setDepositsList(ArrayList<Deposit> depositsList) {
        this.depositsList = depositsList;
    }
}
