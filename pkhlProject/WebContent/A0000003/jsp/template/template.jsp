<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<title>PKHL</title>
</head>
<body>
<div id="">
	<!-- 홈 관리자 -->
	<div style="text-align: right"><jsp:include page="top.jsp"/></div>
	
	<!-- 탑메뉴 -->
	<div style="text-align: center;"><jsp:include page="topmenu.jsp"/></div>
	
	<!-- 중간내용 -->
	<div>
		<div style="position: relative; float:left;"><jsp:include page="leftmenu.jsp"/></div>
		<div style="position: relative;"><jsp:include page="${content}"/></div>
	</div>
	
	<!-- 바텀 -->
	<div><jsp:include page="bottom.jsp"/></div>
</div>
</body>
</html>