<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dmy.tipboard.vo.DmyTipBoardVO" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<%
	
	boolean keywordBool = false;
	boolean searchBool = false;
	
	DmyTipBoardVO searchVO = (DmyTipBoardVO)request.getAttribute("searchVO");
	keywordBool = searchVO.getKeyword()!=null && searchVO.getKeyword()!="";
	searchBool = searchVO.getSearchFilter()!=null && searchVO.getSearchFilter()!="";
	
	
%>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/tipboard/listboard.css" rel="stylesheet" />
<title>팁공유게시판 목록</title>
<script type="text/javascript">

	$(document).ready(function(){
		//alert(">>>")
		
		//제목클릭 이벤트
		$(".goDetail").click(function(){
		var dtb_no = $(this).parents("div").attr("data-no");
		
		$("#dtb_no").val(dtb_no);
	  //$("#smb_no").val(smb_no);
		//상세페이지로 이동
		$("#selectForm").attr({
			"method":"post",
			"action":"detailboard.dmy"
		}).submit();
	  });//end of goDetail click 
	  
		$("#insertboard").click(function(){
			//console.log("insertBoard value >>> " + $("#insertboard").val());
			$("#selectForm").attr("action","insertForm.dmy");
			$("#selectForm").submit();
		});
		
	  
	  //검색버튼클릭이벤트
	  $("#searchbtn").click(function(){
		  //조회페이지로 이동
		  $("selectForm").attr({
			  "method":"post", 
			  "action":"listboard.dmy"
		  });
		  $("#selectForm").submit();
	  });//end of searchbtn click
	  
	  //카테고리 변경
	  $("#dtb_category").change(function(){
		  console.log("category value>>>" + $("#dtb_category").val());
		  //조회페이지로 이동
		  $("#selectForm").attr({
			  "method":"post", 
			  "action":"listboard.dmy"
		  });
		  $("#selectForm").submit();
	  });//end of dtb_category change 


		
	});//end of ready
</script>
</head>
<body>
<%@include file="../common/header.jsp" %>
<!-- Content -->
<section>
	<div class="container">
		<h1>팁공유게시판</h1>
		<div class="board">
			<form name="boardForm" id="boardForm" method="post">
			<!-- 카테고리, 제목(+작성자), 검색부분 -->
			<div class="sub">
				<!-- 카테고리, 제목(+작성자) -->
				<div class="sub_category_subject">
					<!-- 카테고리 -->
					<div class="sub_category">
						<select name="dtb_category" id="dtb_category" >
							<option value="전체">전체</option>
							<option value="루틴">루틴</option>
							<option value="축구">축구</option>
						    <option value="야구">야구</option>
						    <option value="농구">농구</option>
						    <option value="기타">기타</option>
						</select>
					</div>
				</div>
					<!-- 제목(+작성자) -->
					<div class="sub_subject">
						<select name="searchFilter" id="searchFilter">
							<option value="제목">제목</option>
							<option value="내용">내용</option>
							<option value="제목+내용">제목+내용</option>
						</select>
					</div>
					 <div class="sub_search">
						<input type="text" name="keyword" id="keyword" placeholder="검색어 입력" size="30px">
						<input type="button" class="searchbtn" id="searchbtn" value="검색"> 
						<input type="hidden" id="page" name="page">
					</div>
			</div>
		
			<%
			Object obj = request.getAttribute("listboard");
				if(obj !=null)	{
				List plist = (List)obj;
				if(plist.size() > 0){
				DmyTipBoardVO stvo = (DmyTipBoardVO)plist.get(0);
			%>	
				<div class="sub_total_insertbtn">
					 <span class="sub_total">총 <%= stvo.getdpg_totalSize() %>개 게시글</span>
					 <div>
					 	<input class="sub_insertbtn" type="button" value="글쓰기" id="insertboard" >
					 </div>
				</div>
<%
				}
			}
		
%>
	</form>
<!-- 게시물 부분 -->
		<div>
		<form class="selectForm" name="selectForm" id="selectForm" method="post">
			<input type="hidden" name="dtb_no" id="dtb_no">
		</form>
		<div class="board">
			<div class="board_info">
				 <div class="info info_num" style="width: 16%;">글번호</div>
				 <div class="info info_category" style="width: 16%;">카테고리</div>
				 <div class="info info_subject" style="width: 23%;">제목</div>
				 <div class="info info_author" style="width: 16%;">작성자</div>
				 <div class="info info_inserdate" style="width: 16%;">작성일</div>
				 <div class="info info_total" style="width: 16%;">조회수</div>
			</div>
		
		<%
				
				if(obj != null){
					List list = (List)obj;
					int nCnt = list.size();
					if(nCnt > 0){
						for(int i = 0; i < nCnt; i++){
							DmyTipBoardVO param = (DmyTipBoardVO)list.get(i);
			
				
		%>
		
			 <div class="board_content" data-no ="<%= param.getdtb_no() %>">
				<div class="content content_num" style="width: 16%;"><%= param.getdtb_no() %></div>
				<div class="content content_category" style="width: 16%;"><%=param.getdtb_category() %></div>
				<div class="content content_subject goDetail" style="width: 23%;"><%= param.getdtb_subject() %></div>
				<div class="content content_inserdate" style="width: 16%;"><%= param.getdtb_insertdate() %></div>
				<div class="content content_total" style="width: 16%;"><%= param.getdtb_viewcnt() %></div>
			</div>
						
		<%
						}
					}
				}else{
		%>
						<div class="board_nondate">
							<span>등록된 데이터가 존재하지 않습니다...😥</span>
						</div>
						<div>
		<%
				}
				if(obj !=null )	{
					List list = (List)obj;
					int cnt = list.size();
					if(cnt > 0){
					DmyTipBoardVO dvo = (DmyTipBoardVO)list.get(0);
				
		%>
					<div class = "paging_Box">
							<jsp:include page="../tipboard/paging.jsp" flush="true">
								<jsp:param name="url" value="listboard.dmy" />
								<jsp:param name="str" value="" />
								<jsp:param name="dpg_pageSize" value="<%= dvo.getdpg_pageSize() %>" />
								<jsp:param name="dpg_groupSize" value="<%= dvo.getdpg_groupSize() %>" />
								<jsp:param name="dpg_curPage" value="<%= dvo.getdpg_curPage() %>" />
								<jsp:param name="dpg_totalSize" value="<%= dvo.getdpg_totalSize() %>" />
							</jsp:include>
					</div>
			<%
					}
				}
		%>
			</div>
		</div>
	</div>
	</div>
</div>
</section>
<%@include file="../common/footer.html" %>
</body>
</html>