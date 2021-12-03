<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 변경</title>
</head>
<body>
	<header style="float:right">
		<c:choose><c:when test="${sessionScope.member != null }"><c:out value="${sessionScope.member.member_id }" /> 님 <a href="logout">로그아웃</a></c:when><c:otherwise><a href="login">로그인</a></c:otherwise></c:choose>
	</header>
	<h1>회원 정보 변경</h1>
		<div style="text-align:center;height:100%;line-height:50px">
			<form action="editMemberInfo" method="post">
				<div>
					<label style="display:inline-block;width:20%;">아이디:</label>
					<div style="display:inline-block;width:40%;text-align:left;">
						<input style="width:60%;" type="text" name="member_id" value="<c:out value='${memberInfo.member_id }' />" readonly>
					</div>
				</div>
				<div>
					<label style="display:inline-block;width:20%;">새 비밀번호:</label>
					<div style="display:inline-block;width:40%;text-align:left;">
						<input style="width:60%;" type="password" id="member_pw" name="member_pw">
					</div>
				</div>
				<div>
					<label style="display:inline-block;width:20%;">새 비밀번호 확인: </label> 
					<div style="display:inline-block;width:40%;text-align:left;">
						<input style="width:60%;" type="password" id="member_pw2">
					</div>
				</div>
				<div>
					<label style="display:inline-block;width:20%;">이메일: </label>
					<div style="display:inline-block;width:40%;text-align:left;">
						<input style="width:60%;" type="text" name="member_email" value="<c:out value='${memberInfo.member_email }' />">
					</div>
				</div>
				<input type="hidden" name="user_level" value="<c:out value='${memberInfo.user_level }' />">
				<div><button type="submit">회원 정보 수정</button></div>
			</form>
		<div><button type="button" onclick="location.href='deleteMemberInfo?member_id=<c:out value="${memberInfo.member_id}" />'">화원 탈퇴</button></div>
		<div><button type="button" onclick="history.back(-1)">돌아가기</button>
		</div>
		</div>
</body>
</html>