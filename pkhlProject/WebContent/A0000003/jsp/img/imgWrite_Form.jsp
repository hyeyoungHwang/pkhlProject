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
							<h2><span>이미지 게시판</h2>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<center>  
	<br/><br/>

	<form name="imgWriteForm" id="imgWriteForm" action="imgInsert.a3" method="post" enctype="multipart/form-data" >
		<table>
			<tr>
				<td>작성자</td><td>${sessionScope.user_id}</td>
			</tr>
			<tr>
				<td>제목</td><td><input type="text" id="img_title" name="img_title" size="55"></td>
			</tr>
			<tr>
				<td>내용</td><td><textarea id="img_content" name="img_content" rows="10" cols="55"></textarea></td>
			</tr>
			<tr>
				<input type="file" name="img_file_nm">
			</tr>
		</table>
		<br/>
		<input type="button" value="입력" onclick="imgInsertCheck()">
		<input type="button" value="목록" onclick="imgList('imgWriteForm')">
	</form>	
	</center>
	<br/><br/>
</body>
</html>