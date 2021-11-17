<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.dollarsbank.model.Customer"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>BANK APP</title>
  </head>
  
  
  <body>	
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="container-fluid">
			
 				<a class="navbar-brand" href="<%= request.getContextPath() %>/logout">Logout</a>
		
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
					aria-controls="navbarNavAltMarkup" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>			
				
				<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
					<div class="navbar-nav">
					
						<a class="nav-link" 
						   href="<%= request.getContextPath() %>/deposit">Deposit</a> 
						   
						<a class="nav-link" 
						   href="<%= request.getContextPath() %>/withdraw">Withdraw</a>
						   
						<a class="nav-link" 
						   href="<%= request.getContextPath() %>/transfer">Transfer</a>
						   
						<a class="nav-link" 
						   href="<%= request.getContextPath() %>/listHistory">History</a>
						   
						<a class="nav-link" 
						   href="<%= request.getContextPath() %>/information">Information</a>
					</div>
				</div>
				
			</div>
		</nav>
		
<div class="container">
	
	<h1>History</h1>
		<c:forEach var="history" items="${transactionHistory}" >
    		<ul>
  				<li><c:out value="${history}" /></li>
			</ul> 
		</c:forEach>
</div>
		
		
  </body>
</html>

<%@ include file="footer.jsp" %>