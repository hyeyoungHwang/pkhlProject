<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PKHL</title>
</head>
<body>
	<section class="callaction">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="big-cta">
						<div class="cta-text">
							<h2><span>공지사항</h2>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<center>  
	<br/><br/>

	<form name="ntcWriteForm" id="ntcWriteForm" action="ntcInsert.a3" method="post">
		<table>
			<tr>
				<td>작성자</td><td>${sessionScope.user_id}</td>
			</tr>
			<tr>
				<td>제목</td><td><input type="text" name="ntc_title" size="55"></td>
			</tr>
			<tr>
				<td>내용</td><td><textarea name="ntc_content" rows="10" cols="55"></textarea></td>
			</tr>
		</table>
		<br/>
		<input type="button" value="입력" onclick="ntcInsertCheck()">
		<input type="button" value="목록" onclick="ntcList('ntcWriteForm')">
	</form>	
	</center>
	<br/><br/>
</body>
</html>