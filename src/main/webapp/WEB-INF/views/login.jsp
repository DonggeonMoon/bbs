<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home</title>
</head>
<body>
<div style="text-align:center;height:100%;line-height:50px">
	<h1>로그인</h1>
	<form action="login" method="post">
		<div><c:out value="${message }" /></div>
		<div>
			<label style="display:inline-block;width:10%;">아이디:</label>
			<div style="display:inline-block;width:20%;text-align:left;">
				<input type="text" name="member_id">
			</div>
		</div>
		<div>
			<label style="display:inline-block;width:10%;">비밀번호:</label>
			<div style="display:inline-block;width:20%;text-align:left;">
				<input type="password" name="member_pw">
			</div>
		</div>
		<div><input type="submit" value="로그인"></div>
		<div><input type="button" value="회원 가입" onclick="location.href='register'"></div>
	</form>
</div>
</body>
</html>