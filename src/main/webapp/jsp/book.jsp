<%-- 
    Document   : book
    Created on : 23-Mar-2017, 15:49:49
    Author     : MyPC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>${action}</h1>
        <mvc:form action="${pageContext.request.contextPath}/${action}" modelAttribute="book" method="post">
            <table>
                <c:if test="${action=='update'}">
                <tr>
                    <td>ID: </td>
                    <td><mvc:input path="id" type="text" required="true" readonly="${readonly}"/></td>
                </tr>
                </c:if>
                <tr>
                    <td>Name(*): </td>
                    <td><mvc:input path="name" type="text" required="true"/></td>
                </tr>
                <tr>
                    <td>Author(*): </td>
                    <td><mvc:input path="author" type="text" required="true"/></td>
                </tr>
                <tr>
                    <td>ISBN(*): </td>
                    <td><mvc:input path="isbn" type="text" required="true"/></td>
                </tr>
                <tr>
                    <td>Price(*): </td>
                    <td><mvc:input path="price" type="text" required="true"/></td>
                </tr>
                <tr>
                    <td>Publish Date: </td>
                    <td><mvc:input path="publishDate" type="Date" required="true"/></td>
                </tr>
                <tr>
                    <td>Category: </td>
                    <td><mvc:select path="category">
                            <mvc:option value="Programming">Programming</mvc:option>
                            <mvc:option value="Database">Database</mvc:option>
                        </mvc:select></td>
                </tr>
                <tr>                    
                    <td colspan="2"><input type="submit" value="Submit"/></td>                    
                </tr>
            </table>
        </mvc:form>
    </body>
</html>
