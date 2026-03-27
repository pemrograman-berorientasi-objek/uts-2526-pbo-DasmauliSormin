package fintech.driver;

import java.util.*;
import fintech.model.*;

/**
 * @author 12S24007 - Dasmauli Sormin
 */
public class Driver3 {

    static int idCounter = 1;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Map<String, Account> acc = new LinkedHashMap<>();


            switch(d[0]){

                case "create-account":
                    acc.put(d[2], new Account(d[1], d[2]));
                    break;

                case "deposit":
                    acc.get(d[1]).deposit(Double.parseDouble(d[2]));
                    break;

                case "withdraw":
                    acc.get(d[1]).withdraw(Double.parseDouble(d[2]));
                    break;

                case "transfer":
                    Account sender = acc.get(d[1]);
                    Account receiver = acc.get(d[2]);
                    double amt = Double.parseDouble(d[3]);
                    if(sender.withdraw(amt)) receiver.deposit(amt);
                    break;
            }
        }

        for(Account a : acc.values()){
            System.out.println(a.getUsername()+"|"+a.getName()+"|"+a.getBalance());
        }
     
    }
}