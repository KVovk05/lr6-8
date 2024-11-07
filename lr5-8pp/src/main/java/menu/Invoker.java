package menu;
import bank.Deposit;
import bank.Bank;
import main.MyDeposit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class Invoker {
    private Map <String,Command> commandMap = new HashMap<>();

    public Invoker() {

    }

    public void addComands(ArrayList<Deposit> deposits, ArrayList<MyDeposit> myDeposits,ArrayList<Bank> banks){
        commandMap.put("Show list of available deposits",new ShowDepositList(deposits));
        commandMap.put("Add deposit",new ChooseDesiredDeposit(deposits,myDeposits));
        commandMap.put("Replenish my deposit",new Replenishment(myDeposits));
        commandMap.put("Withdraw money",new WithdrawMoney(myDeposits));
        commandMap.put("Show my deposit", new ShowMyDeposit(myDeposits));
        commandMap.put("Calculate income", new CalculateIncome());
        commandMap.put("Find bank by ID", new FindBankById());
        commandMap.put("Delete my Deposit", new DeleteMyDeposit(myDeposits));

    }
    public Command getCommand(String commandName) {
        return commandMap.get(commandName);
    }
}
