package pcd.lab03.liveness.accounts_exercise;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AccountManager {

    private final Account[] accounts;
    private final Lock[] locks;

    public AccountManager(int nAccounts, int amount) {
        accounts = new Account[nAccounts];
        locks = new ReentrantLock[nAccounts];

        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account(amount);
            locks[i] = new ReentrantLock();
        }
    }

    public void transferMoney(int from, int to, int amount) throws InsufficientBalanceException {
        // importante l odine dei lock, in modo da dare sempre lo stesso ordine di accesso

        int first = from;
        int last = to;

        if (first > last) {
            last = first;
            first = to;
        }

        synchronized (accounts[first]) {
            synchronized (accounts[last]) {
                if (accounts[from].getBalance() < amount)
                    throw new InsufficientBalanceException();
                accounts[from].debit(amount);
                accounts[to].credit(amount);
            }
        }
    }

    public int getNumAccounts() {
        return accounts.length;
    }
}

