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
</style>
</head>
<body style="background-image: url(./images/beer/login.png);
			 background-repeat: no-repeat;
    		 background-size: cover;">
<div class="container">
  <div class="login_mu">
	<div class="top_main_login">
	<p>로 그 인</p>
	</div>
	<div id="loginForm">
		<form action="LoginPro.me" method="post">
				<div class="login_menu">
					<label style=" margin: 10px;">아이디</label>
					<input type="text" name="user_id" required="required" size="20" style="position: relative;left: 7px;">
				</div>
				<div class="login_menu">
					<label style=" margin: 10px;">패스워드</label>
					<input type="password" name="user_pass" required="required" size="20">
				</div>
				<div class="login_menu">
					
						<input type="submit" class="login_btn" value="로그인">
						<input type="button" class="login_btn" value="회원가입" onclick="location.href='UserJoinForm.me'">
						<input type="button" class="login_btn" value="홈으로"  onclick="location.href='BeerMain.me'" >
				</div>
		</form>
	</div>
</div>
	
</div>
</body>
</html>