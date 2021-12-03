<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
	<div style="text-align:center;height:100%;line-height:50px">
		<h1>회원 가입</h1>
		<form action="register" method="post">
			<div>
				<label style="display:inline-block;width:20%;">아이디:</label>
				<div style="display:inline-block;width:40%;text-align:left;">
					<input style="width:60%;" type="text" name="member_id">
					<button style="margin:10px" type="button">아이디 중복 확인</button>
				</div>
			</div>
			<div>
				<label style="display:inline-block;width:20%;">비밀번호:</label>
				<div style="display:inline-block;width:40%;text-align:left;">
					<input style="width:60%;" type="password" id="member_pw" name="member_pw">
				</div>
			</div>
			<div>
				<label style="display:inline-block;width:20%;">비밀번호 확인: </label> 
				<div style="display:inline-block;width:40%;text-align:left;">
					<input style="width:60%;" type="password" id="member_pw2">
				</div>
			</div>
			<div>
				<label style="display:inline-block;width:20%;">이메일: </label>
				<div style="display:inline-block;width:40%;text-align:left;">
					<input style="width:60%;" type="text" name="member_email">
				</div>
			</div>
			<input type="hidden" name="user_level" value="1">
			<div>
				<button type="submit">회원 가입</button>
				<button type="button" onclick="history.back(-1);">돌아가기</button>
			</div>
		</form>
	</div>
</body>
</html>