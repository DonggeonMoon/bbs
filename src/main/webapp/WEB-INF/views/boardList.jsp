<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시판</title>
</head>
<body>
<header style="float:right">
    <c:choose><c:when test="${sessionScope.memberDto != null}"><c:out value="${sessionScope.memberDto.memberId}"/> 님
        <c:if test="${sessionScope.memberDto.userLevel == 3}">(<a href="managerPage">관리자 페이지</a>)</c:if> <a
                href="editMemberInfo">회원 정보 수정</a> <a href="logout">로그아웃</a></c:when><c:otherwise><a
            href="login">로그인</a></c:otherwise></c:choose>
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
        <c:forEach var="i" items="${boardList}">
            <tr>
                <c:url var="link" value="/viewBoard">
                    <c:param name="boardNo" value="${i.boardNo}"/>
                </c:url>
                <td>
                    <c:choose>
                        <c:when test="${i.notice == true}">
                            <b>공지</b>
                        </c:when>
                        <c:otherwise>
                            ${i.boardNo}
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${i.notice == true}">
                            <b><a href="${link}">${i.boardTitle}</a></b>
                        </c:when>
                        <c:otherwise>
                            <a href="${link}">${i.boardTitle}</a>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>${i.memberId}</td>
                <td>${i.boardHit}</td>
                <td>${i.writeDate}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <button onclick="location.href='insertBoard'">글 작성</button>
</div>
</body>
</html>