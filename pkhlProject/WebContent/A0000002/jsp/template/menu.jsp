<%@ page language="java" contentType="text/html;" pageEncoding="utf-8"%>
<script>
function slide(obj){
	var ul = $(obj).parent().find("ul");
	$(ul).slideToggle();
}
function closeUl(){
	$("ul").css("display", "none");
}

function change(){
	
	var element = document.getElementById("bs-example-navbar-collapse-1"); 	
	if(element.style.display == "none"){
		element.style.display = "inline"; 
	}else{
		element.style.display = "none"
	}
	    
}


</script>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
$(function(){
    $(".submenu").hide();
    $(".left").click(function(){
        $(".submenu:visible").slideUp("middle");
        $(this).next('.submenu:hidden').slideDown("middle");
        return false;
    })
});

//html dom 이 다 로딩된 후 실행된다.
$(document).ready(function(){
 // memu 클래스 바로 하위에 있는 a 태그를 클릭했을때
 $(".nav_title").click(function(){
     // 현재 클릭한 태그가 a 이기 때문에
     // a 옆의 태그중 ul 태그에 hide 클래스 태그를 넣던지 빼던지 한다.
     var a =$(this).next(".somenu");
     if(a.css("display")=="none"){
     	a.removeClass("none");
     	a.css("display","block");
     } else {
     	a.removeClass("block");
     	a.css("display","none");
     }
 });
});

</script>

<div id="bg_line"></div>

<div id="header">
    	
    	
    	<div class="logo">
    		<h1><a href="index.a2"><img src="/A0000002/img/logo/logo_5.png" alt="archidom" /></a></h1>
    	</div>
    	
    	
    	
    	<div class="navigation" id="menu">
    		
    		<a href="#" class="nav_title">
    			ABOUT US
    			<div class="arr"></div>
    		</a>
			<ul class="somenu">
			<li><a href="intro.a2" title="Intro">Intro</a></li>
			<li><a href="greet.a2" title="Greetings">Greetings</a></li>
			<li><a href="archidom.a2" title="Archidom">Archidom</a></li>
			<li><a href="vision.a2" title="Mission & Vision">Mission & Vision</a></li>
			<li><a href="architecture.a2" title="Open Air Architecture">Open Air Architecture</a></li>
			<li><a href="cem.a2" title="C.E.M & C.M">C.E.M & C.M</a></li>
			<li><a href="construction.a2" title="Engineering & Construction">Engineering & Construction</a></li>
			<li><a href="future.a2" title="Future Expansion">Future Expansion</a></li>
			<li><a href="location.a2" title="location">location</a></li>
			
			
			
			</ul>		
		</div>



	<div class="navigation" id="menu_projects">
      		<a href="#" class="nav_title">
    			PROJECT
    			<div class="arr"></div>
    		</a>
			<ul class="somenu">
				<li><a href="projectall.a2" title="Project All">Project All</a></li>
				<li><a href="project2.a2" title="동천 래미안">동천 래미안</a></li>									
			</ul>
		</div>
    </div>    
    
    
    
    <div id="m_header">
    	
    	
    	<div class="m_logo">
    		<h1><a href="index.a2"><img src="/A0000002/img/logo/logo_5.png" alt="archidom" /></a></h1>
    	</div>
    	<br/>
    	
    	
    	<div class="m_navigation" id="menu">
    		
    		<a href="#" class="nav_title">
    			ABOUT US
    			<div class="arr"></div>
    		</a>
			<ul class="somenu">
			<li><a href="intro.a2" title="Intro">Intro</a></li>
			<li><a href="greet.a2" title="Greetings">Greetings</a></li>
			<li><a href="archidom.a2" title="Archidom">Archidom</a></li>
			<li><a href="vision.a2" title="Vision">Mission & Vision</a></li>
			<li><a href="architecture.a2" title="Architecture">Open Air Architecture</a></li>
			<li><a href="cem.a2" title="CEM">C.E.M & C.M</a></li>
			<li><a href="construction.a2" title="Construction">Engineering & Construction</a></li>
			<li><a href="future.a2" title="Future">Future Expansion</a></li>
			<li><a href="location.a2" title="What we do">location</a></li>
			
			
			
			</ul>		
		</div>



	<div class="m_navigation" id="menu_projects">
      		<a href="#" class="nav_title">
    			PROJECT
    			<div class="arr"></div>
    		</a>
			<ul class="somenu">
				<li><a href="projectall.a2">Project All</a></li>
				<li><a href="project2.a2">동천 래미안</a></li>									
			</ul>
		</div>
    </div>    