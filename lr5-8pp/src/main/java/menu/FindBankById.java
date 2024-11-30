package menu;

import bank.Bank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class FindBankById implements Command {
    private Map<Integer, Bank> map = new HashMap<>();
    private int id;

    public void execute() {
        AddBanks();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id of a bank!");
        id = sc.nextInt();
        System.out.println(map.get(id));
    }

    public void AddBanks() {
        map.put(1, new Bank("Monobank", 1));
        map.put(2, new Bank("Union bank", 2));
        map.put(3, new Bank("Bank of America", 3));
        map.put(4, new Bank("First European Bank", 4));
    }

    public String getDesc() {
        return "Find bank by ID";
    }

    public Map<Integer, Bank> getMap() {
        return map;
    }
}
