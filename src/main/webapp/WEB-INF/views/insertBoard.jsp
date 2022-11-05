<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	function checkNotice() {
		let is_notice = $("#is_notice").val();
		console.log(is_notice);
		if (is_notice == 'true') $("#is_notice").val('false');
		else $("#is_notice").val('true');
	}
</script>
</head>
<body>
	<h1>게시글 작성</h1>
	<div style="width:100%;">
		<form action="insertBoard" method="post">
			<table border="1px" style="text-align:center">
				<colgroup>
					<col style="width:20%"/>
					<col style="width:80%"/>
				</colgroup>
				<tr>
					<td>제목</td>
					<td><input type="text" name="board_title" size="135" maxlength="200"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea name="board_content" rows="20" cols="100"></textarea></td>
				</tr>
				<tr>
					<td colspan="2">
						<label><input type="checkbox" id="is_notice" name="is_notice" value="false" onchange="checkNotice()">공지</label>
					</td>
				</tr>
			</table>
			<input type="submit" value="글 입력">
			<button type="button" onclick="location.href='boardList'">목록</button>
			<input type="hidden" name="member_id" value="test">
		</form>
	</div>
</body>
</html>