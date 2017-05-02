<%-- 
    Document   : checkOut
    Created on : Apr 23, 2017, 8:50:36 PM
    Author     : Windows 10 Gamer
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/jquery-ui.min.css">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <title>JSP Page</title>
<!--        <style>
            table{
                border: 1px solid black;
                border-collapse: collapse;
            }
            th,td{
                border: 1px solid black;
                padding: .5em;
            }
        </style>-->
        <script>
            function myFunction() {
              var xhttp = new XMLHttpRequest();   
              var from = document.getElementById("cardNumber").value;
              
              
              xhttp.onreadystatechange = function() {
                if (this.readyState === 4 && this.status === 200) {                                  
                  document.getElementById("demo").innerHTML=xhttp.responseText;;
                }
              };
              //content('Content-Type:text/html; charset=UTF-8');
              xhttp.open("GET", "${pageContext.request.contextPath}/cardNumber/" + from, true);
              xhttp.send();
            }  
            </script>
            <script>
            function myFunction1(){
                var xhttp = new XMLHttpRequest();   
              var from = document.getElementById("cardNumber").value;
              var validate = document.getElementById("validateNumber").value;
              
              alert("${pageContext.request.contextPath}/validateNumber/" + from +"/"+validate);
              xhttp.onreadystatechange = function() {
                if (this.readyState === 4 && this.status === 200) {                                  
                  document.getElementById("demo1").innerHTML=xhttp.responseText;;
                }
              };
              //content('Content-Type:text/html; charset=UTF-8');
              xhttp.open("GET", "${pageContext.request.contextPath}/validateNumber/" + from +"/"+validate, true);
              xhttp.send();
            }
            </script>
            <script>
            function myFunction2(){
                var xhttp = new XMLHttpRequest();   
              var from = document.getElementById("cardNumber").value;
              var validate = document.getElementById("securityNumber").value;
              
              //alert("${pageContext.request.contextPath}/cardNumber/" + from);
              xhttp.onreadystatechange = function() {
                if (this.readyState === 4 && this.status === 200) {                                  
                  document.getElementById("demo2").innerHTML=xhttp.responseText;;
                }
              };
              //content('Content-Type:text/html; charset=UTF-8');
              xhttp.open("GET", "${pageContext.request.contextPath}/securityNumber/" + from +"/"+validate, true);
              xhttp.send();
            }
        </script>
    </head>
    <body>
        <h1>Check Out Form</h1>
        <div>
            <table>
            <tr>
                <th>Mã chuyến bay</th>
                <th>Từ</th>
                <th>Đến</th>
                <th>Số ghế</th>
                <th>Tên Hành Khách</th>
                <th>Số CMND</th>
                <th>Loại vé</th>
                <th>Hạng vé</th>
                <th>Hành lý ký gửi</th>
                <th>Giá hành lý ký gửi</th>
                <th>Giá vé</th>
                <th>Phụ thu</th>
                <th>Thành tiền</th>
                <th></th>
            </tr>
            <c:forEach var="cart" items="${cartComponent.cart}">
                <tr>
                    <td>${cart.flightID}</td>
                    <td>${cart.froms}</td>
                    <td>${cart.tos}</td>
                    <td>${cart.seat}</td>
                    <td>${cart.cusName}</td>
                    <td>${cart.cmnd}</td>
                    <td>${cart.typeTicket}</td>
                    <td>${cart.classTicket}</td>
                    <td>${cart.luggage}</td>
                    <td>${luggagePrice}</td>
                    <td>${cart.price}</td>
                    <td>${cart.price*20/100}</td>
                    <td>${cart.price + cart.price*20/100}</td>
                    <td><a href="del/${cart.seat}">Xóa</a></td>
                </tr>
            </c:forEach>
                <tr>
                    <td></td>
                    <td>Tổng cộng: </td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>${total}</td>
                </tr>
        </table>
            </div>
            <div>
                <mvc:form modelAttribute="booking" action="${pageContext.request.contextPath}/checkOutFinish" method="post">
                <table>
                    <tr>
                        <td>Customer Name (*)</td>
                        <td><mvc:input path="customerName" required="true" placeholder="Customer Name" /></td>
                    </tr>
                    <tr>
                        <td>Customer Address (*)</td>
                        <td><mvc:input path="customerAddress" required="true" placeholder="Customer Address" /></td>
                    </tr>
                    <tr>
                        <td>Customer Phone (*)</td>
                        <td><mvc:input path="customerPhone" required="true" placeholder="Customer Phone" /></td>
                    </tr>
                    <tr>
                        <td>Customer Email (*)</td>
                        <td><mvc:input path="customerEmail" type="email" required="true" placeholder="Customer Email" /></td>
                    </tr>
                    <tr>
                        <td>Nhập thông tin thanh toán</td>
                    </tr>
                    <tr>
                        <td>Nhập số card:</td>
                        <td><input type="text" name="cardNumber" id="cardNumber" onchange="myFunction()"/></td>
                        <td><p id="demo"></p></td>
                    </tr>
                    <tr>
                        <td>Nhập số xác nhận:</td>
                        <td><input type="text" name="validateNumber" id="validateNumber" onchange="myFunction1()"/></td>
                        <td><p id="demo1"></p></td>
                    </tr>
                    <tr>
                        <td>Nhập số bảo vệ:</td>
                        <td><input type="text" name="securityNumber" id="securityNumber" onchange="myFunction2()"/></td>
                        <td><p id="demo2"></p></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" value="Submit" />
                        </td>   
                    </tr>
                </table>
            </mvc:form>
            </div>
    </body>
</html>
