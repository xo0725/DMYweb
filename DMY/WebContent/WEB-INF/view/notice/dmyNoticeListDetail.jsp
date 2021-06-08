<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="dmy.notice.vo.DmyNoticeVO"%>
<%@ page import="java.util.List"%>
<%
	Object obj = request.getAttribute("noticeList");
	HttpSession session1 = request.getSession();
	
	String value = (String)session1.getAttribute("smb_mf");
	System.out.println("value >>> " + value);
	
	DmyNoticeVO list = (DmyNoticeVO)obj;
	DmyNoticeVO dnvo = list;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<meta name="viewprot" content="width=device-width, initial-scale=1.0" />
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/notice/dmyNoticeDetailBoard.css">
<script type="text/javascript">
	
	// 업데이트
	function goUpdate(){
		var dnt_no = $("#dnt_no").val();
		$("#detailboard").attr("action","noticeListDetail2.dmy")
		$("#detailboard").submit();
	}
	
	// 삭제
	function goDelete(){
		var dnt_no = $("#dnt_no").val();
		$("#detailboard").attr("action","deleteClick.dmy")
		$("#detailboard").submit();
	}
	
	function goList(){
		history.go(-1);
	}
	
	// 파일 다운로드
	function goDownLoad(){
		$("#detailboard").attr({
			"method":"POST",
			"action":"takeFileClick.dmy"
		}).submit();
	}
	
	// 첨부파일 null값
	$(function(){
		var fileValue = $("#file").children().text();
		if(fileValue=="null"){
			$("#file").text("");
		}
	})
	
</script>
<style>
section .container #buttonform .detailboard_btn
{
    padding-bottom: 15px;
    border-bottom: 1px solid rgb(179, 179, 179);
}
section .container #buttonform .detailboard_btn input[type=button]
{
    border-style: none;
    padding: 4px 10px;
    margin-left: 5px;
    font-size: 14px;
    font-weight: 500;
    font-family: var(--font-family-noto);
    border-radius: 5px;
}
</style>
</head>
<body>
<!-- Content -->
<section>
	<div class="container">
		<form name="buttonform" id="buttonform" method="post">
			<div class="detailboard_btn" align="right">
				<input type="button" value="다운로드" id="filedown" onclick="goDownLoad()"/>
				<%
					if(value == null){
				%>
				<input type="button" value="수정" id="updateForm" onclick="goUpdate()" />
				<input type="button" value="삭제" id="deleteForm" onclick="goDelete()" />
				<%
					}
				%>
				<input type="button" value="목록" id="listForm" onclick="goList()" />
			</div>
		</form>
		
		<form name="detailboard" id="detailboard" method="post">
			<input type="hidden" name="dnt_no" id="dnt_no" value="<%= dnvo.getDnt_no() %>"/>
			<input type="hidden" name="dnt_file" id="dnt_file" value="<%= dnvo.getDnt_file() %>"/>
			<div class="detailBoardMain">
			<table>
				<br><br><br>
				<tr>
					<td><h1><%= dnvo.getDnt_subject() %></h1></td>
				</tr>
				<tr>
					<td>관리자&nbsp;&nbsp;&nbsp;&nbsp; <%= dnvo.getDnt_insertdate() %>&nbsp;&nbsp;&nbsp;&nbsp; <%= dnvo.getDnt_viewcnt() %></td>
        		</tr>
			</table>
			</div>
			
			<br><br>
			<hr>
			<table>
				<br><br><br>
				<tr>
					<td><%=dnvo.getDnt_content() %></td>
				</tr>
				<tr></tr>
				<tr></tr>
				<tr>
					<td id="file"><a href="javascript:goDownLoad()"><%= dnvo.getDnt_file() %></a></td>	
				</tr>
			</table>
		</form>
	</div>
</section>
</body>
</html>