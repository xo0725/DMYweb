<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dmy.tipboard.vo.DmyTipBoardVO" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글</title>



<%
		Object obj = request.getAttribute("detailboard");
		if(obj != null){
		List list = (List)obj;
		int nCnt = list.size();
		if(nCnt > 0){
			for(int i = 0; i < nCnt; i++){
				DmyTipBoardVO param = (DmyTipBoardVO)list.get(i);
				String dtb_no = param.getdtb_no();
				String dmb_no = param.getdmb_no();
				System.out.println("dtb_no >>> " + dtb_no);
				System.out.println("dmb_no >>> " + dmb_no);
%>
<script type="text/javascript">
	$(document).ready(function(){
		//alert("ready 함수 >>>");
		calllistcomment();	
		
	});//end of ready
	
	//등록버튼 클릭이벤트
	function insertcommentFunc(){
		//alert("댓글등록버튼클릭>>>>");
		console.log("댓글등록버튼 클릭 >>>");
		console.log("stb_no >>> " + stb_no +", dmb_no >>> " + dmb_no);
		

		var dcm_content = $("#dcm_content").val();
		
		var urls = "insertcomment.Dmy";
		console.log("urls >>> " + urls);
		
		var types = "POST";
		console.log("types >>> " + types);
		
		var dataTypes = "html";
		console.log("dataTypes >>> " + dataTypes);
		
		var datas = {
					"dtb_no" : "<%=dtb_no%>",
					"dmb_no" : "<%=dmb_no%>",
					"scm_content" : scm_content
					 };
		console.log("datas >>> " + datas);
		
		$.ajax({
			url: urls,
			type: types,
			dataType: dataTypes,
			data: datas,
			success: WhenSuccess,
			error : WhenError
		});// end of ajax
		
		function WhenSuccess(insertResult){
			console.log("댓글등록 ajax 성공 >>> " + insertResult);
			//입력데이터 초기화
			dataReset();
			calllistcomment();	
		}
		function WhenError(request,status,error){
			alert("댓글등록실패 >>>");
			alert("code >>> " + request.status + ", message >>>" + request.reDmynseText + ", error >>> " + error);
		}
	}//end of insertcomment click event
  
	//댓글 수정버튼 클릭시 
	function updateForm_btn_Func(){
		alert("수정버튼클릭 >>>");
		
		//기존댓글 가져오기
		var scm_content = $(this).parants("tr").children().children().eq(1).html();
		console.log("scm_content >>>"  + scm_content);
		//수정,삭제 버튼 숨기기
		$(this).parents("tr").find("input[type='button']").hide();
		//댓글정보 데이터 가져오기
		$(this).parents("tr").children().children().eq(0).html();
		
		var scm_content_p = $(this).parents("tr").children().children().eq(1);
		scm_content_p.html("");
		
		//댓글수정폼 데이터 출력
		var data = "<textarea name= 'scm_contentup' id='scm_contentup'>" + scm_content + "</textarea>";
		data += "<input type='button' id='update_btn' value='등록' onclick='update_btn_func'>";
		data += "<input type='button' id='updateReset_btn' value='취소' onclick='updateReset_btn_func'>";
	}//end of 수정버튼 
	
	//수정완료버튼
	function update_btn_func(){
		console.log('댓글수정완료버튼 클릭!');
		
		var scm_no = $(this).parents("tr").attr("data-scm_no");
		var scm_content = $("#scm_contentup").val();
		
		
		var urls = "updatecomment.Dmy";
		console.log("urls >>> " + urls);
		
		var types = "POST";
		console.log("types >>> " + types);
		
		var dataTypes = "html";
		console.log("dataTypes >>> " + dataTypes);
		
		var datas = {
					"dmb_no" : "<%=dmb_no%>",
					"scm_no" : scm_no,
					"scm_content" : scm_content
					 };
		console.log("datas >>> " + datas);
		
		$.ajax({
			url : urls ,
			type : types ,
			dataType : dataTypes ,
			data : datas ,
			success : WhenSuccess ,
			error : WhenError
		});//end of ajax
		
		function WhenSuccess(updateResult){
			console.log("댓글수정 ajax 성공 >>> " + updateResult);
			//입력데이터 초기화
			calllistcomment();	
		}
		function WhenError(request,status,error){
			alert("댓글수정실패 >>>");
			alert("code >>> " + request.status + ", message >>>" + request.reDmynseText + ", error >>> " + error);
		}
	}//end of update_btn_func
	
	function updateReset_btn_func(){
		console.log('수정취소버튼 클릭이벤트 호출!');
		
		var scm_comment =  $(this).parents("tr").find("textarea").html();
		$(this).parents("tr").find("input[type='button']").show();
		var scm_content_p = $(this).parents("tr").children().eq(1);
		scm_content_p.html(scm_content);
		
	}//end of updateReset_btn_func

	function calllistcomment(){
		//alert("들어왓니?>>>");
		console.log("calllistcomment >>> ");
		console.log("stb_no >>> " + stb_no + ", dmb_no >>> " + dmb_no);
		
		$("#listcomment_ul").html("");
		
		var urls = "listcomment.Dmy";
		console.log("urls >>> " + urls);
		
		var types = "POST";
		console.log("types >>> " + types);
		
		var dataTypes = "JSON";
		console.log("dataTypes >>> " + dataTypes);
		
		var datas = {
				"dtb_no" : "<%=dtb_no%>",
				"dmb_no" : "<%=dmb_no%>"
			};
		console.log("datas >>> " + datas);
		
		$.ajax({
			
			url: urls,
			type: types,
			dataType: dataTypes,
			data: datas,
			success: comSuccess,
			error : comError
			
		});//end of ajax
		function comSuccess(map){
			console.log("댓글목록등록 ajax 성공 >>> " + map);
			var listcomment = map.listcomment;
			addNewcomment(listcomment);
		}
		function comError(){
			alert("댓글목록조회실패 >>>");

		}
	}//end of calllistcomment
	
	function addNewcomment(listcomment){
		console.log("addNewcomment >>> 조회된댓글갯수 >>> " + listcomment.length);
		
		for(var i = 0; i<listcomment.length; i++){
			var scm_no = listcomment[i].scm_no;
			var dmb_id = listcomment[i].dmb_id;
			var scm_insertdate = listcomment[i].scm_insertdate;
			var scm_content = listcomment[i].scm_content;
			
			//console.log('listcomment['+i+'] >>>\n scm_no : ' + scm_no + ', dmb_id : ' + dmb_id + ', scm_insertdate : ' + scm_insertdate 
			//		     + ', scm_content : ' + scm_content );
			
			var commentWriterBool = dmb_id == dmb_id;
			console.log("commentWriterBool >>> " + commentWriterBool);
			
			// 새 댓글 추가할 li태그 객체
			var newRe_li = $("<tr>");
			newRe_li.attr("data-scm_no",scm_no);
			newRe_li.attr("data-dmb_id",dmb_id);
			
			var newRe_td = $("<td style='width:1000px; height:100px;'>");
			newRe_td.addClass("first");
			newRe_td.addClass("last");
			
			// 작성정보가 출력될 <p>태그
			var info_p = $("<p>");
			info_p.addClass("marT5 marL5 marB5");
			
			
			// 댓글번호
			var no_span = $("<span>");
			no_span.addClass("bold");
			no_span.html(i+1 + "&nbsp;&nbsp;&nbsp;");
			
			// 작성자명
			var dmb_id_span = $("<span>");
			dmb_id_span.addClass("bold");
			dmb_id_span.addClass("marL5");
			dmb_id_span.html(dmb_id + "&nbsp;&nbsp;&nbsp;");
			
			// 작성일
			var scm_insertdate_span = $("<span>");
			scm_insertdate_span.addClass("marL10");
			scm_insertdate_span.html(scm_insertdate + "&nbsp;&nbsp;&nbsp;");	
			
			// 내용
			var scm_content_p = $("<p>");
			scm_content_p.addClass("marT5 marL5 marB5");
			scm_content_p.html(scm_content);
			
			//구분선
			var hr = $("<hr>");
			/*
			if(commentWriterBool){
				//수정폼 출력버튼
				var updateForm_btn_input = $("<input>");
				updateForm_btn_input.attr({"type":"button","id":"updateForm_btn","value":"수정", "onclick":"updateForm_btn_Func"});
				updateForm_btn_input.addClass("comment_btn");

				// 삭제버튼
				var delete_btn_input = $("<input>");
				delete_btn_input.attr({"type":"button","id":"delete_btn","value":"삭제", "onclick":"delete_btn_Func"});
				delete_btn_input.addClass("comment_btn");
			}
			*/
			// 조립하기
			info_p.append(no_span).append(dmb_id_span).append(scm_insertdate_span)
			newRe_td.append(info_p).append(scm_content_p)
			newRe_td.append(hr)
			//newRe_td.append(updateForm_btn_input).append(delete_btn_input)
			newRe_li.append(newRe_td);
			$("#listcomment_ul").append(newRe_li);
			
		}//end of for
	}//end of addNewcomment
	
	//데이터 초기화 함수
	function dataReset(){
		$("#scm_content").val("");
	}
</script>
</head>
<body>
	<div class="table_wrap">
	<form id="insertcommentForm">
			<table class="insert_wrap">
				<tr class = "marT5 marL5 marB5">
					<td>
						<textarea name="scm_content" id="scm_content" style="width: 1000px; height: 100px;" placeHolder="댓글을 입력해주세요." ></textarea>
						<input type="button" id="insertcomment" value="등록" style=" vertical-align:top; width:70px; height:105px;" onclick="insertcommentFunc()">
					</td>
				</tr>
			</table>
		</form>
		<table>
			 <thread>
			 	<tr>
			 		<th class="alignL total"></th>
			 	</tr>
			 </thread>
			 <tbody id = "listcomment_ul" style="width: 1000px; height: 100px;">
			 	<!-- 댓글 리스트 들어갈자리 -->
			 </tbody>
		</table>
	</div>
<%
			}
		}
	}
%>
</body>
</html>