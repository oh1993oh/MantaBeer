<%@page import="vo.AdressBean"%>
<%@page import="vo.TradeBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<TradeBean> checkOutList = (ArrayList) request.getAttribute("checkOutList");
	ArrayList<AdressBean> adressList = (ArrayList) request.getAttribute("adressList");
	int subtotal = 0;
	int delivery = 0;
	int discount = 0;

	String trade_num_list="";
		
	
	for (TradeBean product : checkOutList) {		
		
		trade_num_list= trade_num_list+","+Integer.toString(product.getTrade_num());
		
		subtotal = subtotal + (product.getProduct_price()*product.getTrade_quantity());
		
		discount = discount + ((int) (product.getProduct_price() * (double) (product.getTrade_sale() / 100.0))*product.getTrade_quantity());

	}
	trade_num_list = trade_num_list.substring(1);//결제 처리될 트레이드 번호들

	delivery = 5000;
	int total = subtotal - discount + delivery;
	
%>


<!DOCTYPE html>
<html lang="en">
<head>
<title>Vegefoods - Free Bootstrap 4 Template by Colorlib</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Amatic+SC:400,700&display=swap"
	rel="stylesheet">

<link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
<link rel="stylesheet" href="css/animate.css">

<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">
<link rel="stylesheet" href="css/magnific-popup.css">

<link rel="stylesheet" href="css/aos.css">

<link rel="stylesheet" href="css/ionicons.min.css">

<link rel="stylesheet" href="css/bootstrap-datepicker.css">
<link rel="stylesheet" href="css/jquery.timepicker.css">


