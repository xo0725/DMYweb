<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="dmy.notice.vo.DmyNoticeVO"%>
<%@ page import="java.util.List"%>
<%
	Object obj = request.getAttribute("noticeList");
	DmyNoticeVO dnvo = (DmyNoticeVO) obj;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<meta name="viewprot" content="width=device-width, initial-scale=1.0" />
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		$("#updateBoardFunc").click(function() {
			$("#boardDetail2Form").attr("action", "updateClick.dmy");
			$("#boardDetail2Form").submit();

		});

		$("#cancel").click(function(){
			history.go(-1);
		});
	});
</script>
<link rel="stylesheet" type="text/css" href="css/notice/dmyNoitceInsertForm.css">
</head>
<body>
<section>
	<div class="container">
		<h3>수정페이지</h3>
		<form id="boardDetail2Form" name="boardDetail2Form" method="POST">
		<input type="hidden" id="dnt_no" name="dnt_no" value="<%= dnvo.getDnt_no()%>" /> 
			<div id="boardDetail">
				<div class="insert insert_subject">
					<input type="text" id="insert_subject input" name="dnt_subject" placeholder="제목" value="<%=dnvo.getDnt_subject()%>" />
				</div>
				<div class="insert insert_content">
					<textarea id="dnt_content" name="dnt_content" placeholder="내용" ><%=dnvo.getDnt_content()%></textarea>
				</div>
				<div class="insert insert_file preview-image">
					<input class="upload-name" value="파일선택" disabled="disabled">
					<label for="dnt_file">업로드</label> 
					<input type="file" class="upload-hidden" id="dnt_file" name="dnt_file" size="110px" />
				</div>
				<div class="insert insert_subbtn" align="center">
					<input type="button" id="updateBoardFunc" value="[등록]" /> <input type="reset" id="cancel" value="[취소]" />
				</div>
			</div>
		</form>
	</div>
</section>
</body>
</html>