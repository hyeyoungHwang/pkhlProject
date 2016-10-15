<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
						<h2><span>비밀번호 Check</span></h2>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<br><br><br><br>
<center>
<form id="qnaUserCheckForm" action="qnaUserCheck.a1">
	<input type="hidden" name="listsize" value="${listsize}">
	<input type="hidden" name="pageNum" value="${pageNum}">
	<input type="hidden" name="searchType" value="${searchType}">
	<input type="hidden" name="searchValue" value="${searchValue}">
	<input type="hidden" name="qna_num" value="${qna_num}">
	<input type="hidden" name="successpage" value="${successpage}">
	<input type="hidden" name="divisioncode" value="${divisioncode}">
	
	비밀번호 확인 : <input type="password" name="qna_pwd">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="submit" value="확인">
	<a href="javascript:qnaList('qnaUserCheckForm');">이전</a>
</form>
</center>
<br/><br/><br/>
</body>
</html>