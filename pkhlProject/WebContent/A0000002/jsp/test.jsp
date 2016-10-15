 <%@ page language="java" contentType="text/html;" pageEncoding="utf-8"%>

<script type="text/javascript">


</script>
<body class="indexBody">

  <div id="bg">  
    <img src="/A0000002/img/main/main_img.jpg" alt="" />	
  </div>


   <div id="bgTxt"></div>
   <div id="bg_line"></div>
   <div id="wrap">
   	<div id="primaryContent"></div>  
   </div>
   
</body>

 <script type="text/javascript">


	//Index init
	$("#wrap").height($(window).height());
	
	window.onresize = function(){		
		$("#wrap").height($(window).height());
	}
	
	var imgSize = $("#bg").children("img").size();
	var imgRandomNum = Math.floor(Math.random()*imgSize);
	
	if (imgRandomNum == 1 || imgRandomNum == 2){
		$("#bgTxt").addClass("txtOnly")
	}  
	$("#bgTxt").show();
	$("#bg").children("img").eq(imgRandomNum).css("display","block");
	
	//$("#bg").children("img").eq(imgRandomNum).css("display","block");
	
</script>


