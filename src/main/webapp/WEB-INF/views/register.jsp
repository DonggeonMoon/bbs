<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	var idChk = false;
	var checkedId = "";
	
	console.log("버튼 눌림");
	
	$(document).ready(function(){
		$("#checkId_btn").click(function(){
			var member_id = $("#member_id").val();
			if (member_id != "") {
				$.ajax({
					async : true,
					type : "POST",
					data: member_id,
					url : "checkId",
					dataType : "json",
					contentType : "application/json; charset=UTF-8"
				}).done(function(data){
					if (data.isUnique) {
						idChk = true;
						alert("사용할 수 있는 아이디입니다.");
						$("#member_pw").focus();
						checkedId = member_id;
					} else {
						alert("이미 존재하는 아이디입니다.");
						$("#member_id").focus();
					}
				}).fail(function(request, status, error) {
					alert("status : " + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
				});
			} else {
				alert("아이디를 입력해주세요.");
			}
		});
	});
	
	function confirmPw() {
		var member_pw = $("#member_pw").val();
		var member_pw2 = $("#member_pw2").val();
		return (member_pw == member_pw2) ? true : false;
	}
	
	function validateEmail(str) {
		var regex = /^([A-z0-9!@#$%^&\*+-/=?_`\{\}\|~;. ]+)@([A-z0-9\-]+).([A-z.]+)$/;
		
		return (regex.test(str)) ? true : false;
	}
	
	function submitForm() {
		if (idChk && checkedId == ($("#member_id").val())) {
			if($("#member_pw").val() != "") {
				if (confirmPw()) {
					if(validateEmail($("#member_email").val())) {
						$("#form").submit();
					} else {
						alert("이메일 형식을 확인해주세요.");	
					}
				} else {
					alert("비밀번호가 일치하지 않습니다.");
				}
			} else {
				alert("비밀번호를 입력해주세요.")
			}
		} else {
			alert("아이디 중복 확인을 해주세요.");
		}
	}
</script>
</head>
<body>
	<div style="text-align:center;height:100%;line-height:50px">
		<h1>회원 가입</h1>
		<form id="form" action="register" method="post">
			<div>
				<label style="display:inline-block;width:20%;">아이디:</label>
				<div style="display:inline-block;width:40%;text-align:left;">
					<input style="width:60%;" type="text" id="member_id" name="member_id">
					<button style="margin:10px" type="button" id="checkId_btn">아이디 중복 확인</button>
				</div>
			</div>
			<div>
				<label style="display:inline-block;width:20%;">비밀번호:</label>
				<div style="display:inline-block;width:40%;text-align:left;">
					<input style="width:60%;" type="password" id="member_pw" name="member_pw">
				</div>
			</div>
			<div>
				<label style="display:inline-block;width:20%;">비밀번호 확인: </label> 
				<div style="display:inline-block;width:40%;text-align:left;">
					<input style="width:60%;" type="password" id="member_pw2">
				</div>
			</div>
			<div>
				<label style="display:inline-block;width:20%;">이메일: </label>
				<div style="display:inline-block;width:40%;text-align:left;">
					<input style="width:60%;" type="email" id="member_email" name="member_email" required>
				</div>
			</div>
			<input type="hidden" name="user_level" value="1">
			<div>
				<button type="button" onclick="submitForm()">회원 가입</button>
				<button type="button" onclick="history.back(-1);">돌아가기</button>
			</div>
		</form>
	</div>
</body>
</html>