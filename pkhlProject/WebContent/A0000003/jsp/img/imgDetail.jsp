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

	<form id="imgDetailForm" name="imgDetailForm">
		<input type="hidden" name="img_sn" id="img_sn" value="${imgDetail.IMG_SN}">
		<input type="hidden" name="listsize" value="${listsize}">
		<input type="hidden" name="pageNum" value="${pageNum}">
		<input type="hidden" name="searchType" value="${searchType}">
		<input type="hidden" name="searchValue" value="${searchValue}">
		<input type="hidden" name="divisioncode" value="U">
		<input type="hidden" name="user_id" value="${sessionScope.user_id}">
		
		<table border = "2">
			<tr style="text-align: center;">
				<td width="100px">번호</td>
				<td width="30px">${imgDetail.IMG_SN}</td>
				<td width="200px"></td>
				<td width="100px">조회수</td>
				<td width="30px">${imgDetail.IMG_HIT}</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;">작성자</td>
				<td colspan="3">${imgDetail.USER_ID}</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;">제목</td>
				<td colspan="3">${imgDetail.IMG_TITLE}</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align:center; height:300px ;">내용</td>
				<td colspan="3" height="300px">${imgDetail.IMG_CONTENT}</td>
			</tr>
			<tr>
				<td colspan="5">
				${savePath}<br>
				${imgDetail.IMG_FILE_NM}<br>
				
				<br>
				
				<c:out value="${savePath}"/>\<c:out value="${imgDetail.IMG_FILE_NM}"/>
				D:\pkhlProject\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\pkhlProject\A0000003\images\게하3.png
				<img src="/A0000003/images/${imgDetail.IMG_FILE_NM}" style="width: 200px; height: 100px">
				
				</td>
			</tr>
		</table><br><br>
		
		<c:if test="${not empty sessionScope.user_id}">
			<input type="button" value="수정" onclick="javascript:imgUpdateForm('${imgDetail.IMG_SN}');">
		</c:if>
		<input type="button" value="목록" onclick="javascript:imgList('imgDetailForm');">
		<c:if test="${not empty sessionScope.user_id}">
			<input type="button" value="삭제" onclick="javascript:imgDelete('${imgDetail.IMG_SN}');">
		</c:if>
	</form>

<br/><br/>
</body>
</html>