<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>  
<script type="text/javascript">

function delImage(num, img) { 
	$("#num").val(num);
	$("#img").val(img);
	$("#adminImageForm").attr("action", "adminImageDelete.a1");
	$("#adminImageForm").submit();
}


function insertForm(){
	
 	$("#adminImageForm").attr("action", "adminImageInsertForm.a1");
	$("#adminImageForm").submit();
}


</script>
<section class="callaction">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="big-cta">
					<div class="cta-text">
						<h2><span>메인이미지관리</span></h2>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<br/><br/>
<center>
<form id="adminImageForm" name="adminImageForm" method="POST">
<input type="hidden" name="num" id="num" />
<input type="hidden" name="img" id="img" />

	<table>
		<c:forEach items="${imageList}" var="imageList">
			<tr>
				<td style="padding: 30px;">
					${imageList.AIB_IMAGE}
				</td>
				<td style="padding: 30px;">
					<img src="/A0000001/img/slides/${imageList.AIB_IMAGE}" style="width: 200px; height: 100px">
				</td>
				<td style="padding: 30px;">
					<input type="button" name="del" id="del" value="삭제" onclick="delImage('${imageList.AIB_NUM}', '${imageList.AIB_IMAGE}')" />
				</td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<input type="button" name="insertImage" id="insertImage" value="메인 이미지 등록" onclick="insertForm()"/>
	
	<br/><br/><br/>
</form>
</center>
</body>
</html>