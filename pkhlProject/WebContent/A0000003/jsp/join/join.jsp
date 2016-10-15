<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>

<script type="text/javascript">
function joinCheck(){
	var form = document.joinForm;
	var ID = document.joinForm.user_id.value;
	var pwd = document.joinForm.user_pw.value;
	
	
	if(form.user_nm.value == "") {
		alert("이름을 입력해주세요.");
		form.user_nm.focus();
		return;
	}
	if(form.user_id.value == "") {
		alert("아이디을 입력해주세요.");
		form.user_id.focus();
		return;
	}
	if(ID.length < 4 || ID.length >= 11) {
		alert("아이디는 4~10자 이내입니다");
		form.user_id.focus();
		return;
	}
	if(form.user_pw.value == "") {
		alert("비밀번호을 입력해주세요.");
		form.user_pw.focus();
		return;
	}
	if(form.user_pw2.value == "") {
		alert("비밀번호를 확인해주세요.");
		form.user_pw2.focus();
		return;
	}
	if(pwd.length < 4 || pwd.length >= 11) {
		alert("비밀번호는 4~10자 이내입니다");
		form.user_pw.focus();
		return;
	}
	if(form.user_tel.value == "") {
		alert("전화번호를 입력해주세요.");
		form.user_tel.focus();
		return;
	}
	if(form.user_phone.value == "") {
		alert("핸드폰번호를 입력해주세요.");
		form.user_phone.focus();
		return;
	}
	if(form.user_email.value == "") {
		alert("이메일을 입력해주세요");
		form.user_email.focus();
		return;
	}
	if(form.addr.value == "" ) {
		alert("주소를 입력해주세요");
		form.addr.focus();
		return;
	}
	if(form.detail_addr.value == "") {
		alert("상세주소를 입력해주세요.");
		form.detail_addr.focus();
		return;
	}
	
	//비밀번호와 비밀번호확인의 값이 다를 경우
	if(form.user_pw.value != document.joinForm.user_pw2.value) {
		alert("입력한 2개의 비밀번호가 일치하지 않습니다.");
		form.user_pw2.focus();
		return;		
	}
	
	//전화번호와 핸드폰번호에 숫자가 아닌 값이 있을 경우
	if(isNaN(form.user_tel.value)) {
		alert("전화번호에 숫자가 아닌 값이 있습니다.확인해 주세요.");
		form.user_tel.focus();
		return;	
	}
	if(isNaN(form.user_phone.value)) {
		alert("핸드폰번호에 숫자가 아닌 값이 있습니다.확인해 주세요.");
		form.user_phone.focus();
		return;	
	}
	

	//alert("test");
	form.submit();
	//$("#listForm").attr({action:'qnaList.a1',method:'post'}).submit();
}

</script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullAddr = ''; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수

                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    fullAddr = data.roadAddress;

                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    fullAddr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                if(data.userSelectedType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('sample6_address').value = fullAddr;

                // 커서를 상세주소 필드로 이동한다.
                document.getElementById('sample6_address2').focus();
            }
        }).open();
    }
</script>
</head>
<body>
<div>
	회원가입
	<form name="joinForm" id="joinForm" action="joinAction.a3" method="post">
	이  름 : <input type="text" name="user_nm" size="20"><br/>
	아이디 : <input type="text" name="user_id" size="20"><br/>
	비밀번호 : <input type="password" name="user_pw" size="20">  비밀번호는 영문, 숫자 또는 영문+숫자를 조합하여 4~10자리까지 가능합니다. <br/>
	비밀번호 확인 : <input type="password" name="user_pw2" size="20"><br/>
	전화번호 : <input type="text" name="user_tel" size="11"><br/>
	핸드폰 :  <input type="text" name="user_phone" size="11"><br/>
	이메일 : 	<input type="text" name="user_email" size="30"><br/>
	주  소 : 
	<input type="text" name="zip"  id="sample6_postcode" size="6" placeholder="우편번호" ><br/>
	<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
	<input type="text" name="addr" id="sample6_address"  size="30" placeholder="주소"><br/>
	<input type="text" name="detail_addr"  id="sample6_address2" size="50" placeholder="상세주소"><br/>
	
	<!-- <input type="text" id="sample6_postcode" placeholder="우편번호">
	<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
	<input type="text" id="sample6_address" placeholder="주소">
	<input type="text" id="sample6_address2" placeholder="상세주소"> -->
	<span id="guide" style="color:#999"></span>
	
	
	<input type="button" value="회원가입" onclick="joinCheck()">
	<input type="reset" name="reset" value="다시입력" >
	</form>
</div>
	
</body>
</html>