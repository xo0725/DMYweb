<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dmy.tipboard.vo.DmyTipBoardVO" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>게시판삭제</title>
</head>
<script type="text/javascript">
	
	$(document).ready(function(){
		
		$("#deletebtn").click(function(){
			
			$("#deleteForm").attr({
				"method":"POST",
				"enctype":"multipart/form-data",
				"action":"deleteboard.Dmy"
			}).submit();
			
		});//end of updateBoardbtn click
		
		$("#cancledeletebtn").click(function(){
			
			location.href="lidtboard.Dmy";
		});	//end of cancelBoardbtn click
		
	});//end of ready
</script>
<body>
<%@ include file="../common/header.jsp" %>
<!-- Content -->
<section>
	<div class="container" align="center" style="margin: 200px auto;">
<%
	Object obj = request.getAttribute("detailboard");
	if(obj != null){
		List list = (List)obj;
		int nCnt = list.size();
		if(nCnt > 0){
			for(int i = 0; i < nCnt; i++){
				DmyTipBoardVO param = (DmyTipBoardVO)list.get(i);
				System.out.println("delete no param >>> " + param.getdtb_no());
%>
	<form id="deleteForm" name="deleteForm" method="post">
	<input type="hidden" id="dtb_no" name="dtb_no" value="<%= param.getdtb_no() %>">
	<input type="hidden" id="dmb_no" name="dmb_no" value="<%= param.getdmb_no() %>">
	<input type="hidden" id="dtb_file" name="dtb_file" value="<%= param.getdtb_file() %>">
	
		<table align="center">
			<tr>
				<td><h3>게시글을 삭제하시겠습니까?</h3></td>
			</tr>
			<br>
			<tr>
				<td align="center">
					<input type="button" id="deletebtn" value="삭제">
					<input type="button" id="cancledeletebtn" value="취소">
				</td>
			</tr>
		</table>		
	</form>
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
</body>
</html>