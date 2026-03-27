package fintech.driver;

import java.util.*;
import fintech.model.*;
/**
 * @author 12S24007 - Dasmauli Sormin
 */

public class Driver4 {

    static int idCounter = 1;
    static Map<String, Account> accounts = new LinkedHashMap<>();
    static Map<String, List<Transaction>> history = new HashMap<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            String line = sc.nextLine();
            if (line.equals("")) break;

            String[] d = line.split("#");

            try {
                switch (d[0]) {

                    case "create-account":
                        accounts.put(d[2], new Account(d[1], d[2]));
                        history.put(d[2], new ArrayList<>());
                        break;

                    case "deposit":
                        deposit(d);
                        break;

                    case "withdraw":
                        withdraw(d);
                        break;

                    case "transfer":
                        transfer(d);
                        break;

                    case "show-account":
                        showAccount(d[1]);
                        break;
                }
            } catch (NegativeBalanceException e) {
                // program tidak boleh berhenti → abaikan saja
            }
        }

     
    }

    static void deposit(String[] d) {
        Account a = accounts.get(d[1]);
        double amt = Double.parseDouble(d[2]);
        a.deposit(amt);

        history.get(d[1]).add(
            new DepositTransaction(idCounter++, d[1], amt, d[3], d[4])
        );
    }

    static void withdraw(String[] d) throws NegativeBalanceException {
        Account a = accounts.get(d[1]);
        double amt = Double.parseDouble(d[2]);

        if (!a.withdraw(amt))
            throw new NegativeBalanceException("Saldo tidak cukup");

        history.get(d[1]).add(
            new WithdrawTransaction(idCounter++, d[1], -amt, d[3], d[4])
        );
    }

    static void transfer(String[] d) throws NegativeBalanceException {
        Account sender = accounts.get(d[1]);
        Account receiver = accounts.get(d[2]);
        double amt = Double.parseDouble(d[3]);

        if (!sender.withdraw(amt))
            throw new NegativeBalanceException("Saldo tidak cukup");

        receiver.deposit(amt);

        history.get(d[1]).add(
            new TransferTransaction(idCounter++, d[1], d[2], -amt, d[4], d[5])
        );
    }

    static void showAccount(String username) {

        Account a = accounts.get(username);
        System.out.println(a.getUsername() + "|" + a.getName() + "|" + a.getBalance());

        List<Transaction> list = history.get(username);

        list.sort(Comparator.comparing(Transaction::getTimestamp));

        for (Transaction t : list) {
            System.out.println(
                t.getid() + "|" +
                t.gettype() + "|" +
                t.getamount() + "|" +
                t.gettimestamp() + "|" +
                t.getdescription()
            );
        }
        
    }
}