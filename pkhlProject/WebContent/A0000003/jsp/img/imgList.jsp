<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PKHL</title>
<body>
<section class="callaction">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="big-cta">
					<div class="cta-text">
						<h2><span>이미지 게시판</span></h2>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<br><br>
<center>
<form id="imgListForm">

	<input type="hidden" name="pageNum" id="pageNum" value="${pageNum}">

	<table border="1"  style="text-align: center;">

		<!-- 총 건수, 페이지 수 -->
		<tr>
			<td colspan="5"> 총 ${listCount}건 / ${totalPageCount}페이지
				<!-- 리스트 사이즈 -->
				<div style="float: right;">
					<select name="listsize" id="listsize" onchange="javascript:imgSearch();">
						<c:forEach var = "i" begin ="5" end ="20" step="5">
							<option value="${i}" <c:if test="${listsize eq i}"> selected="selected" </c:if> >${i}페이지</option>
						</c:forEach>
					</select>
				</div>
			</td>
		</tr>

		<tr style="text-align: center;">
			<td width="50px">번호</td>
			<td width="200px">제목</td>
			<td width="50px">글쓴이</td>
			<td width="100px">날짜</td>
			<td width="50px">조회</td>
		</tr>

		<!-- 등록 된 게시물이 없을 때 -->
		<c:if test="${totalPageCount == 0}">
		<tr>
			<td colspan="5">
				등록 된 게시물이 없습니다.	
			</td>
		</tr>
		</c:if>

		<!-- 등록 된 게시물이 있을 때 -->
		<c:if test="${totalPageCount > 0}">
			<c:forEach items="${imgList}" var="imgList">
			<tr>
				<td>${imgList.IMG_SN}</td>
				<td>
					<a href="javascript:imgDetail('${imgList.IMG_SN}');">${imgList.IMG_TITLE}</a>
				</td>
				<td>${imgList.USER_ID}</td>
				<td>${imgList.REG_DT}</td>
				<td>${imgList.IMG_HIT}</td>
			</tr>	 
			</c:forEach>
			
			<!-- 페이징 -->
			<tr>
				<td colspan="5">
					<c:if test="${startPage > 10}">
						<a href="imgSetPageNum('${startPage-1}');">◀</a>
					</c:if>
					<c:forEach var="pageno" begin="${startPage}" end="${endPage}">
						<!-- 현재 페이지 맞음-->
						<c:if test="${pageNum eq pageno}">
							[${pageno}]
						</c:if>
						
						<!-- 현재 페이지 아님 -->
						<c:if test="${pageNum ne pageno}">
							<a href="javascript:imgSetPageNum('${pageno}');">[${pageno}]</a>
						</c:if>
					</c:forEach>
					<c:if test="${endPage < totalPage}">
						<a href="javascript:imgSetPageNum('${endPage+1}');">▶</a>
					</c:if>
				</td>
			</tr>
		</c:if>

		<tr>
			<td colspan="5" align="right">
				<!-- 검색 조건 -->
				<select name="searchType" id="searchType" value="${searchType}">
					<option value="listNum" <c:if test="${searchType eq 'listNum'} || ${empty searchType}"> selected="selected" </c:if>>글번호</option>
					<option value="writeName" <c:if test="${searchType eq 'writeName'}"> selected="selected" </c:if>>작성자</option>
					<option value="titlecontent" <c:if test="${searchType eq 'titlecontent'}"> selected="selected" </c:if>>제목  + 내용</option>
				</select>
				<!-- 검색 값 -->
				<input type="text" name="searchValue" value="${searchValue}">
				<input type="button" value="조회" onclick="javascript:imgSearch();">
			</td>
		</tr>

		<!-- 글쓰기(관리자) -->
		<c:if test="${not empty sessionScope.user_auth}">
			<tr>
				<td colspan="5" align="right">
					<a href="javascript:imgWrite();">글쓰기</a>
				</td>
			</tr>
		</c:if>
		
	</table>
</form>
</center>
<br><br>
</body>
</html>
