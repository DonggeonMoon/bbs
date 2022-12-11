<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 작성</title>
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
                <td><input type="text" name="boardTitle" size="135" maxlength="200"></td>
            </tr>
            <tr>
                <td>내용</td>
                <td><textarea name="boardContent" rows="20" cols="100"></textarea></td>
            </tr>
            <tr>
                <td colspan="2">
                    <label><input type="checkbox" id="isNotice" name="isNotice" value="false" onchange="checkNotice()">공지</label>
                </td>
            </tr>
        </table>
        <input type="submit" value="글 입력">
        <button type="button" onclick="location.href='boardList'">목록</button>
        <input type="hidden" name="memberId" value="test">
    </form>
</div>
</body>
</html>