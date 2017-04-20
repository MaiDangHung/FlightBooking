<%-- 
    Document   : trangchu
    Created on : 12-Apr-2017, 16:57:12
    Author     : MyPC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>home</title>
   
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/jquery-ui.min.css">

<!--    <script>
       $(document).ready(function() 
        {
            $("#countryList").change(function() 
            {
                var selectedValue = $(this).find(":selected").val();
                $.ajax
                ({
                    url : "a.html?cID="+selectedValue+'',
                    success : function(result) 
                    {
                        $("#prvContatiner").html(result);
                    }
                });
            });
        });
 
        </script>-->
<!--        <script>
//        function myFunction() {
//            var x = document.getElementById("countryList").value;
         $(document).ready(function(){
             $("#countryList").change(function(){
         var x=$("#countryList").val();
            $.ajax
                ({
                    url : "a.html?cID="+selectedValue+'',
                    type: "post",
                    data: "froms="+x,
                    async: true,
                    success : function(result) 
                    {
                        $("#prvContatiner").html(result);
                        
                    }
                });
                });
                
            });
        </script>-->
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
  </head>
  <body>
    <body>
    <!-- -->
    <div class="container">
		<div class="header">
			<marquee><h4> Vé máy bay giá rẻ trực tuyến hàng đầu Việt Nam</h4></marquee>
		</div>
		
		<div id="logo">
          <img src="img/travelo.png" />
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
