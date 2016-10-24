<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="ntcUpdateForm" id="ntcUpdateForm" action="ntcUpdate.a3">

	<input type="hidden" name="listsize" value="${listsize}">
	<input type="hidden" name="pageNum" value="${pageNum}">
	<input type="hidden" name="searchType" value="${searchType}">
	<input type="hidden" name="searchValue" value="${searchValue}">
	<input type="hidden" name="ntc_sn" value="${ntcDetail.ntc_sn}">

	<table border = "1">
		<tr>
			<td>번호</td><td>${ntcDetail.NTC_NUM}</td>
			<td>조회수</td><td>${ntcDetail.NTC_HIT}</td>
		</tr>
		<tr>
			<td colspan="2">작성자</td>
			<td colspan="2">${ntcDetail.USER_ID}</td>
		</tr>
		<tr>
			<td colspan="2">제목</td>
			<td colspan="2">
				<input type="text" name="ntc_title" value="${ntcDetail.NTC_TITLE}">
			</td>
		</tr>
		<tr>
			<td colspan="2">내용</td>
			<td colspan="2">
				<textarea name="ntc_content" rows="10" cols="55">${ntcDetail.NTC_CONTENT}</textarea>
			</td>
		</tr>
	</table>

	<input type="submit" value="수정완료">
	
	<input type="button" value="목록" onclick="javascript:ntcList('ntcUpdateForm');">

</form>
</body>
</html>