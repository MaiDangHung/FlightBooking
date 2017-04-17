<%-- 
    Document   : trangchu
    Created on : 12-Apr-2017, 16:57:12
    Author     : MyPC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>home</title>
   
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <link rel="stylesheet" type="text/css" href="../css/jquery-ui.min.css">

  </head>
  <body>
    <body>
    <!-- -->
    <div class="container">
		<div class="header">
			<marquee><h4> Vé máy bay giá rẻ trực tuyến hàng đầu Việt Nam</h4></marquee>
		</div>
		
		<div id="logo">
          <img src="../img/travelo.png" />
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
		
		<div class="content">
		
			<div class="content1" >
					<a title="Tổng Đài Vé Hàng không Giá rẻ, Đại lý vé máy bay uy tín chính hãng" href="/">
					<img src="../img/logo.png" width="189" height="49" alt="Tổng Đài Vé Hàng không Giá rẻ, Đại lý vé máy bay uy tín chính hãng" /></a>
				<h2>Vé Hàng Không Giá rẻ Chính hãng Uy tín</h2>
			</div>                   
			
			<div id="content2">         
				  <form id="myform" name="myform" action="" method="post">
					  <h3>Tìm kiếm chuyến bay
					  <input id="chk" type="radio" name="group1" value="khuhoi" checked="checked" />Khứ hồi
					  <input id="chk" type="radio" name="group1" value="motchieu" />Một chiều
					  </h3>
					  
					  <label>Từ</label>
					  <select name="crust">
						  <option value="thin">Từ</option>
						  <option value="#">Đà Nẵng</option>
						  <option value="#">Hà Nội</option>
					  </select>
					  <label>Khởi hành</label>
					  <input type="date" name="ngaydi" value="ngaydi" /><br>
					  <label>Đến</label>
					  <select name="crust">
						  <option value="thin">Đến</option>
						  <option value="#">Quảng Nam</option>
						  <option value="#">TP.Hồ Chí Minh</option>
					  </select>				  
					  <label>Quay về</label>
					  <input type="date" name="ngayve" value="ngayve" /><br>
					  <label>Người lớn</label>
					  <select name="crust">
						  <option value="#">1</option>
						  <option value="#">2</option>
						  <option value="#">3</option>
					  </select>	
					  <label>Trẻ em</label>
					  <select name="crust">
						  <option value="#">0</option>
						  <option value="#">1</option>
						  <option value="#">2</option>
					  </select>	
					  <label>Em bé</label>
					  <select name="crust">
						  <option value="#">0</option>
						  <option value="#">1</option>
						  <option value="#">2</option>
					  </select>	
					  <input type="submit" name="register" id="button" value="TÌM KIẾM">        
				  </form>
				</div>
		
		</div>
		
		<div class="lienhe">
			<img src="../img/footer.png" />
		</div>
		
		<div class="chungnhan">
			<img src="../img/chungnhan1.png" /><br><br>
			<img src="../img/chungnhan2.png" />
		</div>
		
		<div class="footer">
			<br><p style="text-align: center;"> Đại lý vé 
				máy bay <span lang="en-us">uy tín - Vé Hàng 
				Không Giá rẻ</span>
					<br /> Đ<span lang="en-us">T</span>: 0<span lang="en-us">8.6657.6622 
				- 08.66576644</span> - 
				09<span lang="en-us">44.888.247</span><br /><span style="color:#ffffff;">
				<strong>&copy; Copyright </strong></span>
				<strong>
				<a href="#" title="Tra giá vé máy bay giá rẻ">
				<span lang="en-us" style="color: #ffffff">
				VeHangkhong.com</span></a><span lang="en-us"></strong>.
				<span style="font-weight: bold">Nội dung các tin bài được viết bởi </span><a href="
				#" style="margin: 0px; padding: 0px; border: 0px; outline: 0px; vertical-align: baseline; text-decoration: none; color: rgb(106, 117, 157);">
				<span style="color:#ffffff;"><span style="font-weight: 400">Vé</span>
				Hàng Không</span></span></span></a></strong><span style="font-weight: 400">
				</span></b>
				</p>
				<p style="text-align: center;">
				&nbsp;</p>
				<p style="text-align: center;">
				<span lang="en-us">Là đại lý cấp 1 chính hãng 
				với trên 10 năm uy tín, 
				được các hãng hàng không ủy quyền và chứng thực 
				đảm bảo: Vietjetair - 
				Jetstar - Vietnam Airlines</span>
					<br />
					<br /><span lang="en-us">Chi nhánh Tân Sơn 
				Nhất: 21/5 Trường Sơn, P4, Quận Tân Bình</span>, 
				<span lang="en-us">TP.</span>Hồ Ch&iacute; Min<span lang="en-us">h</span><br />
				<span lang="en-us">Chi nhánh Hà Nội: Kiosk 25, 
				Tổ dân phố Bạch Đằng, đường Vạn Phúc, Hà Đông</span></p>
		</div>
   </div>
    

    <script src="../js/jquery-3.1.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../js/bootstrap.min.js"></script>

    <script src="../js/jquery-ui.min.js"></script>
    <script type="text/javascript">
		var form = document.forms['myform'];
			form.group1[0].onfocus = function () {
				form.ngaydi.disabled = form.ngayve.disabled = false;
			}
			form.group1[1].onfocus = function () {
				form.ngaydi.disabled = false;
				form.ngayve.disabled = true;
			}
	</script>
    <script src="../js/jquery.cycle2.js"></script>
  </body>
</html>
