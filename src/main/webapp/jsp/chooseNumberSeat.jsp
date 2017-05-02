<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header_1.jsp" %>


<div class="content">
		
			<div class="content1" >
					<a title="Tổng Đài Vé Hàng không Giá rẻ, Đại lý vé máy bay uy tín chính hãng" href="/">
					<img src="${pageContext.request.contextPath}/img/logo.png" width="189" height="49" alt="Tổng Đài Vé Hàng không Giá rẻ, Đại lý vé máy bay uy tín chính hãng" /></a>
				<h2>Vé Hàng Không Giá rẻ Chính hãng Uy tín</h2>
			</div>                   
			
    <div id="content2" style="float: left;width: 100%;height: auto;">
        
        <div style="float:left;width: 70%;height:auto;display: block;">
            <h1>Chọn số ghế chiều đi</h1>
        <form method="post" style="height: auto; width: 99%;border: 1px solid black;float: left" name="form1" id="form1" onload="loadSeat()">
            
            <input type="radio" name="classTicket" value="1" onclick="eco()" checked/>Eco
            <input type="radio" name="classTicket" value="2" onclick="skyboss()"/>Skyboss
            <br>
            <br>
            <div id="eco">
                
                <br style="clear: both">
                <div style="margin-left: 2em ;">
                    <c:forEach var="i" begin="1" end="10">
                        <%--<c:forEach var="seat" items="${seatNumber}">--%>
                            <%--<c:if test="${seat.seatNumber==${i}A}">--%>
                                <input type="hidden" name="seat" value="${i}A"/>
                                <button style="margin-bottom: .3em;margin-left: .3em;float: left;width: 5em;height:3em;color: red;" name="seatNumber" type="button"  class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal" onclick="ghi('${i}A',form1.classTicket.value)"><c:out value="${i}"/> A</button>
                            <%--</c:if>--%>


                        <%--</c:forEach>--%>
                                <!--<button style="margin-bottom: .3em;margin-left: .3em;float: left;width: 5em;height:3em;" type="button"  class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal" onclick="ghi('${i}A',form1.classTicket.value)"><c:out value="${i}"/> A</button>-->
                    
                    </c:forEach>
                </div>
                <br style="clear: both">
                <div style="margin-left: 2em;">
                    <c:forEach var="i" begin="1" end="10">
                            <input type="hidden" name="seat" value="${i}B"/>
                            <button style="margin-bottom: .3em;margin-left: .3em;float: left;width: 5em;height:3em;color: red;" name="seatNumber" type="button"  class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal" onclick="ghi('${i}B',form1.classTicket.value)"><c:out value="${i}"/> B</button>
                        
                     </c:forEach>
                </div>
                <br style="clear: both">
                <div style="margin-left: 2em;">
                    <c:forEach var="i" begin="1" end="10">
                            <input type="hidden" name="seat" value="${i}C"/>
                            <button style="margin-bottom: .3em;margin-left: .3em;float: left;width: 5em;height:3em;color: red;" name="seatNumber" type="button"  class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal" onclick="ghi('${i}C',form1.classTicket.value)"><c:out value="${i}"/> C</button>
                        
                     </c:forEach>
                </div>
            </div>
            <div id="skyboss">
                <div style="margin-left: 2em;">
                    <c:forEach var="i" begin="1" end="10">
                            <input type="hidden" name="seat" value="${i}SA"/>
                            <button style="margin-bottom: .3em;margin-left: .3em;float: left;width: 5em;height:3em;color: red;" type="button"  class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal" onclick="ghi('${i}SA',form1.classTicket.value)"><c:out value="${i}"/> SA</button>
                        
                     </c:forEach>
                </div>
                <br style="clear: both"/>
                <div style="margin-left: 2em;">
                    <c:forEach var="i" begin="${numberSeatOfSky/10+1}" end="${numberSeatOfSky/10+20}">
                            <input type="hidden" name="seat" value="${i}SB"/>
                            <button style="margin-bottom: .3em;margin-left: .3em;float: left;width: 5em;height:3em;color: red;" type="button"  class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal" onclick="ghi('${i}SB',form1.classTicket.value)"><c:out value="${i}"/> SB</button>
                        
                     </c:forEach>
                </div>
            </div> 
        </form>
        <div id="myModal" class="modal fade" role="dialog">
                <div class="modal-dialog">

                  <!-- Modal content-->
                  <div class="modal-content">
                    <div class="modal-header">
                      <button type="button" class="close" data-dismiss="modal">&times;</button>
                      <h4 class="modal-title">Modal Header</h4>
                    </div>
                    <div class="modal-body">
                        <mvc:form name="form2" method="get" action="addToCart">
                            <input type="hidden" name="flightID1" value="${flightID1}"/>
                            <input type="hidden" name="flightID2" value="${flightID2}"/>
                            <label>Mã chuyến bay: </label>
                            <label>${flight.flightID}</label><br>
                            <label>Từ: </label>
                            <label>${route.froms}<br>
                            <label>Đến: </label>
                            <label>${route.tos}</label><br>
                            <label>Ngày khởi hành: </label>
                            <label>${flight.dateGoes}</label><br>
                            <label>Số ghế: </label>
                            <label id="seat1"></label><br>
                            <label>Hành lý ký gửi:</label>
                            <select name="luggage">
                                <c:forEach var="luggage1" items="${luggage}">
                                    <option value="${luggage1.lugName}" >${luggage1.lugName}</option>
                                </c:forEach>
                            </select><br>
                            <input type="hidden" name="seat2"/>
                            <input type="hidden" name="flightID" value="${flight.flightID}"/>
                            <input type="hidden" name="classTicket"/>
                            <input type="radio" name="typeTicket" value="1" checked/>Người lớn
                            <input type="radio" name="typeTicket" value="2"/>Trẻ em <br>
                            <label>Nhập tên hành khách: </label>
                            <input type="text" name="cusName" required/><br>
                            <label>Nhập số CMND: </label>
                            <input type="text" name="cmnd" required/><br>
                            <input type="submit" class="btn btn-default" value="Hoàn tất"/>
                        </mvc:form>
                    </div>
                    <div class="modal-footer">
                      
                    </div>
                  </div>

                </div>
              </div>
        </div>
