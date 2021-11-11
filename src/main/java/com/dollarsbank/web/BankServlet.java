package com.dollarsbank.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;

import com.dollarsbank.model.Customer;

@WebServlet("/")
public class BankServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public static List<Customer> list = new ArrayList<Customer>();	

	//Adds initial accounts to the system
	static {
		list.add(new Customer("Tom", "123 Drive", "123-456-7890", "001", "password", 500));
		list.add(new Customer("Bill", "456 Drive", "987-654-3210", "002", "password", 100));
		list.add(new Customer("Joe", "789 Drive", "000-111-2345", "003", "password", 345));
	}
	
	public int index;
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

		 		doGet(request, response);
	    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

        switch (action) {
//        	case "/createAccount":
//	            createAccount(request, response);
//	            break;
	        case "/login":
	        	goToLoginPage(request, response);
	            break;
            case "/trylogin":
                handleLogin(request, response);
                break;
            case "/listHistory":
                goToHistory(request, response);
                break;
            case "/deposit":
                goToDeposit(request, response);
                break;
            case "/withdraw":
                goToWithdraw(request, response);
                break;
            case "/transfer":
                goToTransfer(request, response);
                break;
            case "/information":
                information(request, response);
                break;
            case "/handleDeposit":
                handleDeposit(request, response);
                break;
            case "/handleWithdraw":
                handleWithdraw(request, response);
                break;
                
            case "/logout":
            	response.sendRedirect("/DollarsBankJavaServletApp");
            	break;    
	        default:
                response.sendRedirect("/");
                break;
			}
	}
	
	public void goToLoginPage(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		
		dispatcher.forward(request, response);
	}	 
	
	 public void handleLogin(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
		
		String accountID = request.getParameter("accountID");
		String password = request.getParameter("password");
		
		for (Customer customer : list) {
				if (customer.getAccountID().equals(accountID) && customer.getPassword().equals(password)) {
					index = list.indexOf(customer);
					request.setAttribute("customer", customer);
					RequestDispatcher dispatcher = request.getRequestDispatcher("logged_in.jsp");
					dispatcher.forward(request, response);
					break;
				}
				else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
					dispatcher.forward(request, response);
				}
				
			}
	 }
	 
	 public void handleDeposit(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
			
			String depositAmount = request.getParameter("deposit");
			double money = Double.parseDouble(depositAmount);
			
			if(money >= 0) {
				list.get(index).deposit(money);
				response.sendRedirect("information");
			}
			else {
				response.sendRedirect("deposit");
			}
	 }
	 
	 public void handleWithdraw(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
			
			String withdrawAmount = request.getParameter("withdraw");
			double money = Double.parseDouble(withdrawAmount);
			
			if(money >= 0 && money <= list.get(index).getBalance()) {
				list.get(index).withdraw(money);
				response.sendRedirect("information");
			}
			else {
				response.sendRedirect("withdraw");
			}
	 }
	 
	 
	 public void information(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
		 
		request.setAttribute("customer", list.get(index));
		RequestDispatcher dispatcher = request.getRequestDispatcher("info.jsp");
			
		dispatcher.forward(request, response);
		}	 

	 public void goToDeposit(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("deposit.jsp");
			
			dispatcher.forward(request, response);
	 }
	 
	 public void goToWithdraw(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("withdraw.jsp");
			
			dispatcher.forward(request, response);
	 }
	 
	 public void goToTransfer(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("transfer.jsp");
			
			dispatcher.forward(request, response);
	 }
	 
	 public void goToHistory(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
		 
//		 	request.setAttribute("transactionHistory", list.get(index).displayHistory(););
			RequestDispatcher dispatcher = request.getRequestDispatcher("history.jsp");
			
			dispatcher.forward(request, response);
		}	
}
