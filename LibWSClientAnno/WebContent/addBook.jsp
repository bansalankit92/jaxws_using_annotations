<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body align="center" >
<br/><br/>
<a href="BookList.jsp">Get Book Name By ID's</a>
<br/><br/>
<form action="AddBookServlet" method="post">
<input type="number" name="id" placeholder="id"><br/>
<input type="text" name="name" placeholder="Book Name" ><br/>
<input type="text" name="author" placeholder="Author"><br/>
Price(Rs) :<input type="number" onchange="setTwoNumberDecimal" min="0" max="10000" value="10.50" name="price" placeholder="Price"><br/>
<input type="text" name="isbn" placeholder="ISBN number"><br/><br/>
<button type="submit"  value="Submit">Add Book</button>

</form>
</body>
<script type="text/javascript">
function setTwoNumberDecimal(event) {
    this.value = parseFloat(this.value).toFixed(2);
}</script>
</html>