<!------------------------------------------------------------------------------------------------------->
        <div style="float:left;width: 70%;height:auto;visibility: ${hidden}">
            <h1>Chọn số ghế chiều về</h1>
        <form method="post" action="datve" name="form3" id="form3">
            
            <input type="radio" name="classTicket" value="1" onclick="eco()" checked/>Eco
            <input type="radio" name="classTicket" value="2" onclick="skyboss()"/>Skyboss
            <br>
            <br>
            <div id="eco">
                
                <br style="clear: both">
                <div style="margin-left: 2em ;">
                    <c:forEach var="i" begin="1" end="10">
                        <%--<c:forEach var="cart1" items="${cartComponent.cart}">--%>
                            <%--<c:if test="${fn:contains(${cart1.seat}, "${i}A")}">--%>
                                <input type="hidden" name="seat" value="${i}A"/>
                                <button style="margin-bottom: .3em;margin-left: .3em;float: left;width: 5em;height:3em;color: red;" type="button"  class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal1" onclick="ghi1('${i}A',form3.classTicket.value)"><c:out value="${i}"/> A</button>
                            <%--</c:if>--%>


                        <%--</c:forEach>--%>
                                <button style="margin-bottom: .3em;margin-left: .3em;float: left;width: 5em;height:3em;" type="button"  class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal1" onclick="ghi1('${i}A',form3.classTicket.value)"><c:out value="${i}"/> A</button>
                    
                    </c:forEach>
                </div>
                <br style="clear: both">
                <div style="margin-left: 2em;">
                    <c:forEach var="i" begin="1" end="10">
                            <input type="hidden" name="seat" value="${i}B"/>
                            <button style="margin-bottom: .3em;margin-left: .3em;float: left;width: 5em;height:3em;color: red;" type="button"  class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal1" onclick="ghi1('${i}B',form3.classTicket.value)"><c:out value="${i}"/> B</button>
                        
                     </c:forEach>
                </div>
                <br style="clear: both">
                <div style="margin-left: 2em;">
                    <c:forEach var="i" begin="1" end="10">
                            <input type="hidden" name="seat" value="${i}C"/>
                            <button style="margin-bottom: .3em;margin-left: .3em;float: left;width: 5em;height:3em;color: red;" type="button"  class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal1" onclick="ghi1('${i}C',form3.classTicket.value)"><c:out value="${i}"/> C</button>
                        
                     </c:forEach>
                </div>
            </div>
            <div id="skyboss">
                <div style="margin-left: 2em;">
                    <c:forEach var="i" begin="1" end="10">
                            <input type="hidden" name="seat" value="${i}SA"/>
                            <button style="margin-bottom: .3em;margin-left: .3em;float: left;width: 5em;height:3em;color: red;" type="button"  class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal1" onclick="ghi1('${i}SA',form3.classTicket.value)"><c:out value="${i}"/> SA</button>
                        
                     </c:forEach>
                </div>
                <br style="clear: both"/>
                <div style="margin-left: 2em;">
                    <c:forEach var="i" begin="${numberSeatOfSky/10+1}" end="${numberSeatOfSky/10+20}">
                            <input type="hidden" name="seat" value="${i}SB"/>
                            <button style="margin-bottom: .3em;margin-left: .3em;float: left;width: 5em;height:3em;color: red;" type="button"  class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal1" onclick="ghi1('${i}SB',form3.classTicket.value)"><c:out value="${i}"/> SB</button>
                        
                     </c:forEach>
                </div>
            </div> 
        </form>
        <div id="myModal1" class="modal fade" role="dialog">
                <div class="modal-dialog">

                   Modal content
                  <div class="modal-content">
                    <div class="modal-header">
                      <button type="button" class="close" data-dismiss="modal">&times;</button>
                      <h4 class="modal-title">Modal Header</h4>
                    </div>
                    <div class="modal-body">
                        <mvc:form name="form4" method="get" action="addToCart">
                            <input type="hidden" name="flightID1" value="${flightID1}"/>
                            <input type="hidden" name="flightID2" value="${flightID2}"/>
                            <label>Mã chuyến bay: </label>
                            <label>${flight1.flightID}</label><br>
                            <label>Từ: </label>
                            <label>${route1.froms}<br>
                            <label>Đến: </label>
                            <label>${route1.tos}</label><br>
                            <label>Ngày khởi hành: </label>
                            <label>${flight1.dateGoes}</label><br>
                            <label>Số ghế: </label>
                            <label id="seat1"></label><br>
                            <label>Hành lý ký gửi:</label>
                            <select name="luggage">
                                <c:forEach var="luggage1" items="${luggage}">
                                    <option value="${luggage1.lugName}">${luggage1.lugName}</option>
                                </c:forEach>
                            </select><br>
                            <input type="hidden" name="seat2"/>
                            <input type="hidden" name="flightID" value="${flight1.flightID}"/>
                            <input type="hidden" name="classTicket"/>
                            <input type="radio" name="typeTicket" value="1" checked/>Người lớn
                            <input type="radio" name="typeTicket" value="2"/>Trẻ em <br>
                            <label>Nhập tên hành khách: </label>
                            <input type="text" name="cusName" required/><br>
                            <label>Nhập số CMND: </label>
                            <input type="text" name="cmnd" required/><br>
                            <input type="submit" class="btn btn-default" value="Hoàn tất"/>
                        </mvc:form>
                    </div>
                    <div class="modal-footer">
                      
                    </div>
                  </div>

                </div>
              </div>
        </div>                    
     <!----------------------------------------------------------------------->                       
                            
        <div style="float: right;width: 25%;height:auto;border: 1px solid black;background-color: yellow;">
            <div style="margin-left: .5em;">
                <c:if test="${cartComponent==null}">
                <p>Chưa có vé trong giỏ</p>
                </c:if>
                <c:if test="${cartComponent!=null}">
                    <h3>Thông tin giỏ vé</h3>
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
                                <hr>
                            </c:forEach>
                                
                </c:if>
                            
            </div>
            <div>
                
                <a href="checkOut"><button style="margin-bottom: .3em;text-align: center;width: 95%;height:3em;" data-toggle="modal" data-target="#checkOut">Thanh Toán</button></a>
            </div>
        </div>
