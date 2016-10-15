<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>   
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메인이미지 등록</title>

</head>
<body>  
<section class="callaction">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="big-cta">
					<div class="cta-text">
						<h2><span>메인이미지등록</span></h2>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<br/><br/><br/><br/>
<center>
<form action = "adminImageInsert.a1" method="post" name="imageWrite" enctype="multipart/form-data" >
<input type="file" id="input_file" name="aiwImage"/><br>

<input type="submit" value="등록"/>
<input type="button" value="목록" onclick="document.location.href='adminImageList.a1'"/>

</form>
</center>
<br/><br/><br/>
</body>
</html>