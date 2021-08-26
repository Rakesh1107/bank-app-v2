package pojo;

public class Transaction {

	long accountNumber;
	long amount;
	
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public void setAmount(long amount) {
		this.amount = amount;
	}
	
	public long getAccountNumber() {
		return accountNumber;
	}
	
	public long getAmount() {
		return amount;
	}
}
