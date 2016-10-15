<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../A0000001/css/swiper.min.css">

<title>PKHL</title>
<script type="text/javascript">
	
</script>
<style>
    body {
        background: #eee;
        font-family: Helvetica Neue, Helvetica, Arial, sans-serif;
        font-size: 14px;
        color:#000;
        margin: 0;
        padding: 0;
    }
    .swiper-container {
        width: 100%;
        height: 300px;
        margin: 20px auto;
    }
    .swiper-slide {
        text-align: center;
        font-size: 18px;
        background: #fff;
        
        /* Center slide text vertically */
        display: -webkit-box;
        display: -ms-flexbox;
        display: -webkit-flex;
        display: flex;
        -webkit-box-pack: center;
        -ms-flex-pack: center;
        -webkit-justify-content: center;
        justify-content: center;
        -webkit-box-align: center;
        -ms-flex-align: center;
        -webkit-align-items: center;
        align-items: center;
    }
    
.mainThumImage {

}
</style>
</head>
<body>

	<section id="featured">
	<!-- start slider -->
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
	<!-- Slider -->
        <div id="main-slider" class="flexslider">
            <ul class="slides">
	            <c:forEach items="${imageList }" var="list">
		            <li>
			         	<img src="/A0000001/img/slides/${list.AIB_IMAGE }" alt=""/>
			        </li>
		   		</c:forEach>  
            </ul>
        </div>
	<!-- end slider -->
			</div>
		</div>
	</div>	
	</section>
	
	<section class="callaction">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="big-cta">
					<div class="cta-text">
						<h2><span>Moderna</span> HTML Business Template</h2>
					</div>
				</div>
			</div>
		</div>
	</div>
	</section>
	
	<section id="content">
	<div class="container">
	
		<!-- 이미지 슬라이더 -->
		<div class="row">
			<div class="swiper-container">
		        <div class="swiper-wrapper">
		            <div class="swiper-slide"><img src="/A0000001/img/1.jpg" class="mainThumImage" /></div>
		            <div class="swiper-slide"><img src="/A0000001/img/2.jpg" class="mainThumImage" /></div>
		            <div class="swiper-slide"><img src="/A0000001/img/3.jpg" class="mainThumImage" /></div>
		            <div class="swiper-slide"><img src="/A0000001/img/4.jpg" class="mainThumImage" /></div>
		            <div class="swiper-slide"><img src="/A0000001/img/5.jpg" class="mainThumImage" /></div>
		        </div>
		        <!-- Add Pagination -->
		        <div class="swiper-pagination"></div>
		    </div>
		</div>
		<!-- 이미지슬라이더 끝 -->
		
		<div class="row">
			<div class="col-lg-12">
				<div class="row">
					<div class="col-lg-3">
						<div class="box">
							<div class="box-gray aligncenter">
								<h4>신청서 작성</h4>
								<div class="icon">
								<i class="fa fa-desktop fa-3x"></i>
								</div>
								<p>
								 Voluptatem accusantium doloremque laudantium sprea totam rem aperiam.
								</p>
									
							</div>
							<div class="box-bottom">
								<a href="javascript:qnaWriteMain();">작성하러 가기</a>
							</div>
						</div>
					</div>
					<div class="col-lg-3">
						<div class="box">
							<div class="box-gray aligncenter">
								<h4>접수 및 미팅</h4>
								<div class="icon">
								<i class="fa fa-pagelines fa-3x"></i>
								</div>
								<p>
								 Voluptatem accusantium doloremque laudantium sprea totam rem aperiam.
								</p>
									
							</div>
							<div class="box-bottom">
								<a href="#">Learn more</a>
							</div>
						</div>
					</div>
					<div class="col-lg-3">
						<div class="box">
							<div class="box-gray aligncenter">
								<h4>인허가 신청</h4>
								<div class="icon">
								<i class="fa fa-edit fa-3x"></i>
								</div>
								<p>
								 Voluptatem accusantium doloremque laudantium sprea totam rem aperiam.
								</p>
									
							</div>
							<div class="box-bottom">
								<a href="#">Learn more</a>
							</div>
						</div>
					</div>
					<div class="col-lg-3">
						<div class="box">
							<div class="box-gray aligncenter">
								<h4>완료 및 통보</h4>
								<div class="icon">
								<i class="fa fa-code fa-3x"></i>
								</div>
								<p>
								 Voluptatem accusantium doloremque laudantium sprea totam rem aperiam.
								</p>
									
							</div>
							<div class="box-bottom">
								<a href="#">Learn more</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- divider -->
		<div class="row">
			<div class="col-lg-12">
				<div class="solidline">
				</div>
			</div>
		</div>
		<!-- 중간 부분 -->
	</div>
	</section>
	
<script src="/A0000001/js/swiper.min.js"></script>	

<script>
    var swiper = new Swiper('.swiper-container', {
        pagination: '.swiper-pagination',
        slidesPerView: 3,
        paginationClickable: true,
        spaceBetween: 30,
        freeMode: true
    });
</script>




</body>
</html>