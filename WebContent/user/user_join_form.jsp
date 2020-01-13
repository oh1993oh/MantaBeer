<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Worldbeershop_login</title>
<link rel="stylesheet" href="css/treade.css">
<style type="text/css">
#loginForm {
	text-align: center;
}

table {
	text-align: center;
}

h1 {
	text-align: center;
}

#joinForm {
	position: relative;
	top: -10px;
	left: 85px;
}

.body {
	background-image: url(./images/beer/login.png);
	background-repeat: no-repeat;
	background-size: cover;
}
</style>
<script src="js/jquery-3.4.1.js"></script>
<script type="text/javascript">
	var idcheckResult = false, passcheckResult = false;
	var passcheckResult2 = false, namecheckResult = false;
	var emailcheckResult = false, numbercheckResult = false;

	function idcheck(id) {
		var idC = id.value;
		$.ajax({
			type : 'post', // 타입
			url : 'UserIdCheck.me', // URL
			dataType : 'text', // 데이터 타입
			data : { // 보낼 데이터
				"id" : idC
			},
			success : function(result) { // 결과 성공
				$('span#idCheck').html(result);
				idcheckResult = true;
			},
			error : function(request, status, error) { // 결과 에러
			}
		})
	}
	function changeDomain(domain) {
		// SELECT-OPTION 태그에서 선택된 항목을 email2 필드에 표시
		document.joinForm.email2.value = domain.value;
	}

	function CheckSubmit() {
		if (document.joinForm.email1.value == ""
				&& document.joinForm.email2.value == "") {
			document.joinForm.email1.focus();
			return;
		} else {
			emailcheckResult = true;
		}
		if (idcheckResult && passcheckResult && passcheckResult2
				&& namecheckResult && emailcheckResult && numbercheckResult) {
			alert("감사합니다. 정상적으로 회원 가입이 완료 되었습니다.");
			return true;
		} else {
			alert("죄송하지만, 필수 조건 불충족으로 가입이 불가합니다.");
			return false;
		}
	}

	function passcheck(user_pass) {
		// 8-20자리 영문자,숫자,특수문자 조합 유효성 검사
		var pass_length = user_pass.value.length;
		var lowerCaseRegex = /[a-z]/; // 소문자
		var digitCaseRegex = /[0-9]/; // 숫자

		// 패스워드 항목 우측의 DIV 태그에 대한 id 값을 지정하여 해당 태그 Element 가져오기
		var element = document.getElementById('passResult');

		// 검사 항목에 대한 모든 결과가 true 이면 사용 가능, 아니면 불가능
		if (pass_length > 8 && pass_length < 17
				&& lowerCaseRegex.exec(user_pass.value)
				&& digitCaseRegex.exec(user_pass.value)) {
			element.innerHTML = "사용가능";
			passcheckResult = true;
		} else {
			element.innerHTML = "사용불가";
		}
	}

	function passcheck2(passcheck) {
		var passward = document.joinForm.user_pass.value;
		var span_passCheck = $('span#pCheck');
		if (passcheck.value == passward) {
			span_passCheck.html("비밀번호 일치");
			passcheckResult2 = true;
		} else {
			span_passCheck.html("비밀번호 불 일치");
		}
	}

	function namecheck() {
		if (document.joinForm.user_name.value == "") {
			// alert("죄송하지만, 고객님의 성명 입력 부탁드립니다.");
			document.joinForm.user_name.focus();
			return;

		} else {
			namecheckResult = true;
		}

	}

	function numbercheck() {
		if (document.joinForm.user_number.value == "") {
			// alert("죄송하지만, 고객님의 성명 입력 부탁드립니다.");
			document.joinForm.user_number.focus();
			return;
		} else {
			numbercheckResult = true;
		}
	}
</script>



<!-- 우편번호 API부분 시작-->
<script
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	function sample6_execDaumPostcode() {
		new daum.Postcode(
				{
					oncomplete : function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

						// 각 주소의 노출 규칙에 따라 주소를 조합한다.
						// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						var addr = ''; // 주소 변수
						var extraAddr = ''; // 참고항목 변수

						//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
						if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
							addr = data.roadAddress;
						} else { // 사용자가 지번 주소를 선택했을 경우(J)
							addr = data.jibunAddress;
						}

						// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
						if (data.userSelectedType === 'R') {
							// 법정동명이 있을 경우 추가한다. (법정리는 제외)
							// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
							if (data.bname !== ''
									&& /[동|로|가]$/g.test(data.bname)) {
								extraAddr += data.bname;
							}
							// 건물명이 있고, 공동주택일 경우 추가한다.
							if (data.buildingName !== ''
									&& data.apartment === 'Y') {
								extraAddr += (extraAddr !== '' ? ', '
										+ data.buildingName : data.buildingName);
							}
							// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
							if (extraAddr !== '') {
								extraAddr = ' (' + extraAddr + ')';
							}
							// 조합된 참고항목을 해당 필드에 넣는다.
							document.getElementById("sample6_extraAddress").value = extraAddr;

						} else {
							document.getElementById("sample6_extraAddress").value = '';
						}

						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						document.getElementById('sample6_postcode').value = data.zonecode;
						document.getElementById("sample6_address").value = addr;
						// 커서를 상세주소 필드로 이동한다.
						document.getElementById("sample6_detailAddress")
								.focus();
					}
				}).open();
	}
	
	
	function agecheck(){
		alert('미성년자는 회원가입을 하실 수 없습니다.');
		history.back(-1);
	}
