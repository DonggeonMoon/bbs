<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 보기</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<body>
	<h1>게시글 보기</h1>
	<div style="width:100%;">
		<table border="1px" style="width:100%;text-align:center;">
			<colgroup>
				<col style="width:20%"/>
				<col style="width:80%"/>
			</colgroup>
			<tr>
				<td>제목</td>
				<td><c:out value="${board.board_title }" /></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><c:out value="${board.member_id }" /></td>
			</tr>
			<tr>
				<td>조회수</td>
				<td><c:out value="${board.board_hit }" /></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><c:out value="${board.board_content }" /></td>
			</tr>
			<tr style="text-align:right;">
				<td colspan="2">
					<input type="button" value="수정" onclick="location.href='updateBoard?board_no=${board.board_no}'">
					<input type="button" value="삭제" onclick="location.href='deleteBoard?board_no=${board.board_no}'">
				</td>
			</tr>
		</table>
		<button onclick="history.back(-1);">돌아가기</button>
	</div>
	<div style="width:100%;">
		<table border="1" style="width:100%;">
			<c:forEach var="i" items="${commentList }">
				<c:url var="link" value="/viewBoard">
					<c:param name="board_no" value="${i.board_no }" />
				</c:url>
				<tr>
					<td colspan="6"><c:out value="${i.member_id}" /></td>
				</tr>
				<tr>
					<td>
					<c:forEach begin="0" end="${i.comment_depth - 1}" step="1">
						<span>+</span>
					</c:forEach>
					<c:out value="${i.comment_content}"/>
					<form style="display:inline;" action="addComment2" method="post">
						<input type="hidden" name="board_no" value="<c:out value='${board.board_no }' />">
						<input type="hidden" name="comment_parent" value="<c:out value='${i.comment_no }' />">
						<input type="hidden" name="comment_depth" value="<c:out value='${i.comment_depth + 1 }' />">
						<input type="hidden" name="comment_seq" value="<c:out value='${i.comment_seq + 1}' />">
						<input type="hidden" name="member_id" value="<c:out value='test' />">
						<textarea name="comment_content" cols="100"></textarea>
						<input  type="submit" value="댓글 달기" >
					</form>
					<form style="display:inline;" action="updateComment" method="post">
						<input type="hidden" name="board_no" value="<c:out value='${board.board_no }' />">
						<input type="hidden" name="comment_no" value="${i.comment_no }">
						<textarea name="comment_content" cols="100"></textarea>	
						<input type="submit" value="댓글 수정">
					</form>
					<form style="display:inline;" action="deleteComment" method="post">
						<input type="hidden" name="board_no" value="<c:out value='${board.board_no }' />">
						<input type="hidden" name="comment_no" value="${i.comment_no }">
						<input type="submit" value="댓글 삭제">
					</form>
					</td>
				</tr>
			</c:forEach>
			<tr style="text-align:center;">
				<td colspan="6">
					<form action="addComment" method="post">
						<textarea name="comment_content" cols="100"></textarea>
						<input type="hidden" name="board_no" value="<c:out value='${board.board_no }' />">						
						<input type="hidden" name="comment_depth" value="<c:out value='1' />">
						<input type="hidden" name="comment_seq" value="<c:out value='1' />">
						<input type="hidden" name="member_id" value="<c:out value='test' />">
						<input type="submit" value="댓글 달기">
					</form>
				</td>
			</tr>
		</table>
		<button onclick="location.href='boardList'">목록</button>
	</div>
</body>
</html>