<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<title>Insert title here</title>
</head>
<body>
      <div class="container">
    <form:form method="post" action="addCategory" modelAttribute="Category">
    Enter CategoryName:<form:input path="categoryname"/><br>
    <br>
    Enter CategoryDesc:<form:input path="categorydesc"/><br>
    <br>
    <input type="submit" value="Add"/>
    </form:form>
    
   </div>
     

</body>
</html>