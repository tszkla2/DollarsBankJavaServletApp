<%@ include file="header.jsp" %>

<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>BANK APP</title>
  </head>

<div class="container">
<% String formType = "trylogin"; %>
	
	<h1>Login!</h1>
	
<form action="<%= formType %>" method="get">
  <div class="mb-3">
    <label for="accountID">AccountID:</label>
    <input type="text" class="form-control" id="accountID" name="accountID" required>
  </div>
  
  <div class="mb-3">
    <label for="password" class="form-label">Password</label>
    <input type="password" class="form-control" id="password" name="password" required>
  </div>
  
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
	
</div>

<%@ include file="footer.jsp" %>
