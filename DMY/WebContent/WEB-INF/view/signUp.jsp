<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		
		$("#signUpMatchBtn").click(function() {
			alert("매칭 신청!!!");
			$("#viewSignUpMatch").attr({
				"action":"signUpMath.ljm",
				"method":"GET",
				"enctype":"application/x-www-form-urlencoded"
			}).submit();
		});
	});
</script>
</head>
<body>

<form name="viewSignUpMatch" id="viewSignUpMatch">
<table border="1" align="center">
	<tr>
		<td colspan="2" align="center"><h2>매칭 신청</h2></td>
	</tr>

	<tr>
		<td align="center"><h4>지원 번호</h4></td>
		<td><input type="text" name="dsu_no" id="dsu_no"></td>
	</tr>

	<tr>
		<td align="center"><h4>제목</h4></td>
		<td><input type="text" name="dsu_subject" id="dsu_subject"></td>
	</tr>
	
	<tr>
		<td align="center"><h4>지역</h4></td>
		<td><input type="text" name="dsu_area" id="dsu_area"></td>
	</tr>
	
	<tr>
		<td align="center"><h4>간단한 소개</h4></td>
		<td><input type="text" name="dsu_introduce" id="dsu_introduce"></td>
	</tr>
	
	<tr>
		<td colspan="2" align="center">
		<input type="button" value="보내기" id="signUpMatchBtn" name="signUpMatchBtn">
		<input type="reset" value="취소">
	</tr>


</table>
</form>

</body>
</html>


