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
	<header>
        <div class="navbar navbar-default navbar-static-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.a1"><span>M</span>oderna</a>
                </div>
                <div class="navbar-collapse collapse ">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="index.a1">메인</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle " data-toggle="dropdown" data-hover="dropdown" data-delay="0" data-close-others="false">Company <b class=" icon-angle-down"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="Introduction.a1">회사소개</a></li>
                                <li><a href="Alteration.a1">용도변경</a></li>
								<li><a href="Repair.a1">대수선 증축 개축</a></li>
                            </ul>
                        </li>
                        <li><a href="noticeList.a1">공지사항</a></li>
                        <li><a href="qnaList.a1">문의사항</a></li>
                 
                    <!-- 메인이미지관리(관리자) -->
					<c:if test="${not empty sessionScope.admin_id}">       
                        <li><a href="adminImageList.a1">메인이미지관리</a></li>
                   </c:if>     
                    </ul>
                </div>
            </div>
        </div>
	</header>
	
	
	
	
	
</body>
</html>