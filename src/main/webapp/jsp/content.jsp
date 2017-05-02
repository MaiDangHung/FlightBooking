<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="content">
		
			<div class="content1" >
					<a title="Tổng Đài Vé Hàng không Giá rẻ, Đại lý vé máy bay uy tín chính hãng" href="/">
					<img src="img/logo.png" width="189" height="49" alt="Tổng Đài Vé Hàng không Giá rẻ, Đại lý vé máy bay uy tín chính hãng" /></a>
				<h2>Vé Hàng Không Giá rẻ Chính hãng Uy tín</h2>
			</div>                   
			
			<div id="content2">         
				  <form id="myform" name="myform" action="search" method="get">
                                      
					  <h3>Tìm kiếm chuyến bay
                                              <input id="chk" type="radio" name="group1" value="khuhoi" checked="checked" onclick="khuhoi()"/>Khứ hồi
                                              <input id="chk" type="radio" name="group1" value="motchieu" onclick="motchieu()"/>Một chiều
					  </h3>
					  
					  <label>Từ</label>
                                          
                                          <select name="froms" id="from" onchange="myFunction()" onload="myFunction()">
						  <option value="thin">Từ</option>
                                                  <c:forEach var="routeList" items="${routeList}">
                                                    <option value="${routeList.fromsStation.airportID}" >${routeList.fromsStation.airportName}</option>
                                                  </c:forEach>
					  </select>
					  <label>Khởi hành</label>
                                          <input type="date" name="date1" required/><br>
                                          
                                          <label style="float: left">Đến</label>
<!--                                          <div id="prvContatiner" style="float: left;">
					  <select name="tos">
						  <option value="thin">Đến</option>
                                                  <c:forEach var="routeList" items="${routeList}">
                                                    <option value="${routeList.tos}" >${routeList.tos}</option>
                                                  </c:forEach>
					  </select>		
                                          </div>-->
                                                  
                                          <div id="demo" style="float: left;">                         
                                              <select id="destination" name="tos" required>                       
                                                        </select>
                                          </div>  
<label style="float: left;margin-left: 1.7em;" class="ngayve">Quay về</label>
<input style="float: left" type="date" name="date2" class="ngayve" placeholder="Ngày về (mm/dd/yyyy)"/><br style="clear: both;">
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
					  <input type="submit" name="search" id="button" value="TÌM KIẾM">  
                                  
				  </form>
				</div>
		
		</div>
