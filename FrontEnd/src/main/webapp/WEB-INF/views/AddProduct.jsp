<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     <div class="container">
    <form:form method="post" action="add" modelAttribute="Products" enctype="multipart/form-data">
    Enter ProductName:<form:input path="productname"/><br>
    <br>
    Enter ProductDesc:<form:input path="productdesc"/><br>
    <br>
    Enter Quantity:<form:input path="quantity"/><br>
    <br>
    Enter Price:<form:input path="price"/><br>
    <br>
    Image <form:input type="file" path="pimage"/><br>
	<br>
    <input type="submit" value="Add"/>
    </form:form>
    
   </div>
     
     

</body>
</html>