package base;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cache.Cache;
import exception.BankException;
import logic.Initiator;
import pojo.Customer;

public class BankServlet extends HttpServlet {

	Initiator initiator = Initiator.INSTANCE;
	Cache cache = Cache.INSTANCE;
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
			initiator.initiate();
		} catch (BankException e) {
			e.printStackTrace();
		}
    	
		
	    String query = req.getParameter("page");
	
	    if (query.equalsIgnoreCase("accounts")) {
	  
	    	resp.setContentType("text/html");
	    	PrintWriter pw = resp.getWriter();
	    	pw.print("<html><body>");
	    	Map<Integer, Customer> customers = cache.getUsers();
			
			for (Customer customer: customers.values()) {
				pw.print(customer);
			}
	    	pw.print("</body></html>");
	    	pw.close();
	    	
//	    	RequestDispatcher rd = req.getRequestDispatcher("accounts.jsp");
//	 
//			rd.forward(req, resp);
		}
	    
	    else if (query.equalsIgnoreCase("customers")) {
	    	RequestDispatcher rd = req.getRequestDispatcher("customers.jsp");
			rd.forward(req, resp);
		}
	    
	    else if (query.equalsIgnoreCase("transactions")) {
	    	RequestDispatcher rd = req.getRequestDispatcher("transactions.jsp");
			rd.forward(req, resp);
		}
		
	}

}
