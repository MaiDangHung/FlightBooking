<%-- 
    Document   : trangchu
    Created on : 12-Apr-2017, 16:57:12
    Author     : MyPC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>home</title>
   
    <!--<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">-->
    <!--<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">-->
    <!--<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery-ui.min.css">-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
            table{
                border: 1px solid black;
                border-collapse: collapse;
            }
            th,td{
                border: 1px solid black;
                padding: .5em;
                text-align: center;
            }
        </style>
        <script>
            function myFunction() {
              var xhttp = new XMLHttpRequest();   
              var fromList = document.getElementById("from");
              var from = fromList.options[fromList.selectedIndex].value;
              //alert("Test: " + from);
              xhttp.onreadystatechange = function() {
                if (this.readyState === 4 && this.status === 200) {                                  
                  document.getElementById("demo").innerHTML=this.responseText;;
                }
              };
              //content('Content-Type:text/html; charset=UTF-8');
              xhttp.open("GET", "ajaxDemo/" + from, true);
              xhttp.send();
            }        
        </script>
        <script>
            function khuhoi(){
                $(".ngayve").show();
            }
        </script>
        <script>
            function motchieu(){
                $(".ngayve").hide();
            }
        </script>
        <script language="javascript" type="text/javascript">
        function ghi(v1,v2){
            document.getElementById("seat1").innerHTML=v1;
            form2.seat2.value=v1;
            form2.classTicket.value=v2;
      }
  </script>
  <script language="javascript" type="text/javascript">
        function ghi1(v1,v2){//
            document.getElementById("seat1").innerHTML=v1;
            form4.seat2.value=v1;
            form4.classTicket.value=v2;
      }
  </script>
  <script>
      function onload(){
          $("#eco").show();
          $("#skyboss").hide();
      }
  </script>
        <script>
            function eco(){
                $("#eco").show();
                $("#skyboss").hide();
            }
        </script>
        <script>
            function skyboss(){
                $("#skyboss").show();
                $("#eco").hide();
            }
        </script>
        <script>
            function loadSeat(){
               var x=document.getElementsByID("seat").value;
                    <c:forEach var="seat" items="${seatNumber}">
                        <c:if test="${seat.seatNumber==x}">
                            document.getElementsByClassName("btn btn-info btn-lg").style.background-color="green";
                        </c:if>
                    </c:forEach>
            }
        
        </script>
  </head>
  <body>
    <!-- -->
    <div class="container">
		<div class="header">
			<marquee><h4> Vé máy bay giá rẻ trực tuyến hàng đầu Việt Nam</h4></marquee>
		</div>
		
		<div id="logo">
          <img src="${pageContext.request.contextPath}/img/travelo.png" />
        </div>
		
		<!-- menu-->
        <div id="nav_menu">
          <ul id="menu_top" class="nav nav-pills">			
            <li role="presentation"><a href="#"><h4>Trang chủ</h4></a></li>
            <li role="presentation"><a href="#"><h4>Giới thiệu</h4></a></li>
            <li role="presentation"><a href="#"><h4>Tin tức</h4></a></li>
            <li role="presentation"><a href="#"><h4>Vé nội địa</h4></a></li>
            <li role="presentation"><a href="#"><h4>Vé quốc tế</h4></a></li>
            <li role="presentation"><a href="#"><h4>Liên hệ</h4></a></li>         
          </ul>
        </div>
