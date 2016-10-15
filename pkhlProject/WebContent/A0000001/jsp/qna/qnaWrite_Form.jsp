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
						<h2><span>글쓰기</h2>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<center>
<br><br>
<form name="qnaWriteForm" id="qnaWriteForm" action="qnaInsert.a1" method="post">
	<table>
		<tr>
			<td>작성자</td> <td><input type="text" name="qna_name" size="55"></td>
		</tr>
		<tr>
			<td>비밀번호</td><td><input type="password" name="qna_pwd" size="55"></td>
		</tr>
		
		<tr>
			<td>제목</td><td><input type="text" name="qna_title" size="55"></td>
		</tr>
		<tr>
			<td>내용</td><td><textarea name="qna_content" rows="10" cols="55"></textarea></td>
		</tr>
		<tr>
			<!--(기본-공개글) 체크 : 비밀글(N) / 비체크 : 공개글(Y) -->
			<td>비밀글</td> <td><input type="checkbox" name="qna_open_yn"> </td>
		</tr>
	</table>
	<input type="button" value="입력" onclick="qnaInsertCheck()">
	<input type="button" value="목록" onclick="qnaList('qnaWriteForm')">
</form>	
</center>
<br><br>
</body>
</html>