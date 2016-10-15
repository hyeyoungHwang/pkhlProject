<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원약관동의</title>
<script type="text/javascript">
	function agree_ok(){
		form = document.agreeForm;
		
		if(form.check1.checked == false){
			alert("이용약관에 동의하셔야 회원가입이 가능합니다.");
			form.check1.focus();
			return;
		}
		else if(form.check2.checked == false){
			alert("개인정보처리 방침에 동의하셔야 회원가입이 가능합니다.");
			form.check2.focus();
			return;
		}
		else if(form.a1[0].checked == false){
			alert("개인정보 수집 및 이용에 동의하셔야 회원가입이 가능합니다.");
			form.a1[0].focus();
			return;
		}
		else if(form.a2[0].checked == false){
			alert("개인정보 수집 및 이용에 동의하셔야 회원가입이 가능합니다.");
			form.a2[0].focus();
			return;
		}
		else{
			form.ok.value='1';
			form.submit();
		}
		
	}
	
	function okChk(chk) {
		form = document.agreeForm;
		if(chk){
			form.a1[0].checked = true;
			form.a2[0].checked = true;
		}else{
			form.a1[1].checked = true;
			form.a2[1].checked = true;
		}
	}
</script>
</head>
<body>
<div width="100%">
<form name="agreeForm" id="agreeForm" action="join.a3" method="post">
<input type="hidden" name="ok" value=""/>
<table width="50%" border=1 align="center" >
<tr>
<td width="100%" height="50%" align="center" colspan="4">
<p align="left"><span style="padding-left:100px">이용약관(필수)</span>
<input type="checkbox" name="check1" value="Y"> 동의합니다</p>
<textarea rows="20" cols="150">
[제1장 총칙]
제1조 (목적)
이 약관은 제이케이하우징 (이) 운영하는 인터넷 사이트의 회원가입과 서비스 이용에 대한 이용자의 권리,
의무와 책임사항을 규정함을 목적으로 합니다.

제2조 (정의)

① 제이케이하우징 이란 회사가 재화나 용역을 이용자에게 제공하기 위하여 컴퓨터 등 정보통신 설비를 이용
하여 재화 또는 용역을 거래할 수 있도록 설정한 가상의 영업장과 사이트를 운영하는 사업자의 의미로도 사용합니다.
② '이용자'란 제이케이하우징에 접속하거나 방문하여 이 약관에 따로 제이케이하우징이 제공하는
서비스를 받는 회원과 비회원을 말합니다.
③ '회원'이라 함은 제이케이하우징에 개인정보를 제공하여 회원등록을 한 자로서, 제이케이하우징 분양의
정보를 지속적으로 제공받으며, 제이케이하우징이 제공하는 서비스를 계속적으로 이용할 수 있는 자를
말합니다.
④'비회원'이라 함은 회원에 가입하지 않고 제이케이하우징이 제공하는 서비스를 이용하는 자를 말합니다.


제3조 (약관의 명시와 개정)

① 제이케이하우징은 이 약관의 내용과 상호, 연락처(전화, 팩스, 전자우편 주소 등) 등을 이용자가 알 수 
있도록 사이트의 초기 서비스화면에 게시합니다.
② 제이케이하우징은 약관의규제등에관한법률, 전자거래기본법, 전자서명법, 정보통신망이용촉진등에 관한 법률,
방문판매등에 관한 법률, 소비자보호법 등 관련 법을 위배하지 않는 범위에서 이 약관을 개정할 수 있습니다.
③ 제이케이하우징이 약관을 개정할 경우에는 적용일자 및 개정사유를 명시하여 현행약관과 함께 사이트의
초기화면에 그 적용일자 7일 이전부터 적용일자 전일까지 공지합니다.
④ 제이케이하우징이 약관을 개정할 경우에는 그 개정약관은 그 적용일자 이후에 체결되는 계약에만 적용되고
그 이전에 이미 체결된 계약에 대해서는 개정전의 약관조항이 그대로 적용됩니다. 다만 이미 계약을 체결한 이용자가
개정약관 조항의 적용을 받기를 원하는 뜻을 제3항에 의한 개정약관의 공지기간내에 제이케이하우징에 송신하여
제이케이하우징의 동의를 받은 경우에는 개정약관조항이 적용됩니다.
⑤ 이 약관에서 정하지 아니한 사항과 이 약관의 해석에 관하여는 정부가 제정한 전자거래소비자 보호지침 및 관계 법령
또는 상관례에 따릅니다.


