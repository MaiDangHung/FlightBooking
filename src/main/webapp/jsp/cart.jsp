<%-- 
    Document   : cart
    Created on : Apr 22, 2017, 9:41:02 PM
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
        <h1>${totalCart}</h1>
        <p>${classticket}</p>
        <c:if test="${cartComponent==null}">
            <p>Not value</p>
        </c:if>
        <c:if test="${cartComponent!=null}">
                    <c:forEach var="cart1" items="${cartComponent.cart}">
                        <label>Từ: </label>
                        <label>${cart1.froms}</label><br>
                        <label>Đến: </label>
                        <label>${cart1.tos}</label><br>
                        <label>Ngày đi: </label>
                        <label>${cart1.dateGoes}</label><br>
                        <label>Giờ đi: </label>
                        <label>${cart1.timeGoes}</label><br>
                        <label>Số ghế: </label>
                        <label>${cart1.seat}</label><br>
                    </c:forEach>
            </c:if>
    </body>
</html>
