<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	function checkNotice() {
		let isNotice = $("#isNotice").val();
		console.log(isNotice);
		if (isNotice == 'true') $("#isNotice").val('false');
		else $("#isNotice").val('true');
	}
</script>
</head>
<body>
	<h1>게시글 수정</h1>
	<div style="width:100%;">
		<form action="updateBoard" method="post">
			<table border="1px" style="text-align:center">
				<colgroup>
					<col style="width:20%"/>
					<col style="width:80%"/>
				</colgroup>
				<tr>
					<td>제목</td>
					<td><input type="text" name="boardTitle" size="135" maxlength="200" value="<c:out value='${boardDto.boardTitle }' />"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea name="boardContent" rows="20" cols="100"><c:out value='${boardDto.boardContent }' /></textarea></td>
				</tr>
				<tr>
					<td colspan="2">
						<label><input type="checkbox" id="isNotice" name="isNotice" value="${boardDto.isNotice }" onchange="checkNotice()" <c:if test="${boardDto.isNotice }">checked</c:if>>공지</label>
					</td>
				</tr>
			</table>
			<input type="submit" value="글 입력">
			<button type="button" onclick="location.href='boardList'">목록</button>
			<input type="hidden" name="boardNo" value="<c:out value="${boardDto.boardNo }" />">
			<input type="hidden" name="boardHit" value="<c:out value="${boardDto.boardHit }" />">
			<input type="hidden" name="memberId">
		</form>
	</div>
</body>
</html>