제4조 (서비스의 제공 및 변경)
① 제이케이하우징는 다음과 같은 서비스를 제공합니다.
재화 또는 상품에 대한 정보 제공 및 구매계약의 체결
구매계약이 체결된 재화 또는 상품의 배송
기타 제이케이하우징이 정하는 서비스
② 제이케이하우징은 재화의 품절 또는 기술적 사양의 변경 등의 경우에는 장차 체결되는 계약에 의해 제공할
재화·상품의 내용을 변경할 수 있습니다.
③ 제이케이하우징가 제공하기로 이용자와 계약을 체결한 서비스의 내용을 재화의 품절 또는 기술적 사양의
변경 등의 사유로 변경할 경우에는 제이케이하우징은 이로 인하여 이용자가 입은 손해를 배상하지 아니합니다.
단, 제이케이하우징에게 고의 또는 과실이 있는 경우에는 그러하지 아니합니다.


제5조 (서비스의 중단)
① 제이케이하우징은 컴퓨터 등 정보통신설비의 보수점검, 교체 및 고장, 통신의 두절 등의 사유가 발생한 경우
에는 서비스의 제공을 일시적으로 중단할 수 있습니다.
② 제1항에 의한 서비스 중단의 경우에는 제이케이하우징은 제8조에 정한 방법으로 이용자에게 통지합니다.
③ 제이케이하우징은 제1항의 사유로 서비스의 제공이 일시적으로 중단됨으로 인하여 이용자 또는 제3자가
입은 손해에 대해서 배상하지 아니합니다. 단 제이케이하우징에게 고의 또는 과실이 있는 경우에는 그러하지
아니합니다.

[제2장 회원가입계약]

</textarea><br/>
</td>
</tr>
<tr>
<td width="100%" height="50%" align="center" colspan="4">
<p align="left"><span style="padding-left:100px">개인정보처리방침(필수)</span><input type="checkbox" name="check2" value="Y"> 동의합니다</p>
<textarea rows="20" cols="150">

1. 개인정보의 처리 목적
제이케이하우징은(는) 다음의 목적을 위하여 개인정보를 처리하고 있으며, 다음의 목적 이외이 용도로는 이용
하지 않습니다.
- 고객 가입의사 확인, 고객에 대한 서비스 제공에 따른 본인 식별·인증, 회원자격 유지·관리, 물품 또는 서비스 공급에
따른 금액 결제, 물품 도는 서비스의 공급·배송 등

2. 개인정보의 처리 및 보유 기간

</textarea><br/>

</td>
</tr>
<tr>
<td width="100%" height="50%" align="center" colspan="4">
<p align="left"><span style="padding-left:100px">개인정보 수집, 이용동의 (필수)</span><input type="checkbox" name="check3" value="Y" onClick="okChk(this.checked);"> 모두 동의합니다</p>
</td>
</tr>
<tr>
<td>목적</td>
<td>항목</td>
<td>보유기간</td>
<td>동의여부</td>
</tr>
<tr>
<td>이용자 식별 및 서비스 기본정보<br/>
이용자 가입유형 및 형태분석
</td>
<td>
로그인ID, 비밀번호, 전화번호, 휴대전화번호, 이메일,<br/>
주소, 서비스 이용기록, 결제기록
</td>
<td>회원 탈퇴 시</td>
<td>
<input type="radio" name="a1" value="" > 동의
<input type="radio" name="a1" value="" checked=""> 미동의
</td>
</tr>
<tr>
<td>불량회원 부정이용 방지</td>
<td>접속 IP</td>
<td>이용해지일로부터 1년</td>
<td>
<input type="radio" name="a2" value=""> 동의
<input type="radio" name="a2" value="" checked=""> 미동의
</td>
</tr>
<tr>
<td colspan="4" align="center">
</td>
</tr>
<tr>
<td colspan="4"><a href="javascript:agree_ok();">회원가입</a></td>
</tr>
</table>
</form>
</div>
</body>
</html>