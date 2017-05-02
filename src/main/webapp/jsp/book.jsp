
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<div class="content">
		
		<div class="content1" >
					<a title="Tổng Đài Vé Hàng không Giá rẻ, Đại lý vé máy bay uy tín chính hãng" href="/">
					<img src="img/logo.png" width="189" height="49" alt="Tổng Đài Vé Hàng không Giá rẻ, Đại lý vé máy bay uy tín chính hãng" /></a>
				<h2>Vé Hàng Không Giá rẻ Chính hãng Uy tín</h2>
		</div>                   
			
                    <div id="content2" style="float: left;margin-left: 3em">
                            
                        <form  style="height: auto; width: 1000px;border: 1px solid black;float: left;margin-left: 3em;" method="get" action="${pageContext.request.contextPath}/showFlight">
                                <h3>Thông tin chiều đi</h3>
                                <h4>${message}</h4>
                                <h4>${result}</h4>
                                <table style="visibility: ${table1}">
                                    <thead>
                                        <tr>
                                            <th>Ngày khởi hành</th>
                                            <th>Giờ bay</th>
                                            <th>Từ</th>
                                            <th>Đến</th>
                                            <th>Mã chuyến bay</th>
                                            <th>Giá vé hạng Eco</th>
                                            <th>Giá vé hạng Skyboss</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="book" items="${bookList}">
                                            <tr>
                                            <td id="dateGoes">${book.dateGoes}</td>
                                            <td>${book.timeGoes}</td>
                                            <td>${fromName}</td>                        
                                            <td>${toName}</td>
                                            <td>${book.flightID}</td>
                                            <td>${book.price}</td>
                                            <td>${book.price+book.price}</td>
                                            <td><input type="radio" name="flight" value="${book.flightID}"> Chọn chuyến bay<br></td>
                                            <!--<td><a href="showFlight/${book.flightID}">Chọn chuyến bay</a></td>-->
                                            </tr>
                                        </c:forEach>
                                    </tbody>                        

                                </table>
                                <hr>
                                <h3 style="visibility: ${hidden}">Thông tin chiều về</h3>
                                <h4 style="visibility: ${hidden}">${message1}</h4>
                                <h4 style="visibility: ${hidden}">${result1}</h4>
                            <table style="visibility: ${hidden}">
                                    <thead>
                                        <tr>
                                            <th>Ngày khởi hành</th>
                                            <th>Giờ bay</th>
                                            <th>Từ</th>
                                            <th>Đến</th>
                                            <th>Mã chuyến bay</th>
                                            <th>Giá vé hạng Eco</th>
                                            <th>Giá vé hạng Skyboss</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="book" items="${bookList1}">
                                            <tr>
                                            <td>${book.dateGoes}</td>
                                            <td>${book.timeGoes}</td>
                                            <td>${fromName}</td>                        
                                            <td>${toName}</td>
                                            <td>${book.flightID}</td>
                                            <td>${book.price}</td>
                                            <td>${book.price+book.price}</td>
                                            <td><input type="radio" name="flight1" value="${book.flightID}">Chọn chuyến bay<br></td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                                    <input type="submit" value="Tiếp tục"/>
                            </form>
                        </div>
		
		</div>
        
               

