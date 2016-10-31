<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PKHL</title>
</head>
<body>
	<form name="imgUpdateForm" id="imgUpdateForm" action="imgUpdate.a3">

	<input type="hidden" name="listsize" value="${listsize}">
	<input type="hidden" name="pageNum" value="${pageNum}">
	<input type="hidden" name="searchType" value="${searchType}">
	<input type="hidden" name="searchValue" value="${searchValue}">
	<input type="hidden" name="img_sn" value="${imgDetail.IMG_SN}">

	<table border = "1">
		<tr>
			<td>번호</td><td>${imgDetail.IMG_SN}</td>
			<td>조회수</td><td>${imgDetail.IMG_HIT}</td>
		</tr>
		<tr>
			<td colspan="2">작성자</td>
			<td colspan="2">${imgDetail.USER_ID}</td>
		</tr>
		<tr>
			<td colspan="2">제목</td>
			<td colspan="2">
				<input type="text" name="img_title" value="${imgDetail.IMG_TITLE}">
			</td>
		</tr>
		<tr>
			<td colspan="2">내용</td>
			<td colspan="2">
				<textarea name="img_content" rows="10" cols="55">${imgDetail.IMG_CONTENT}</textarea>
			</td>
		</tr>
	</table>

	<input type="submit" value="수정완료">
	
	<input type="button" value="목록" onclick="javascript:imgList('imgUpdateForm');">

</form>
</body>
</html>