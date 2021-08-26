package pojo;

public class ObjectCreator {
	
	
	public static Customer createCustomer(String name, long mobileNumber, String address) {
		Customer customer = new Customer();
		
		customer.setName(name);
		customer.setMobileNumber(mobileNumber);
		customer.setAddress(address);
		customer.setTime(System.currentTimeMillis());
		
		return customer;
	}
	
	public static Account createAccount(int userId, String branch, long deposit) {
		
		Account account = new Account();
		
		account.setUserId(userId);
		account.setBranch(branch);
		account.setBalance(deposit);
		account.setTime(System.currentTimeMillis());
		
		return account;
		
	}
	
	public static Transaction createTransaction(long accountNumber, long amount) {
		
		Transaction transaction = new Transaction();
		
		transaction.setAccountNumber(accountNumber);
		transaction.setAmount(amount);
		
		return transaction;
		
	}

}
