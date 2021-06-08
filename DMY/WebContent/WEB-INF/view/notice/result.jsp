<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	alert("${result}");
	if("${result}".indexOf("문제")>-1){
		history.go(-1);
	}else{
		location.href="noticeList.dmy";
	}
</script>
</head>
<body>

</body>
</html>