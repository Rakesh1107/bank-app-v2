package cache;

import pojo.Account;
import pojo.Customer;
import persistence.Persistence;

import java.util.*;

public enum Cache {
    INSTANCE;

    private static final Map<Integer, Map<Long, Account>> cache = new HashMap<>();
    private static final Map<Integer, Account> accounts = new HashMap<>();
    private static final Map<Integer, Customer> users = new HashMap<>();
    //private static final Map<String, Persistence> layers = new HashMap<>();

    // Adding to cache
    public void addToCache(List<Account> accounts) {
        for (Account account : accounts) {
            int userId = account.getUserId();
            long accountNumber = account.getAccountNumber();
            Map<Long, Account> accountMap = cache.getOrDefault(userId, new HashMap<>());
            accountMap.put(accountNumber, account);
            cache.put(userId, accountMap);
        }
        
    }

    public void addUsersWithNoActiveAccounts(List<Integer> list) {
        for(int userId: list) {
            cache.putIfAbsent(userId, new HashMap<>());
        }
    }
    
    public void addToAccounts(List<Account> accountList) {
		for (Iterator iterator = accountList.iterator(); iterator.hasNext();) {
			Account account = (Account) iterator.next();
			accounts.put(account.getUserId(), account);
		}
	}

    // Adding to users
    public void addToUsers(List<Customer> customers) {
        for (Customer customer : customers) {
            int userId = customer.getUserId();
            users.put(userId, customer);
        }
    }

    // Adding to layers
//    public void addToLayers(Map<String, Persistence> persistenceLayers) {
//        layers.putAll(persistenceLayers);
//    }

    // Getters
    public Map<Integer, Map<Long, Account>> getCache() {
        return cache;
    }

    public Map<Integer, Customer> getUsers() {
        return users;
    }

//    public Map<String, Persistence> getLayers() {
//        return layers;
//    }
}
