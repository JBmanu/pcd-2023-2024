package pcd.lab03.liveness.accounts_exercise;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AccountManager {

    private final Account[] accounts;
    private final Lock[] locks;

    public AccountManager(final int nAccounts, final int amount) {
        this.accounts = new Account[nAccounts];
        this.locks = new ReentrantLock[nAccounts];

        for (int i = 0; i < this.accounts.length; i++) {
            this.accounts[i] = new Account(amount);
            this.locks[i] = new ReentrantLock();
        }
    }

    public void transferMoney(final int from, final int to, final int amount) throws InsufficientBalanceException {
        // importante l odine dei lock, in modo da dare sempre lo stesso ordine di accesso

        int first = from;
        int last = to;

        if (first > last) {
            last = first;
            first = to;
        }

        synchronized (this.accounts[first]) {
            synchronized (this.accounts[last]) {
                if (this.accounts[from].getBalance() < amount)
                    throw new InsufficientBalanceException();
                this.accounts[from].debit(amount);
                this.accounts[to].credit(amount);
            }
        }
    }

    public int getNumAccounts() {
        return this.accounts.length;
    }
}

