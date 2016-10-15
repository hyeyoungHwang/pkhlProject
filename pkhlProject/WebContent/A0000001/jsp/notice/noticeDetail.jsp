<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<section class="callaction">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="big-cta">
					<div class="cta-text">
						<h2><span>상세내용</span></h2>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<br/><br/>
<center>
	<form id="noticeDetailForm" name="noticeDetailForm">
		<input type="hidden" name="notice_num" id="notice_num" value="${noticeDetail.NTC_NUM}">
		<input type="hidden" name="listsize" value="${listsize}">
		<input type="hidden" name="pageNum" value="${pageNum}">
		<input type="hidden" name="searchType" value="${searchType}">
		<input type="hidden" name="searchValue" value="${searchValue}">
		<input type="hidden" name="divisioncode" value="U">
		<input type="hidden" name="admin_id" value="${sessionScope.admin_id}">
		
		<table border = "2">
			<tr style="text-align: center;">
				<td width="100px">번호</td>
				<td width="30px">${noticeDetail.NTC_NUM}</td>
				<td width="200px"></td>
				<td width="100px">조회수</td>
				<td width="30px">${noticeDetail.NTC_HIT}</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;">작성자</td>
				<td colspan="3">${noticeDetail.ADMIN_ID}</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;">제목</td>
				<td colspan="3">${noticeDetail.NTC_TITLE}</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align:center; height:300px ;">내용</td>
				<td colspan="3" height="300px">${noticeDetail.NTC_CONTENT}</td>
			</tr>
		</table><br><br>
		
		<c:if test="${not empty sessionScope.admin_id}">
			<input type="button" value="수정" onclick="javascript:noticeUpdateForm('${noticeDetail.NTC_NUM}');">
		</c:if>
		<input type="button" value="목록" onclick="javascript:noticeList('noticeDetailForm');">
		<c:if test="${not empty sessionScope.admin_id}">
			<input type="button" value="삭제" onclick="javascript:noticeDelete('${noticeDetail.NTC_NUM}');">
		</c:if>
	</form>
</center>
<br/><br/>
</body>
</html>