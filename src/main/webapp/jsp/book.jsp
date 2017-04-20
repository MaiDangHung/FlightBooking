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
        <style>
            table{
                border: 1px solid black;
                border-collapse: collapse;
            }
            th,td{
                border: 1px solid black;
                padding: .5em;
            }
        </style>
        <script>
            function ClassTicket(){
               // var dateGoes=$('input:radio[name=classTicketID]:checked').val();
              var date = document.getElementById("#classTicket123").value;
              alert("Hello");
              alert(date);
            }
        </script>
    </head>
    <body>
        <p>${message}</p>
        <p>${message1}</p>
        <table>
                <thead>
                    <tr>
                        <th>Date Goes</th>
                        <th>Time Goes</th>
                        <th>From</th>
                        <th>To</th>
                        <th>Flight Code</th>
<!--                        <th>Eco</th>
                        <th>Skyboss</th>-->
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="book" items="${bookList}">
                        <tr>
                        <td id="dateGoes">${book.dateGoes}</td>
                        <td>${book.timeGoes}</td>
                        <td>${book.froms}</td>                        
                        <td>${book.tos}</td>
                        <td>${book.flightID}</td>
<!--                        <td><input type="radio" name="classTicketID" value="1" onclick="ClassTicket()" id="classTicket123"> ${book.price}<br></td>
                        <td><input type="radio" name="classTicketID" value="2"> ${book.price+book.price}<br></td>-->
                        <td><a href="showFlight/${book.flightID}">Chọn chuyến bay</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        
        <table style="visibility: ${hidden}">
                <thead>
                    <tr>
                        <th>Date Goes</th>
                        <th>Time Goes</th>
                        <th>From</th>
                        <th>To</th>
                        <th>Flight Code</th>
                        <th>Eco</th>
                        <th>Skyboss</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="book" items="${bookList1}">
                        <tr>
                        <td>${book.dateGoes}</td>
                        <td>${book.timeGoes}</td>
                        <td>${book.froms}</td>                        
                        <td>${book.tos}</td>
                        <td>${book.flightID}</td>
                        <td><input type="radio" name="classTicketID1" value="1"> ${book.price}<br></td>
                        <td><input type="radio" name="classTicketID1" value="2"> ${book.price+book.price}<br></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
               
                <p id="inf"></p>    
            
    </body>
</html>
