<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PKHL</title>
</head>
<body>
	 <a href="index.a1">홈</a> │ 
	 <c:if test="${empty sessionScope.admin_id}">
	 	<a href="view.a1?viewpage=/A0000001/jsp/admin/adminLogin_Form.jsp">관리자</a>
	 </c:if>
	 <c:if test="${!empty sessionScope.admin_id}">
		<a href="adminImageList.a1"> ${sessionScope.admin_id}</a> 
		<a href="adminLogout.a1">로그아웃</a>
	 </c:if>
</body>
</html>