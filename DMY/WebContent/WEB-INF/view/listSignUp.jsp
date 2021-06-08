<%@page import="dmy.signup.vo.DmySignUpVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>List SignUp</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		console.log('listSignUp 진입!!!');
		
		// 상세보기
		$(document).on("click","#viewSignUpBtn", function(){
			alert("viewSignUpBtn >>> : ");
	
			$("#viewSignUpForm").attr({
				"action":"viewSignUp.dmy",
				"method":"GET",
				"enctype":"application/x-www-form-urlencoded"
			}).submit();
		});
	});
</script>
</head>
<body>
<% request.setCharacterEncoding("EUC-KR");%> 
<%
	Object obj = request.getAttribute("signUpList");
	if(obj == null) return;
	
	List<DmySignUpVO> list = (List)obj;
	
	int nCnt = list.size();
	System.out.println("nCnt >>> : " + nCnt);
%>

<form name="viewSignUpForm" id="viewSignUpForm">
<table border="1" align="center">
	<thead>
	<tr>
			<td class="tt">신청번호</td>
			<td class="tt">제목</td>
			<td class="tt">지역</td>
			<td class="tt">간단한 소개</td>
			<td class="tt">신청 여부</td>
			<td class="tt">삭제여부</td>
			<td class="tt">입력일</td>
			<td class="tt">수정일</td>
		</tr>
	</thead>
<%
	for(int i =0; i < nCnt; i ++){
		DmySignUpVO svo = list.get(i);
%>	
	<tbody>
		<tr>
			<td class="tt"><%= svo.getDsu_no() %> </td>
			<td class="tt"><%= svo.getDsu_subject() %> </td>
			<td class="tt"><%= svo.getDsu_area() %> </td>
			<td class="tt"><%= svo.getDsu_introduce() %> </td>
			<td class="tt"><%= svo.getDsu_applyyn() %> </td>
			<td class="tt"><%= svo.getDsu_deleteyn() %> </td>
			<td class="tt"><%= svo.getDsu_insertdate() %> </td>
			<td class="tt"><%= svo.getDsu_updatedate() %> </td>
		</tr>	
<%
	}
%>	
		</tbody>
</table>
</form>


</body>
</html>