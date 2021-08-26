package base;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cache.Cache;
import exception.BankException;
import logic.Initiator;
import persistence.Connector;
import pojo.Account;
import pojo.Customer;
import pojo.ObjectCreator;
import pojo.Transaction;

public class BankServlet extends HttpServlet {

	Initiator initiator = Initiator.INSTANCE;
	Cache cache = Cache.INSTANCE;
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String query = req.getParameter("page");
		
	    if (query.equalsIgnoreCase("accounts")) {
	      	
	    	try {
				Connector connector = new Connector();
				List<Account> accounts = connector.getAccounts();
				
				req.setAttribute("data", accounts);
				RequestDispatcher rd = req.getRequestDispatcher("accounts.jsp");
				rd.forward(req, resp);
				
			} catch (BankException e) {
				PrintWriter pw = resp.getWriter();
				pw.print("Not able to retrieve accounts at the moment");
			}
	    	
		}
	    
	    else if (query.equalsIgnoreCase("customers")) {
	    	try {
				Connector connector = new Connector();
				List<Customer> customers = connector.getCustomers();
				
				req.setAttribute("data", customers);
				RequestDispatcher rd = req.getRequestDispatcher("customers.jsp");
				rd.forward(req, resp);
				
			} catch (BankException e) {
				PrintWriter pw = resp.getWriter();
				pw.print("Not able to retrieve customers at the moment");
			}
		}
	    
	    else if (query.equalsIgnoreCase("transactions")) {
	    	
	    	try {
	    		Connector connector = new Connector();
				List<Transaction> transactions = connector.getTransactions();
				
				req.setAttribute("data", transactions);
				RequestDispatcher rd = req.getRequestDispatcher("transactions.jsp");
				rd.forward(req, resp);
	    	}
	    	catch (BankException e) {
	    		PrintWriter pw = resp.getWriter();
				pw.print("Not able to retrieve transactions at the moment");
			}
		}
	    
	    else if (query.equalsIgnoreCase("add-account")) {
	    	RequestDispatcher rd = req.getRequestDispatcher("add-account.jsp");
			rd.forward(req, resp);
		}
	    
	    else if (query.equalsIgnoreCase("add-customer")) {
	    	RequestDispatcher rd = req.getRequestDispatcher("add-customer.jsp");
			rd.forward(req, resp);
		}
	    
	    else if (query.equals("new-user")) {
	    	
	    	
			try {
				Connector connector = new Connector();
				
				Customer customer = ObjectCreator.createCustomer(req.getParameter("name"), Long.parseLong(req.getParameter("phone")), req.getParameter("address"));
		    	
		    	int userId = connector.insertIntoCustomers(customer);
				
				customer.setUserId(userId);
		    	
		    	Account account = ObjectCreator.createAccount(userId, req.getParameter("branch"), Integer.parseInt(req.getParameter("deposit")));

				long accountNumber = connector.insertIntoAccounts(account);
				
				account.setAccountNumber(accountNumber);

				String message = "Hi " + customer.getName() + ", your user id is " + userId + " and new account number is " + accountNumber;
				
				req.setAttribute("message", message);
		    	
		    	RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
				rd.forward(req, resp);
				
			} catch (BankException e1) {
				e1.printStackTrace();
			}
	    	
	    	
		}
	    
	    else if (query.equals("new-account")) {
	    	try {
				Connector connector = new Connector();
				
				Account account = ObjectCreator.createAccount(Integer.parseInt(req.getParameter("userid")), req.getParameter("branch"), Integer.parseInt(req.getParameter("deposit")));

				long accountNumber = connector.insertIntoAccounts(account);
				
				account.setAccountNumber(accountNumber);
				
				String message = "Hi, your new account number is " + accountNumber;
				
				req.setAttribute("message", message);
		    	
		    	RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
				rd.forward(req, resp);
				
			} catch (BankException e1) {
				e1.printStackTrace();
			}
		}
	}

}
