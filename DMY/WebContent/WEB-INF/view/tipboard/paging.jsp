<%@ page contentType="text/html; charset=EUC-KR" %>

<%  
  //전달해야 할 변수 
  String  url = null;
  String  str = null;
  
  url = request.getParameter("url");
  str = request.getParameter("str");
  if(str != null){
    str = str + "&";
  }
%>
<%  
  //페이지 네비게이션 관련 변수 
  // 한페이지에 보여질 게시물의 수
  int pageSize = 0; 
  // 그룹의 크기
  int groupSize = 0;  
  // 전체 게시물의 개수
  int totalCount = 0; 
  //현재 페이지
  int curPage = 0;  
  // 전체 페이지의 개수
  int pageCount = 0;
  
  if(request.getParameter("spg_pageSize") != null)
  {
    pageSize = Integer.parseInt(request.getParameter("spg_pageSize"));
  }
  
  if(request.getParameter("spg_groupSize") != null)
  {
    groupSize = Integer.parseInt(request.getParameter("spg_groupSize"));
  }
  
  if(request.getParameter("spg_curPage") != null)
  {
    curPage = Integer.parseInt(request.getParameter("spg_curPage"));
  }
  
  if(request.getParameter("spg_totalSize") != null)
  {
    totalCount = Integer.parseInt(request.getParameter("spg_totalSize"));
  }
  
  System.out.println("pageSize 1>>> : " + pageSize);
  System.out.println("groupSize 1>>> : " + groupSize);
  System.out.println("curPage 1>>> : " + curPage);
  System.out.println("totalCount 1>>> : " + totalCount);
  
  // 전체게시물수와 페이지크기를 가지고 전체 페이지 개수를 계산함.
  // 소수점에 따라 계산상의 오류가 없도록 한것임.
  pageCount = (int)Math.ceil((float)totalCount / (float)pageSize);
  
  // 현재그룹 설정
  int curGroup = (curPage-1) / groupSize;
  int linkPage = curGroup * groupSize;
%>
<p align="center">
<ul class="paging model">
<%
  // 첫번째 그룹인 아닌경우
  if(curGroup > 0) {
%>
	<li><a href="<%=url%>?<%=str%>spg_curPage=1" class="linkPageBtn"><i class="fa fa-angle-double-left fa-2" aria-hidden="true"></i>&nbsp;&nbsp;&nbsp;</a></li>
	<li><a href="<%=url%>?<%=str%>spg_curPage=<%=linkPage%>" class="prev linkPageBtn"><i class="fa fa-angle-left fa-2" aria-hidden="true"></i>&nbsp;&nbsp;&nbsp;</a></li>
<%
  }
  else
  {
%>
	<li><a class="noLink"><i class="fa fa-angle-double-left fa-2" aria-hidden="true"></i>&nbsp;&nbsp;&nbsp;</a></li>
	<li><a class="noLink"><i class="fa fa-angle-left fa-2" aria-hidden="true"></i>&nbsp;&nbsp;&nbsp;</a></li>
<%
  }
  
  // 다음 링크를 위해 증가시킴
  linkPage++;
  
  int loopCount = groupSize;
  // 그룹범위내에서 페이지 링크만듬.
  while((loopCount > 0) && (linkPage <= pageCount))
  {
	 System.out.println("linkPage >>> " + linkPage);
	 System.out.println("curPage >>> " + curPage);
    if(linkPage == curPage)
    {
%>
  <li><a href="<%=url%>?<%=str%>spg_curPage=<%=linkPage%>" class="linkPageBtn active"><%=linkPage%>&nbsp;</a></li>
<%
    }
    else
    {
%>
  <li><a href="<%=url%>?<%=str%>spg_curPage=<%=linkPage%>" class="linkPageBtn"><%=linkPage%>&nbsp;</a></li>
<%
    }
    
    linkPage++;
    loopCount--;
  }
  System.out.println("linkPage >>> " + linkPage);
  System.out.println("pageCount >>> " + pageCount);
  
  // 다음그룹이 있는 경우
  if(linkPage <= pageCount)
  {
%>
	<li class="next"><a href="<%=url%>?<%=str%>spg_curPage=<%=linkPage%>" class="linkPageBtn"><i class="fa fa-angle-right fa-2" aria-hidden="true"></i>&nbsp;&nbsp;&nbsp;</a></li>
	<li><a href="<%=url%>?<%=str%>spg_curPage=<%=pageCount%>" class="linkPageBtn"><i class="fa fa-angle-double-right fa-2" aria-hidden="true"></i>&nbsp;&nbsp;&nbsp;</a></li>
<%
  }
  else
  {
%>
	<li><a class="noLink"><i class="fa fa-angle-right fa-2" aria-hidden="true" ></i>&nbsp;&nbsp;&nbsp;</a></li>
	<li><a class="noLink"><i class="fa fa-angle-double-right fa-2" aria-hidden="true"></i>&nbsp;&nbsp;&nbsp;</a></li>
<%
  }
%>
</ul>
</p>