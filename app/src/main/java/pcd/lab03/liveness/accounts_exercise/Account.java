package pcd.lab03.liveness.accounts_exercise;

class Account {

	private int balance;
	
	public Account(final int amount){
        this.balance = amount;
	}

	public int getBalance(){
		return this.balance;
	}

	public void debit(final int amount){
        this.balance -=amount;
	}

	public void credit(final int amount){
        this.balance +=amount;
	}
}
