<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<title>Insert title here</title>
</head>
<body>
     <div class="container">
    <form:form method="post" action="addSupplier" modelAttribute="Supplier">
    Enter SupplierName:<form:input path="suppliername"/><br>
    <br>
    Enter SupplierDesc:<form:input path="supplierdesc"/><br>
    <br>
    <input type="submit" value="Add"/>
    </form:form>
    
   </div>

</body>
</html>