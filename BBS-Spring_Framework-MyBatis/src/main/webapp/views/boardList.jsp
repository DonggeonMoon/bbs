<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<header style="float:right">
		<c:choose><c:when test="${sessionScope.member != null }"><c:out value="${sessionScope.member.member_id }" /> 님 <c:if test="${sessionScope.member.user_level == 3 }">(<a href="managerPage">관리자 페이지</a>)</c:if> <a href="editMemberInfo">회원 정보 수정</a> <a href="logout">로그아웃</a></c:when><c:otherwise><a href="login">로그인</a></c:otherwise></c:choose>
	</header>
	<h1>게시판</h1>
	<div style="width:100%;">
		<table border="1px" style="width:100%;text-align:center; margin:0 auto;">
			<colgroup>
				<col style="width:5%;"/>
				<col style="width:60%"/>
				<col style="width:10%"/>
				<col style="width:5%"/>
				<col style="width:20%"/>
			</colgroup>
			<thead>
				<tr>
					<td>번호</td>
					<td>제목</td>
					<td>작성자</td>
					<td>조회수</td>
					<td>작성일</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="i" items="${boardList }">
					<tr>
						<c:url var="link" value="/viewBoard">
							<c:param name="board_no" value="${i.board_no }" />
						</c:url>
						<td>${i.board_no }</td>
						<td><a href="${link }">${i.board_title }</a></td>
						<td>${i.member_id }</td>
						<td>${i.board_hit }</td>
						<td>${i.write_date }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<button onclick="location.href='insertBoard'">글 작성</button>
	</div>
</body>
</html>