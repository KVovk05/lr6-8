package menu;
import bank.Deposit;
import bank.MyDeposit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Invoker implements Command {
    protected Map <String,Command> commandMap = new HashMap<>();

    public void addComands(ArrayList<Deposit> deposits, ArrayList<MyDeposit> myDeposits){
        commandMap.put("show_list",new ShowDepositList(deposits));
        commandMap.put("add",new ChooseDesiredDeposit(deposits,myDeposits));
        commandMap.put("replenish",new Replenishment(myDeposits));
        commandMap.put("withdraw",new WithdrawMoney(myDeposits));
        commandMap.put("show_dep", new ShowMyDeposit(myDeposits));
        commandMap.put("calculate", new CalculateIncome());
        commandMap.put("find_bank", new FindBankById());
        commandMap.put("delete", new DeleteMyDeposit(myDeposits));


    }
    public Command getCommand(String commandName) {
        return commandMap.get(commandName);
    }

    public void printMenu(){
        System.out.println("\nMENU");
        for (var element : commandMap.entrySet()){
            System.out.println(element.getKey() + " : " + element.getValue().getDesc());
        }
        System.out.println("exit: Exit");
    }

    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            printMenu();
            String choose = sc.nextLine();
            if (choose.equals("exit"))
                break;

            Command command = getCommand(choose);
            command.execute();
        }
    }

    @Override
    public String getDesc() {
        return "Menu";
    }
}
