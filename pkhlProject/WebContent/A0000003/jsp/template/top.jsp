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
	 ${sessionScope.bsns_code}
	 <c:if test="${empty sessionScope.user_id}">
	 	<a href="joinAgreement.a3">회원가입</a> │ 
	 	<a href="view.a3?viewpage=/A0000003/jsp/user/userLogin_Form.jsp">로그인</a>
	 </c:if>
	 <c:if test="${!empty sessionScope.user_id}">
	 	${sessionScope.user_auth}
		<%-- <a href="adminImageList.a1"> ${sessionScope.admin_id}</a>  --%>
		<a href="userLogout.a3">로그아웃</a>
	 </c:if>
</body>
</html>