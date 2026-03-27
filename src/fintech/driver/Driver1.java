package fintech.driver;

import fintech.model.*;
import java.util.*;
/**
 * @author 12S24007_Dasmauli Sormin
 */

public class Driver1 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Map<String, Account> accounts = new linkedHashMap<>();

       

            String[] d = line.split("#");

            if (d[0].equals("create-account")) {
                accounts.put(d[2], new Account(d[1], d[2]));
            }
        }

        for (Account a : accounts.values()) {
            System.out.println(a.getUsername()+"|"+a.getName()+"|"+a.getBalance());
        }

    
    }
}