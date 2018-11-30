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
    <form:form method="post" action="edit" modelAttribute="cate">
    Category ID: <form:input path="categoryId" readonly="true"/><br>
    <br>
    Enter CategoryName:<form:input path="categoryname"/><br>
    <br>
    Enter CategoryDesc:<form:input path="categorydesc"/><br>
    <br>
    <input type="submit" value="Edit"/>
    </form:form>
    
   </div>
     </body>
</html>