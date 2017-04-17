<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="content">
		
			<div class="content1" >
					<a title="Tổng Đài Vé Hàng không Giá rẻ, Đại lý vé máy bay uy tín chính hãng" href="/">
					<img src="../img/logo.png" width="189" height="49" alt="Tổng Đài Vé Hàng không Giá rẻ, Đại lý vé máy bay uy tín chính hãng" /></a>
				<h2>Vé Hàng Không Giá rẻ Chính hãng Uy tín</h2>
			</div>                   
			
			<div id="content2">         
				  <form id="myform" name="myform" action="" method="post">
                                      <c:forEach var="routeList" items="${routeList}">
					  <h3>Tìm kiếm chuyến bay
					  <input id="chk" type="radio" name="group1" value="khuhoi" checked="checked" />Khứ hồi
					  <input id="chk" type="radio" name="group1" value="motchieu" />Một chiều
					  </h3>
					  
					  <label>Từ</label>
					  <select name="crust">
						  <option value="thin">Từ</option>
						  <option value="${routeList.froms}">${routeList.froms}</option>

					  </select>
					  <label>Khởi hành</label>
					  <input type="date" name="ngaydi" value="ngaydi" /><br>
					  <label>Đến</label>
					  <select name="crust">
						  <option value="thin">Đến</option>
						  <option value="${routeList.tos}">${routeList.tos}</option>
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
                                          </c:forEach>
				  </form>
				</div>
		
		</div>
