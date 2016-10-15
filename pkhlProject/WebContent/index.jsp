<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 로컬 -->
<script type="text/javascript">
          window.location = "modelhouse/index.a3";
	 //   window.location = "archidom/index.a1";
     //   window.location = "archidomArchitect/index.a2";
</script>
	
	
<!-- 운영 -->
<%-- <%
	// url 
	String url = request.getRequestURL().toString(); 
%>


<%
	/* 1. Archidom(A0000001) */ 
	if("http://pkhl2.nanuminet.co.kr/index.jsp".equals(url)){
%> 
	<script type="text/javascript">
		window.location = "archidom/index.a1";
	</script>
<%   
	}
%>



<%
    /* 2. archidomArchitect(A0000002) */
	if("http://pkhlweb.com/index.jsp".equals(url)){
%>
	<script type="text/javascript">
		window.location = "archidomArchitect/index.a2";
	</script>
<%
	}
%>  --%>


</body>
</html>