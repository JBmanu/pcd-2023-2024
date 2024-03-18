package pcd.lab03.liveness.accounts_exercise;

import java.util.Random;

public class TransferAgent extends Thread {
	
	private static final int MAX_AMOUNT = 10;
	private final AccountManager man;
	private final int numTransactions;

	TransferAgent(final AccountManager man, final int numTransactions){
		this.man = man;
		this.numTransactions = numTransactions;
	}
	
	public void run() {
		
		final Random gen = new Random();
		final int numAccounts = this.man.getNumAccounts();
		
		for (int i = 0; i < this.numTransactions; i++){
			
			/* select the source account */
			final int fromAcc = gen.nextInt(numAccounts);
			
			/* select the dest account */
			int toAcc = 0;
			do {
				toAcc = gen.nextInt(numAccounts);
			} while (toAcc == fromAcc);

			/* select an amount of money to transfer */
			final int amount = gen.nextInt(MAX_AMOUNT);

			/* try to transfer */
			try {
                this.log("Transferring from "+fromAcc+" to "+toAcc+" amount "+amount+"...");
                this.man.transferMoney(fromAcc,toAcc,amount);
                this.log("done.");
			} catch (final InsufficientBalanceException ex){
                this.log("Not enough money.");
			}
		}
	}
	
	private void log(final String msg){
		synchronized(System.out){
			System.out.println("["+this+"] "+msg);
		}
	}
}