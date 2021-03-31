<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shop 2</title>
<style type="text/css">
	td,th {
 	 padding: 25px;
	}

	.button {
  background-color: #e83e20;
  border: none;
  color: white;
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
	
	<h1>Cosmetic Shop</h1>
	<form action="shop.do" method="post">
		<input type="hidden" name="formid" value="shop">
		<input type="hidden" name="shopid" value="shop3">
		<table>
            <thead>
                <tr>
                    <th>Code</th>
                    <th>Image</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                </tr>
            </thead>
            
            <tbody>
                <c:forEach items="${sessionScope.shopDTO}" var="item">
                <tr>
                    <td>${item.getProduct_code()}</td>
                    <td><img  src="data:image/jpg;base64,${item.getProduct_image()}" width="100" height="100"></td>
                    <td>${item.getProduct_name()}</td>
                    <td>${item.getProduct_price()}</td>
                    
                    <td>
                    	<select name="${item.getProduct_code()}" onmousedown="if(this.options.length>6){this.size=6;}"  onchange='this.size=0;' onblur="this.size=0;">
							<c:forEach var="i" begin="0" end="${item.getProduct_units()}" varStatus="loop">
  								<option>${i}</option>
							</c:forEach>
						</select>	
					</td>
					
					<td><input type="checkbox" name="${item.getProduct_code()}" value="${item.getProduct_name()}"></td>
                </tr>
                </c:forEach>
           </tbody>
        </table>
		<button class="button" type="submit">Next</button>
	</form>
</body>
</html>