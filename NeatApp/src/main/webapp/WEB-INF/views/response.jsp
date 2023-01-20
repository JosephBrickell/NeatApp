<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Recipe</title>
</head>
<body>
    <h1>Ingredients</h1>
        <ul>
            <c:forEach items="${ingredients}" var="ingredient">
                <li>${ingredient}</li>
            </c:forEach>
        </ul>
    <h1>Method</h1>
     <ul>
                <c:forEach items="${method}" var="methods">
                    <li>${methods}</li>
                </c:forEach>
            </ul>

</body>
</html>