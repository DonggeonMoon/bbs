<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
</head>
<body>
	<div style="width:100%;">
		<h1>관리자 페이지</h1>
		<table border="1px" style="width:100%;text-align:center; margin:0 auto;">
			<colgroup>
				<col style="width:20%;"/>
				<col style="width:40%"/>
				<col style="width:10%"/>
				<col style="width:40%"/>
			</colgroup>
			<thead>
				<tr>
					<td>아이디</td>
					<td>이메일</td>
					<td>사용자 레벨</td>
					<td>권한 변경</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="i" items="${memberList }">
					<tr>
						<td><c:out value="${i.member_id }" /></td>
						<td><c:out value="${i.member_email }" /></td>
						<td><c:out value="${i.user_level }" /></td>
						<td>
							<form style="display:inline" action="changeUserLevel" method="post">
								<input type="hidden" name="member_id" value="${i.member_id }">
								<input type="hidden" name="user_level" value="2">
								<input type="submit" value="관리자 승격">
							</form>
							<form style="display:inline" action="changeUserLevel" method="post">
								<input type="hidden" name="member_id" value="${i.member_id }">
								<input type="hidden" name="user_level" value="1">
								<input type="submit" value="회원으로 강등">
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div><button type="button" onclick="history.back(-1);">돌아가기</button></div>
</body>
</html>