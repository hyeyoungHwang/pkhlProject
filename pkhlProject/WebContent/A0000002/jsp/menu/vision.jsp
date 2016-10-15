<%@ page language="java" contentType="text/html;" pageEncoding="utf-8"%>

<div id="primaryContent">
	<div id="page_1">
		<img src="/A0000002/img/page/page_04.jpg" alt="page4"/>		
	</div>
	<div id="mpage">
		<img src="/A0000002/img/mobile/m_page4.jpg" alt="page4" width="100%" />
	</div>	
</div>
<div id="wrap">
<div id="pageTxt" class="pageTxt"></div>
</div>
<script type="text/javascript">


	//Index init
	$("#wrap").height($(window).height());
	
	window.onresize = function(){		
		$("#wrap").height($(window).height());
	}
	
	var imgSize = $("#bg").children("img").size();
	var imgRandomNum = Math.floor(Math.random()*imgSize);
	
/* 	if (imgRandomNum == 1 || imgRandomNum == 2){
		$("#pageTxt").addClass("txtOnly")
	}   */
	$("#pageTxt").css('width',$(document).width());
	$("#pageTxt").show();
	$("#bg").children("img").eq(imgRandomNum).css("display","block");
	
	//$("#bg").children("img").eq(imgRandomNum).css("display","block");
	
	
</script>
