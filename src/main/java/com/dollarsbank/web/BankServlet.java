package com.dollarsbank.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.cognixia.jump.model.Librarian;
import com.cognixia.jump.model.Patron;
import com.dollarsbank.model.Customer;

@WebServlet("/")
public class BankServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public static List<Customer> list = new ArrayList<Customer>();	

	//Adds initial accounts to the system
	static {
		list.add(new Customer("Tom", "123 Drive", "123-456-7890", "001", "password", 500));
		list.add(new Customer("Bill", "456 Drive", "987-654-3210", "002", "password", 100));
	}
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

		 		doGet(request, response);
	    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

        switch (action) {
        	case "/createAccount":
	            createAccount(request, response);
	            break;
	        case "/login":
	        	goToLoginPage(request, response);
	            break;
	        default:
                response.sendRedirect("/");
                break;
			}
	}
	
	
	
	
	private void createAccount(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("createAccount.jsp");
		
		dispatcher.forward(request, response);
	}
	
	private void goToLoginPage(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		
		dispatcher.forward(request, response);
	}	 
	
	 private void handleLogin(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
		
		String accountID = "";
		String password = "";
		
		for (Customer customer : list) {
				if (customer.getAccountID().equals(accountID) && customer.getPassword().equals(password)) {
					int i = list.indexOf(customer);
					welcomeCustomer(i);
					break;
						
				}

			}
	 }
}
