<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dmy.tipboard.vo.DmyTipBoardVO" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/tipboard/deletepwCheck.css" rel="stylesheet" />
<title>비밀번호 체크</title>
<%
		Object obj = request.getAttribute("detailboard");
		if(obj != null){
			List list = (List)obj;
			int nCnt = list.size();
			if(nCnt > 0){
				for(int i = 0; i < nCnt; i++){
					DmyTipBoardVO param = (DmyTipBoardVO)list.get(0);
					String dtb_pw = param.getdtb_pw();
					System.out.println(dtb_pw);
%>
<script type="text/javascript">
    
	$(document).ready(function(){
		$("#pwCheckbtn").click(function(){	
			//alert($("#dtb_pwCheck").val());
			if($("#dtb_pwCheck").val() == <%= dtb_pw %>){
				//alert("!!!!!!!!!!!");
				 $("#pwCheckForm").attr({
					 
					  "action":"deleteForm.Dmy"
				  });
				  $("#pwCheckForm").submit();
			}else{
				//alert("????????");
				alert("비밀번호가 일치하지 않습니다.")
				history.go(-1);
			}
		});
	});
</script>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<!-- Content -->
<section>
	<div class="container" align="center" style="margin: 200px auto;">
	<div>
		<form id="pwCheckForm" name="pwCheckForm" method="post">
			<input type="hidden" id="dtb_no" name="dtb_no" value="<%= param.getdtb_no()%>" />
			<input type="hidden" id="dmb_no" name="dmb_no" value="<%= param.getdmb_no()%>" />
			<input type="hidden" id="session_no" name="session_no" value="<%= param.getSession_no()%>" />
			<input type="hidden" id="dtb_pw" name="dtb_pw" value="<%= param.getdtb_pw()%>" />

			<div class = "input-field col s12">
				<h2>비밀번호 확인</h2>
			</div>
			<div class = "input-field col s12">
				<div class = "pw">
					<input type="text" id="dtb_pwCheck" name="dtb_pwCheck" required>
				</div>
				<br>
				<div class = "button" align="center">
					<input type="submit" id="pwCheckbtn" value="확인">
					<input type="button" id="cancle" value="취소" onclick="history.go(-1);">
				</div>
			</div>
		</form>
	</div>
	</div>
</section>
<%
				}
			}
		}
%>
<%@ include file="../common/footer.html" %>
</body>
</html>