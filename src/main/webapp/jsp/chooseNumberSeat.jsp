<%-- 
    Document   : chooseNumberSeat
    Created on : Apr 20, 2017, 9:11:31 AM
    Author     : Windows 10 Gamer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Choose Seat</h1>
        <p>${count}</p>
        
            <c:forEach var="i" begin="1" end="${numberSeatOfEco/10}">
                <form style="margin-bottom: .3em;margin-left: 4em;float:left">
                    <button><c:out value=""/> A</button>
                </form>
             </c:forEach>
            
            <c:forEach var="i" begin="${numberSeatOfEco/10+1}" end="${numberSeatOfEco/10+21}">
                <form style="margin-bottom: .3em;margin-left: 4em;float:left">
                    <button><c:out value=""/> A</button>
                </form>
             </c:forEach>
        
    </body>
</html>
