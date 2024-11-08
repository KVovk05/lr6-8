package bank;

import java.util.ArrayList;

public class Bank {
    private String name;
    private int bankId;

    public Bank(String name, int bankId) {
        this.name = name;
        this.bankId = bankId;

    }

    public Bank() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBankId() {
        return bankId;
    }


    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    @Override
    public String toString() {
        return "Bank\n" +
                "Name: " + name + '\'' +
                "\nbankID: " + bankId;
    }
}
