package logic;

import cache.Cache;
import pojo.Account;
import pojo.Customer;
import exception.BankException;
import persistence.Connector;
import persistence.Persistence;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public enum Mediator {
    INSTANCE;

    Cache cache = Cache.INSTANCE;

//    public static Map<String, Persistence> loadProps() throws BankException {
//        Map<String, Persistence> map = new HashMap<>();
//            try (FileReader reader = new FileReader("config.properties")) {
//                Properties p = new Properties();
//                p.load(reader);
//                for (Map.Entry entry: p.entrySet()) {
//                    String key = (String) entry.getKey();
    
//
//                    Class<?> cls = Class.forName((String) entry.getValue());
//                    Persistence prs = (Persistence) cls.newInstance();
//                    map.put(key, prs);
//                }
//                
//            } catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException exception) {
//                exception.printStackTrace();
//                throw new BankException("Failed to load properties file", exception);
//            }
//        return map;
//    }

    public void load() throws BankException {

        	Connector connector = new Connector();
            List<Account> accounts = connector.getAccounts();
            List<Integer> usersWithNoActiveAccounts = connector.getUsersWithNoActiveAccounts();
            List<Customer> customers = connector.getCustomers();

            cache.addToCache(accounts);
            cache.addUsersWithNoActiveAccounts(usersWithNoActiveAccounts);
            cache.addToUsers(customers);
        

    }

    public int insertCustomer(Customer customer) throws BankException {
        
        Connector connector = new Connector();
        int userId = connector.insertIntoCustomers(customer);  
        return userId;
    }

    public long insertAccount(Account account) throws BankException {
        
    	Connector connector = new Connector();
        long accountNumber = connector.insertIntoAccounts(account);
        
        return accountNumber;
    }

    public List<Integer> insertCustomers(List<Customer> customers) throws BankException {
        
        Connector connector = new Connector();
        List<Integer> userIds = connector.insertIntoCustomers(customers);
        return userIds;
        
    }

    public List<Long> insertAccounts(List<Account> accounts) throws BankException {
        List<Long> accountNumbers = null;
        Connector connector = new Connector();
        accountNumbers = connector.insertIntoAccounts(accounts);
        
        return accountNumbers;
    }

    public long updateBalance(int option, long accountNumber, long amount) throws BankException {
        long balance = 0;
        Connector connector = new Connector();
        if (option == 1) {
            
             balance = connector.withdrawMoney(accountNumber, amount);
             
            
        } else {
            
            balance = connector.depositMoney(accountNumber, amount);
            
        }
        return balance;
    }

    public boolean deactivateAccount(long accountNumber) throws BankException {
        Connector connector = new Connector();
        boolean done = connector.deactivateAccount(accountNumber);
        return done;
    }

    public boolean deactivateUser(int userid) throws BankException {
        Connector connector = new Connector();
        boolean done = connector.deactivateUser(userid);
   
        return done;
    }
}
