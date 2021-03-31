<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="/WEB-INF/myjsptags.tld" prefix="mytags" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Invoice</title>
<style type="text/css">
	td,th {
 	 padding: 25px;
	}
	
	.button {
  background-color: #e83e20;
  border: none;
  color: white;
  display: inline;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 10px;
  margin: 4px 2px;
  cursor: pointer;
}
	
</style>
</head>
<body>
	<hr>
	<jsp:include page="logout.jsp"></jsp:include>	
	<hr>
	
	<h1>Invoice</h1>
	<table>
            <thead>
                <tr>
                    <th>Code</th>
                    <th>Name</th>
                    <th>Quantity</th>
                    <th>Price</th>
                </tr>
            </thead>
            
            <tbody>
                 <c:forEach items="${sessionScope.shoppingCart}" var="item">
               		<tr>
                    	<td>${item.key}</td>
                        <c:forEach var="val" items="${item.value}">
                   		 	<td>${val}</td>
                       	</c:forEach>
                   	</tr>
       	 		</c:forEach> 
           </tbody>
      </table>
	<h3 style="font-weight:bold;">Total : <mytags:calculateTotal key="total"/></h3>
	<form action="pdf.do" method="post">
		<input type="hidden" name="formid" value="pdf">
		<button class="button" type="submit">Generate PDF</button>
	</form>
	
	<form action="excel.do" method="post">
		<input type="hidden" name="formid" value="excel">
		<button class="button" type="submit">Generate Excel</button> 
	</form>
	
	<form action="email.do" method="post">
		<input type="hidden" name="formid" value="email">
		<button class="button" type="submit">Send Mail</button>
	</form>
	
	<form action="sms.do" method="post">
		<input type="hidden" name="formid" value="sms">
		<button class="button" type="submit">Send SMS</button>
	</form>
</body>
</html>