<!--        <div id="checkOut" class="modal fade" role="dialog">
                <div class="modal-dialog">

                   Modal content
                  <div class="modal-content">
                    <div class="modal-header">
                      <button type="button" class="close" data-dismiss="modal">&times;</button>
                      <h4 class="modal-title">Modal Header</h4>
                    </div>
                    <div class="modal-body">
                        <mvc:form method="get" action="checkOut">
                            <label>Mã chuyến bay: </label>
                            <label>${flight.flightID}</label><br>
                            <label>Từ: </label>
                            <label>${route.froms}<br>
                            <label>Đến: </label>
                            <label>${route.tos}</label><br>
                            <label>Ngày khởi hành: </label>
                            <label>${flight.dateGoes}</label><br>
                            <label>Số ghế: </label>
                            <label id="seat1"></label><br>
                            <input type="hidden" name="seat2"/>
                            <input type="hidden" name="flightID" value="${flight.flightID}"/>
                            <input type="hidden" name="classTicket"/>
                            <input type="radio" name="typeTicket" value="1" checked/>Người lớn
                            <input type="radio" name="typeTicket" value="2"/>Trẻ em <br>
                            <label>Nhập tên hành khách: </label>
                            <input type="text" name="cusName" required/><br>
                            <label>Nhập số CMND: </label>
                            <input type="text" name="cmnd" required/><br>
                            <input type="submit" class="btn btn-default" value="Hoàn tất"/>
                        </mvc:form>
                    </div>
                    <div class="modal-footer">
                      
                    </div>
                  </div>

                </div>
              </div>                 -->
        
    </div>
		
</div>
<%@include file="footer.jsp" %>


        

