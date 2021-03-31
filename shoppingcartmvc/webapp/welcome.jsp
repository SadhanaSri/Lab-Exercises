<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/myjsptags.tld" prefix="mytags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="jumbotron text-center">
		<h1>Welcome <mytags:username key="name"/> </h1>
		<hr>
			<jsp:include page="logout.jsp"></jsp:include>	
		<hr>
	
		<form class="form-inline" action="shopping.do" method="post">
			<input type="hidden" name="formid" value="shopping" />
			<input type="hidden" name="shopid" value="shop1"/>
			<div class="input-group-btn">
        			<button type="submit" class="btn btn-danger" value="shop">Shop</button>
    			</div>
		</form>
	</div>
</body>
</html>