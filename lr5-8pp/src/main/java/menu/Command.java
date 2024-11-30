package menu;

import bank.Bank;
import bank.Deposit;
import bank.MyDeposit;

import java.util.*;

public interface Command {
    void execute();
    String getDesc();
}


