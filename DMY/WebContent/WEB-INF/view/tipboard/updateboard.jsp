<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dmy.tipboard.vo.DmyTipBoardVO" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/tipboard/updateboard.css" rel="stylesheet" />
<title>팁공유게시판 수정</title>
<%
		Object obj = request.getAttribute("detailboard");
		String dtb_category = "";
		DmyTipBoardVO stvo = null;
		System.out.println("update obj >>>" + obj);
		if(obj != null){
			List list = (List)obj;
			int nCnt = list.size();
			if(nCnt > 0){
				for(int i = 0; i < nCnt; i++){
					DmyTipBoardVO param = (DmyTipBoardVO)list.get(0);
					dtb_category = param.getdtb_category();
	
%>
<script type="text/javascript">


		$(document).ready(function(){
			
			//수정버튼 클릭이벤트
			$("#updateBoardbtn").click(function(){
				
				$("#updateForm").attr({
					"method":"POST",
					"enctype":"multipart/form-data",
					"action":"updateboard.Dmy"
				}).submit();
				
			});//end of updateBoardbtn click
			
			
			//취소버튼클릭이벤트
			$("#cancelBoardbtn").click(function(){
				
				location.href="lidtboard.Dmy";
			});	//end of cancelBoardbtn click
			
			
			//목록버튼클릭이벤트
			$("#lidtboardbtn").click(function(){
				
				location.href="lidtboard.Dmy";
			});	//end of lidtboardbtn click
			
			$("#dtb_category").val("<%= dtb_category %>");
			
			
			 $("#shareYN").each(function() {
				
			     if(this.value == "Y"){ //값 비교

			            this.checked = true; //checked 처리

			      }

			 });
			 
			$("#shareYN").change(function(){
				alert(">>>");
				if($("#shareYN").is(":checked")){
					$("#dtb_shareyn").val('Y');
				}else{
					alert("!!!!");
					$("#dtb_shareyn").val('N');
				}
			}).submit();//end of dtb_shareyn
			
			
			
	});//end of ready
		
		function selectCategory(){
			console.log("selectCategory >>>");
			var sc = document.getElementById("dtb_category");
			var scSelected = sc.options[sc.selectedIndex].value;
			console.log("scSelected >>> " + scSelected);
	
				for(var i = 0; i < sc.length; i++){
					if(sc[i].value == scSelected){
						sc[i].selected = true;	
				}
			}
		}	  
		
</script>
<%
					}
				}
			}
%>
</head>
<body>
<%@include file="../common/header.jsp" %>
<!-- Content -->
<section>
	<div class="container">
	<P></P>
<div align="center">

<%
		
		if(obj != null){
			List list = (List)obj;
			int nCnt = list.size();
			if(nCnt > 0){
				for(int i = 0; i < nCnt; i++){
					DmyTipBoardVO param = (DmyTipBoardVO)list.get(i);
					System.out.println(param.getdtb_no());
					System.out.println(param.getdtb_file());
%>			
	
	<form id="updateForm" name="updateForm" method="multipart/form-data">
	<input type="hidden" id="dtb_no" name="dtb_no" value="<%= param.getdtb_no() %>">
	<input type="hidden" id="smb_no" name="smb_no" value="<%= param.getdmb_no() %>">
	<input type="hidden" id="dtb_file" name="dtb_file" value="<%= param.getdtb_file() %>">
		<table border = "1">
	
				<tr>
					<td colspan="3" align="center">
						<h4>팁공유게시판 수정</h4>
					</td>
				</tr>	
				<tr>
					<td>카테고리</td>
					<td>
						<select name="dtb_category" id="dtb_category"  onchange="selectCategory()">
							<option value="">선택</option>
							<option value="루틴">루틴</option>
							<option value="축구">축구</option>
						    <option value="야구">야구</option>
						    <option value="농구">농구</option>
						    <option value="기타">기타</option>
						</select>
					</td>
				</tr>				
				<tr>
					<td>제목</td>
					<td>
						<input type="text" id="dtb_subject" name="dtb_subject" value="<%= param.getdtb_subject() %>" size="110px" />
					</td>
				</tr>				
				<tr>
					<td></td>
					<td>
						<input type="hidden" id="dtb_shareyn" name="dtb_shareyn" value="<%= param.getdtb_shareyn() %>" />
						<input type="checkbox" id="shareYN" name="shareYN" value="<%= param.getdtb_shareyn() %>"size="110px" />공유하기
					</td>
				</tr>
				
				<tr>
					<td>내용</td>
					<td>
						<textarea id="dtb_content" name="dtb_content"  cols="115" rows="20"><%= param.getdtb_content() %></textarea>
					</td>
				</tr>
				
				<tr>
					<td>파일</td>
					<td>					
					<input type="file" id="dtb_file" name="dtb_file" value="<%= param.getdtb_file() %>" size="110px" />
					</td>
				</tr>
			</table>
			<br>
<div align="center">
	<input type="button" value="수정" id="updateBoardbtn">
	<input type="button" value="취소" id="cancelBoardbtn">
	<input type="reset" value="다시" >
	<input type="button" value="목록" id="lidtboardbtn">
</div>
<%
			}
		}
	}
%>
	
		
</form>
</div>
		</div>
	</section>
<%@include file="../common/footer.html" %>
</body>
</html>