<link rel="stylesheet" href="css/flaticon.css">
<link rel="stylesheet" href="css/icomoon.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body class="goto-here">
	<jsp:include page="/configuration/top.jsp" flush="false"/>
	<!-- END nav -->

	<div class="hero-wrap hero-bread"
      style="background-image: url('images/beer_bg/shop_bg.jpg');">
      <div class="container">
         <div
            class="row no-gutters slider-text align-items-center justify-content-center">
            <div class="col-md-9 ftco-animate text-center">
               <p class="breadcrumbs">
                  <span>MANTA BEER</span>
               </p>
               <h1 class="mb-0 bread">결제 하기</h1>
            </div>
         </div>
      </div>
   </div>

	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-xl-7 ftco-animate">
					<form action="#" class="billing-form">

						<span class = "adress_radio">
						<%
							for (AdressBean adress : adressList) {
								int tnum = adress.getAdress_table_num();
						%>
								
								<input type="radio" name="adressrdo" value ="<%=tnum-1%>"
								class="mr-2 adress_Radio adress<%=adress.getAdress_table_num()%>"> 
								<input type = "text" class="radio_name" value = "<%=adress.getAdress_table_name()%>" readonly
								 style="width:120px;"maxlength="7"/>
						<%
							}
						%>
						</span>	
						<span class = "adress_list">
						<%
							for (AdressBean adress : adressList) {
								int tnum = adress.getAdress_table_num();
						%>
							<span class = "adress_info">
								<input class = "adress_table_nameH" type = "hidden" value ="<%=adress.getAdress_table_name()%>">
								<input class = "phone_numH" type = "hidden" value ="<%=adress.getAdress_phone_num()%>">
								<input class = "post_numH" type = "hidden" value ="<%=adress.getAdress_post_num()%>">
								<input class = "addressH" type = "hidden" value ="<%=adress.getAdress_adress()%>">
								<input class = "address_detailsH" type = "hidden" value ="<%=adress.getAdress_details()%>">
							</span>

						<%
							}
						%>
						</span>


						<h3 class="mb-4 billing-heading">주소록</h3>
						<div class="row align-items-end">
							<div class="col-md-6">
								<div class="form-group">
									<label for="phone_num">전화번호</label> <input type="text" style = "color:black !important;"
										class="form-control phone_numT" placeholder="전화번호를 입력해주세요" 
										value = <%=adressList.get(0).getAdress_phone_num() %>
										readonly>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="post_num">우편번호</label> <input type="text" style = "color:black !important;"
										class="form-control post_numT" placeholder="우편번호는 -을 제외한 5~6숫자" 
										value = <%=adressList.get(0).getAdress_post_num() %>
										readonly>
								</div>
							</div>
							<div class="w-100"></div>

							<div class="col-md-6">
								<div class="form-group">
									<label for="address">주소</label> <input type="text" style = "color:black !important;"
										class="form-control addressT"
										placeholder="주소를 입력해주세요" 
										value = <%=adressList.get(0).getAdress_adress() %>
										readonly>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="address_details">상세주소</label> <input type="text" style = "color:black !important;"
										class="form-control address_detailsT"
										placeholder="상세주소를 입력해주세요"
										value = <%=adressList.get(0).getAdress_details() %>
										readonly>
								</div>
							</div>
							<div class="w-100"></div>
							
							
							<div class="col-md-12 modifiAdrAccept" style = "display : -webkit-box">
							
								<a class="btn btn-primary py-3 px-4 float-md-right" onclick ="modifiAdrAccept()" >수정 완료</a>
								<a class="btn btn-primary py-3 px-4 float-md-right" onclick ="modifiAdrcancel()" >수정 취소</a>
									
							</div>
							
							
							<div class="col-md-12">
								
									<a class="btn btn-primary py-3 px-4 float-md-right" onclick ="addAdr()">추가</a>
									
									<span class = "modifiAdr">
									<a class="btn btn-primary py-3 px-4 float-md-right" onclick ="modifiAdr()">수정</a>
									</span>
									
									
									
									<a class="btn btn-primary py-3 px-4 float-md-right" onclick ="removeAdr()">삭제</a>
								
							</div>
							<div class="w-100"></div>
							
						</div>
					</form>
					<!-- END -->
				</div>
				<div class="col-xl-5">
					<div class="row mt-5 pt-3">
						<div class="col-md-12 d-flex mb-5">
							<div class="cart-detail cart-total p-3 p-md-4">
								<h3 class="billing-heading mb-4">장바구니 명세</h3>
								<p class="d-flex">
									<span>제품 금액</span> <span><%=subtotal%></span>
								</p>
								<p class="d-flex">
									<span>배 달 료</span> <span><%=delivery%></span>
								</p>
								<p class="d-flex">
									<span>할인 금액</span> <span><%=discount%></span>
								</p>
								<hr>
								<p class="d-flex total-price">
									<span>결제 총액</span> <span><%=total%></span>
								</p>
							</div>
						</div>
						<div class="col-md-12">
							<div class="cart-detail p-3 p-md-4">
								<h3 class="billing-heading mb-4">결제 하기</h3>
								
								<div class="form-group">
									<div class="col-md-12">
										<div class="checkbox">
											<label><input type="checkbox" value="" name="accept" class="mr-2">
												결제에 동의 하겠습니다.</label>
										</div>
									</div>
								</div>
								<p>
									<a onclick="PlaceAnOrder()"
										class="btn btn-primary py-3 px-4">확인</a>
								</p>
							</div>
						</div>
					</div>
				</div>
				<!-- .col-md-8 -->
			</div>
		</div>
	</section>
	<!-- .section -->


	
	<jsp:include page="/configuration/footer.jsp" flush="false"/>



	<!-- loader -->
	<div id="ftco-loader" class="show fullscreen">
		<svg class="circular" width="48px" height="48px">
			<circle class="path-bg" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke="#eeeeee" />
			<circle class="path" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke-miterlimit="10" stroke="#F96D00" /></svg>
	</div>


	<script src="js/jquery.min.js"></script>
	<script src="js/jquery-migrate-3.0.1.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.easing.1.3.js"></script>
	<script src="js/jquery.waypoints.min.js"></script>
	<script src="js/jquery.stellar.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/aos.js"></script>
	<script src="js/jquery.animateNumber.min.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script src="js/scrollax.min.js"></script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
	<script src="js/google-map.js"></script>
	<script src="js/main.js"></script>
	<script src="http://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>

	<script>
	
		var modifiadd=false;
		var modifiadr=false;



		
		function PlaceAnOrder(){
			if($('input[name="accept"]').is(":checked")){
				
				
				var IMP = window.IMP;
		        var code = "iamport";  // FIXME: 가맹점 식별코드
		        IMP.init(code);

		        // 결제요청
		        IMP.request_pay({
		            // name과 amount만 있어도 결제 진행가능
		            pg : 'html5_inicis', // pg 사 선택
		            pay_method : 'card',
		            merchant_uid : 'merchant_' + new Date().getTime(),
		            name : '주문명:결제테스트',
		            amount : 100,
		            buyer_tel : $('.phone_numT').val(),
		            buyer_addr : $('.post_numT').val(),
		            buyer_postcode : $('.post_numT').val(),
		        }, function(rsp) {
		            if ( rsp.success ) {
		                var msg = '결제가 완료되었습니다. \n';
		                msg += '고유ID : ' + rsp.imp_uid + '\n';
		                msg += '상점 거래ID : ' + rsp.merchant_uid + '\n';
		                msg += '결제 금액 : ' + rsp.paid_amount + '\n';
		                msg += '카드 승인번호 : ' + rsp.apply_num + '\n';
		                
		                alert(msg);
		                
		                
		                var sel_adr = $(":input:radio[name=adressrdo]:checked").val();
						var user_num = <%=adressList.get(0).getAdress_user_num()%>;
						var adress_table_num = Number(sel_adr)+1
						
						location.href='PlaceAnOrder.shop?user_num='+user_num+'&adress_table_num='+adress_table_num;
		            }
		            else {
		                var msg = '결제에 실패하였습니다. \n에러사유 : ' + rsp.error_msg
		                
		                alert(msg);

		            }
		           
		        });

			}else{
				alert("결제에 동의해 주십시오");
				return false;
			}
		}
		
		function removeAdr(){
			if(modifiadd == true || modifiadr == true){
				alert("주소 수정을 완료하셔야 합니다.");
			}else{
				var possible = $(":input:radio[name=adressrdo]").size();
				if(possible == 1){
					
					alert("주소는 1개이상 존재해야 합니다.");
					
				}else{
					sel_adr = $(":input:radio[name=adressrdo]:checked").val();
					
					var adress_user_num = <%=adressList.get(0).getAdress_user_num()%>
					var adress_table_num = Number(sel_adr)+1
					$(function(){
						$.ajax({
					        url: 'Adress_Remove.shop',
					        data: {
					        	adress_user_num : adress_user_num,
					        	adress_table_num : adress_table_num,
					        },
					        dataType : 'json'
					    });
					});
					

					$('.adress_info:eq('+sel_adr+')').remove();
					$('.adress_Radio:eq('+sel_adr+')').remove();
					$('.radio_name:eq('+sel_adr+')').remove();
					
					$(".adress_Radio").each(function(index, item){
						$(item).val($(item).index()/2);
					
					});
					
					$('.adress1').attr('checked', true);
				}
			}
			//$$경고창 선택지 만들수 있는가?
			
		}
		
		function addAdr(){
			if(modifiadd == true || modifiadr == true){
				alert("주소 수정을 완료하셔야 합니다.");
			}else{
				var addNum = $(":input:radio[name=adressrdo]").size()+1;

				if(addNum >= 5){
					alert("주소는 4개 이상 가질수 없습니다");
				}else{
					$('.adress_list').append('<span class = "adress_info"><input class = "adress_table_nameH" type = "hidden" value =""/>"<input class = "phone_numH" type = "hidden" value=""><input class = "post_numH" type = "hidden" value=""><input class = "addressH" type = "hidden" value=""><input class = "address_detailsH" type = "hidden" value=""></span>');
					var value=addNum-1
					$('.adress_radio').append('<input type="radio" name="adressrdo" value="'+value+'" class="mr-2 adress_Radio adress'+addNum+'"><input type = "text" class="radio_name" value = "'+addNum+'번주소" readonly style="width:120px;"maxlength="7"/>');
					$('.adress_Radio').attr('checked', false);
					$('.adress'+addNum).attr('checked', true);
					
					modifiAdr(value);
				}
			}
			
			

		}
		
		

		
		function modifiAdr(sel_adr){
			if(modifiadd == true || modifiadr == true){
				alert("주소 수정을 완료하셔야 합니다.");
			}else{
				var add = true;
				if(sel_adr == null){
					sel_adr = $(":input:radio[name=adressrdo]:checked").val();
					add=false;
				}
	 			
				$('.phone_numT').val("").removeAttr("readonly");
				$('.post_numT').val("").removeAttr("readonly");
				$('.addressT').val("").removeAttr("readonly");
				$('.address_detailsT').val("").removeAttr("readonly");
				$('.radio_name').eq(sel_adr).removeAttr("readonly");

				//라디오 버튼 클릭 못하게 만들어버리기
				
				$(":input:radio[name=adressrdo]").attr('disabled',true);
				
				//수정상태 true로 만들어서 거래불가로만들기
				
				if(add == true){
					modifiadd=true;
				}else{
					modifiadr=true;
				}

				//수정완료,취소버튼을 만듬
				$('.modifiAdrAccept').css("display", "block");
			}
			
			
			
			
		}
		
		function modifiAdrAccept(){
			//둘다 수정완료일경우 현상태를 db에 저장,adress_info hidden값 갱신
			var url = "";
			if(modifiadd==true){
				//add에서 들어온처리는 insert			
				url = 'Adress_Insert.shop';
			}else if(modifiadr==true){
				//일반에서 들어온처리는 alert
				url = 'Adress_Modify.shop'
			}
			
			var sel_adr = $(":input:radio[name=adressrdo]:checked").val();
			var adress_user_num = <%=adressList.get(0).getAdress_user_num()%>
			var adress_adress = $('.addressT').val(); 
			var adress_details = $('.address_detailsT').val(); 
			var adress_table_num = Number(sel_adr)+1
			var adress_table_name = $('.radio_name').eq(sel_adr).val(); 
			var adress_post_num = $('.post_numT').val(); 
			var adress_phone_num = $('.phone_numT').val(); 
			
// 			"/^(010|011|016|017|018|019)-\d{3,4}-\d{4}$/u"
// 			"/^\d{6}$/u" 하이픈없이 6자리

			//$$ 전화번호, 우편번호는 형식에 맞춰졌는지 확인(정규표현식으로)
// 			alert(adress_phone_num);
// 			var Regular_phone_num = "";
// 			re_phone = new RegExp("/^(010|011|016|017|018|019)-\d{3,4}-\d{4}$/u","i");  
// 			re_phone.test(adress_phone_num)?Regular_phone_num='true':Regular_phone_num='false';
// 			alert(Regular_phone_num);
			
			
// 			var Regular_post_num = "";
// 			re_post = new RegExp("/^\d{6}$/u");  
// 			re_post.test(adress_post_num)?Regular_post_num='true':Regular_post_num='false';
// 			alert(Regular_post_num);
			
			
			if(adress_adress == ""){
				alert("주소를 입력해주세요");
				return false;
			}else if(adress_details == ""){
				alert("상세 주소를 입력해주세요");
				return false;
			}else if(adress_phone_num == ""){
				alert("전화번호를 입력해주세요");
				return false;
			}else if(adress_post_num == ""){
				alert("우편번호를 입력해주세요");
				return false;
			}
// 			else if(Regular_phone_num == "false"){
// 				alert("전화번호를 올바르게 입력해주세요");
// 				return false;
// 			}else if(Regular_post_num == "false"){
// 				alert("우편번호를 올바르게 입력해주세요");
// 				return false;
// 			}

			
		    var phone_regex = /^(010|011|016|017|018|019)-\d{3,4}-\d{4}$/u;
		    var post_regex = /^\d{5,6}$/u;
// 		   	alert(phone_regex.exec(adress_phone_num));
		 	if(phone_regex.exec(adress_phone_num)) {
		 	
		 	}else{
		 		alert("전화번호를 올바르게 입력해주세요");
		 		return false;
		 	}
		 	
		 	if(post_regex.exec(adress_post_num)) {
			 	
		 	}else{
		 		alert("우편번호는 -을 제외하고 숫자 5~6자리를 입력해주세요");
		 		return false;
		 	}
		 	
		 	
			
			$(function(){
				$.ajax({
			        url: url,
			        data: {
			        	adress_user_num : adress_user_num,
			        	adress_adress : adress_adress,
			        	adress_details : adress_details,
			        	adress_table_num : adress_table_num,
			        	adress_table_name : adress_table_name,
			        	adress_post_num : adress_post_num,
			        	adress_phone_num : adress_phone_num 
			        },
			        dataType : 'html',
			        //$$확인
			        success:function(msg){
			        	alert("주소 수정 완료");      
			        }


			    });
				$('.adress_info:eq('+sel_adr+')').find('.adress_table_nameH').val($('.radio_name:eq('+sel_adr+')').val());
				$('.adress_info:eq('+sel_adr+')').find('.phone_numH').val($('.phone_numT').val()); 
				$('.adress_info:eq('+sel_adr+')').find('.post_numH').val($('.post_numT').val()); 
				$('.adress_info:eq('+sel_adr+')').find('.addressH').val($('.addressT').val()); 
				$('.adress_info:eq('+sel_adr+')').find('.address_detailsH').val($('.address_detailsT').val()); 
		    });
			
			
			
			$('.phone_numT').attr("readonly",true);
			$('.post_numT').attr("readonly",true);
			$('.addressT').attr("readonly",true);
			$('.address_detailsT').attr("readonly",true);
			$('.radio_name').attr("readonly",true);

			$('.modifiAdrAccept').css("display", "-webkit-box");
			$(":input:radio[name=adressrdo]").attr('disabled',false);
			modifiadd=false;
			modifiadr=false;
		}
		
		function modifiAdrcancel(){

			sel_adr = $(":input:radio[name=adressrdo]:checked").val();
			
			if(modifiadd==true){
				//add에서 들어온 modifi는 add취소(라디오박스와 adress_info삭제)
				$('.adress_info:eq('+sel_adr+')').remove();
				$('.adress_Radio:eq('+sel_adr+')').remove();
				$('.radio_name:eq('+sel_adr+')').remove();
				
				$('.radio_name:eq('+sel_adr+')').val($('.adress_info:eq(1)').find('.adress_table_nameH').val());
				$('.phone_numT').val($('.adress_info:eq(0)').find('.phone_numH').val()); 
				$('.post_numT').val($('.adress_info:eq(0)').find('.post_numH').val()); 
				$('.addressT').val($('.adress_info:eq(0)').find('.addressH').val()); 
				$('.address_detailsT').val($('.adress_info:eq(0)').find('.address_detailsH').val()); 
				$('.adress1').attr('checked', false);
				$('.adress1').attr('checked', true);	
			}else if(modifiadr==true){
				//일반적으로 클릭한 상황에서 수정한경우는 원상태 복구(hidden)

				
				
				$('.radio_name:eq('+sel_adr+')').val($('.adress_info:eq('+sel_adr+')').find('.adress_table_nameH').val());
				$('.phone_numT').val($('.adress_info:eq('+sel_adr+')').find('.phone_numH').val()); 
				$('.post_numT').val($('.adress_info:eq('+sel_adr+')').find('.post_numH').val()); 
				$('.addressT').val($('.adress_info:eq('+sel_adr+')').find('.addressH').val()); 
				$('.address_detailsT').val($('.adress_info:eq('+sel_adr+')').find('.address_detailsH').val()); 
				
				
			}
			
			$('.phone_numT').attr("readonly",true);
			$('.post_numT').attr("readonly",true);
			$('.addressT').attr("readonly",true);
			$('.address_detailsT').attr("readonly",true);
			$('.radio_name').attr("readonly",true);
			
			$('.modifiAdrAccept').css("display", "-webkit-box");
			$(":input:radio[name=adressrdo]").attr('disabled',false);
			

			modifiadd=false;
			modifiadr=false;
			
		}

		
		
		
	
		$(document).ready(function() {			
			var sel_adr
// 			$('.adress_Radio').each(function(){
// 				debugger;
// 			}).on('change',function(){
// 				debugger;
// 			});
// 			$("input:radio[name=adressrdo]").live('change',function(){
// 				debugger;
				
				
// 			});

			$('.adress1').attr('checked', true);
			
			$(document).on("click","input:radio[name=adressrdo]",(function(e){
				sel_adr = $(":input:radio[name=adressrdo]:checked").val();
				$('.phone_numT').val($('.adress_info:eq('+sel_adr+')').find('.phone_numH').val()); 
				$('.post_numT').val($('.adress_info:eq('+sel_adr+')').find('.post_numH').val()); 
				$('.addressT').val($('.adress_info:eq('+sel_adr+')').find('.addressH').val()); 
				$('.address_detailsT').val($('.adress_info:eq('+sel_adr+')').find('.address_detailsH').val()); 
			}));
			

			var quantitiy = 0;
			$('.quantity-right-plus').click(function(e) {

				// Stop acting like a button
				e.preventDefault();
				// Get the field name
				var quantity = parseInt($('#quantity').val());

				// If is not undefined

				$('#quantity').val(quantity + 1);

				// Increment

			});

			$('.quantity-left-minus').click(function(e) {
				// Stop acting like a button
				e.preventDefault();
				// Get the field name
				var quantity = parseInt($('#quantity').val());

				// If is not undefined

				// Increment
				if (quantity > 0) {
					$('#quantity').val(quantity - 1);
				}
			});

		});
	</script>

</body>
</html>