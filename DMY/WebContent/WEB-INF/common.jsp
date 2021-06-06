<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Favicon-->
	<link rel="icon" type="/spoMatch/image/x-icon" href="img/favicon.ico" />
<!-- Font Awesome icons (free version)-->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css" integrity="sha384-HzLeBuhoNPvSl5KYnjx0BT+WB0QEEqLprO+NBkkk5gbc67FTaL7XIGa2w1L0Xbgc" crossorigin="anonymous">
<!-- Google fonts-->
	<link href="https://fonts.googleapis.com/css?family=Merriweather+Sans:400,700" rel="stylesheet" />
	<link href="https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic" rel="stylesheet" type="text/css" />
	<link href="https://fonts.googleapis.com/css2?family=Kalam:wght@300;400;700&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&display=swap" rel="stylesheet">
<!-- CSS -->
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<link rel="stylesheet" href="http://jqueryui.com/resources/demos/style.css">
	<link rel="stylesheet" type="text/css" href="css/paging.css" />
	<link href="css/navbar_example.css" rel="stylesheet" />
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
<% response.setContentType("text/html; charset=UTF-8"); %>
<% String result = String.valueOf(request.getAttribute("result")); %>
<% 
   HttpSession commonHs = request.getSession(false);
   Boolean mf = false;
   if(commonHs != null){
      String mfStr = (String)commonHs.getAttribute("smb_mf");
      if(mfStr != null){
         if(mfStr.equals("1")){
            mf = true;
         }else{
            mf = false;
         }
      }else{
         mf = false;
      }
   }
   System.out.println(">>>>>>>>>>>>"+mf);
%>
<script>
   $(document).ready(function(){
      var result = "<%=result%>" ;
      if(result != "null"){
         alert(result);
      }
   });

</script>