</script>
</head>
<body class="body">

	<div class="container">
		<div class="login_mu"
			style="width: 625px; height: 376px; border: 1px solid white; background: url(./images/beer/커버용 이미지.jpg); color: white; position: relative; left: 623px; bottom: -300px;">
			<form action="userJoinPro.me" method="post" name="joinForm"
				onsubmit="return CheckSubmit()">
				<div class="join" style="position: relative; top: 1px;">
					<div style="position: relative; left: 15px;">
						<div class="top_main_login"
							style="position: relative; right: 10px; top: -10px;">
							<p>회원가입</p>
							<!-- 우편번호 API부분 끝-->
						</div>
						<div class="join_text"
							style="width: 115px; float: left; margin: 2px;">아이디</div>
						<input type="text" name="user_id" class="id" required="required"
							size="20" onchange="idcheck(this)" style="margin: 2px;">
						<span id="idCheck"></span><br>
						<div class="join_text"
							style="width: 115px; float: left; margin: 2px;">비밀번호</div>
						<input type="password" name="user_pass" required="required"
							size="20" placeholder="8-16자리 영문자,숫자 조합"
							onkeyup="passcheck(this)" style="margin: 2px;"><span
							id="passResult"></span><br>
						<div class="join_text"
							style="width: 115px; float: left; margin: 2px;">비밀번호 확인</div>
						<input type="password" name="user_pass2"
							onchange="passcheck2(this)" style="margin: 2px;"><span
							id="pCheck"></span><br>
						<div class="join_text"
							style="width: 115px; float: left; margin: 2px;">성명</div>
						<input type="text" name="user_name" onkeyup="namecheck()"
							style="margin: 2px;">성인<input type="checkbox" required="required" >미성년자<input type="checkbox" required="required" onclick="agecheck()"><br>
						<div class="join_text"
							style="width: 115px; float: left; margin: 2px;">이메일 주소</div>
						<input type="text" name="email1" required="required" size="10"
							style="margin: 2px;">@ <input type="text" name="email2"
							required="required" size="10" onchange="emailcheck()"
							style="margin: 2px;"> <select name="selectDomain"
							onchange="changeDomain(this)" style="margin: 2px;">
							<option value="">직접입력</option>
							<option value="naver.com">naver.com</option>
							<option value="nate.com">nate.com</option>
						</select><br>
						<!-- 					<input type="email" name="user_email" onkeyup="emailcheck()"><br> -->
						<div class="join_text"
							style="width: 115px; float: left; margin: 2px;">전화번호</div>
						<input type="text" name="user_number" onkeyup="numbercheck()"
							style="margin: 2px;"><br>
						<div class="join_text"
							style="width: 115px; float: left; margin: 2px;">주소</div>
						<input type="text" name="post_num" id="sample6_postcode"
							placeholder="우편번호" style="margin: 2px;"> <input
							type="text" name="adress" id="sample6_address" placeholder="주소"
							style="margin: 2px;"> <input type="button"
							onclick="sample6_execDaumPostcode()" value="우편번호 찾기"
							style="margin: 2px; border: 0; border-radius: 10px; height: 25px;"><br>
						<input type="text" name="adress_details"
							id="sample6_detailAddress" placeholder="상세주소"
							style="position: relative; left: 119px; margin: 2px;"> <input
							type="text" id="sample6_extraAddress" placeholder="참고항목"
							style="position: relative; left: 119px; margin: 2px;">

					</div>
					<br> <input type="submit" value="가입하기"
						style="position: relative; left: 180px; border-radius: 14px; height: 33px; padding: 5px 0; width: 79px; font-size: 15px; border: 0;">
					<input type="reset" value="재입력하기"
						style="position: relative; left: 180px; border-radius: 14px; height: 33px; padding: 5px 0; width: 94px; font-size: 15px; border: 0;">
					<input type="button" class="login_btn" value="홈으로"
						onclick="location.href='BeerMain.me'"
						style="position: relative; left: 180px; border-radius: 14px; height: 33px; padding: 5px 0; width: 94px; font-size: 15px; border: 0;">
				</div>
			</form>
		</div>
	</div>
</body>
</html>