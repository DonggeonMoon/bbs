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
	<header style="float:right">
		<c:choose><c:when test="${sessionScope.memberDto != null }"><c:out value="${sessionScope.memberDto.memberId }" /> 님 <a href="editMemberInfo">회원 정보 수정</a> <a href="logout">로그아웃</a></c:when><c:otherwise><a href="login">로그인</a></c:otherwise></c:choose>
	</header>
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
						<td><c:out value="${i.memberId }" /></td>
						<td><c:out value="${i.memberEmail }" /></td>
						<td><c:out value="${i.userLevel }" /></td>
						<td>
							<c:if test="${i.userLevel != 3 }">
								<form style="display:inline" action="changeUserLevel" method="post">
									<input type="hidden" name="memberId" value="${i.memberId }">
									<input type="hidden" name="userLevel" value="2">
									<input type="submit" value="관리자 승격">
								</form>
								<form style="display:inline" action="changeUserLevel" method="post">
									<input type="hidden" name="memberId" value="${i.memberId }">
									<input type="hidden" name="userLevel" value="1">
									<input type="submit" value="회원으로 강등">
								</form>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<button type="button" onclick="location.href='boardList'">게시판 가기</button>
	</div>
</body>
</html>