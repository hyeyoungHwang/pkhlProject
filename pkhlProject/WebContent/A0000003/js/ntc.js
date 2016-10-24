/* Ntc 글쓰기 유효성 체크 */
function ntcInsertCheck(){
   var ntc_title = document.ntcWriteForm.ntc_title.value;
   var ntc_content = document.ntcWriteForm.ntc_content.value;
   
   if(ntc_title == ""){
      alert(" * 제목을 입력해주세요. ");
      return;
   }
   if(ntc_content == ""){
      alert(" * 내용을 입력해주세요. ");
      return;
   }
   document.ntcWriteForm.submit();
}


// Ntc 글쓰기
function ntcWrite(){
	var viewpage = "/A0000003/jsp/ntc/ntcWrite_Form.jsp";
	var input = $("<input>").attr("type", "hidden").attr("name", "viewpage").val(viewpage);
	$("#ntcListForm").attr({action:'view.a3',method:'post'}).append($(input)).submit();
}

// Ntc 검색 조회
function ntcSearch(){
	$("#pageNum").val(1);
	$("#ntcListForm").attr({action:'ntcList.a3',method:'post'}).submit();
}

// Ntc 페이지 전환
function ntcSetPageNum(pageno){
	$("#pageNum").val(pageno);
	$("#ntcListForm").attr({action:'ntcList.a3',method:'post'}).submit();
}

// Ntc 상세보기
function ntcDetail(ntc_sn){
	var divisioncode = 'N';
	var input = $("<input>").attr("type", "hidden").attr("name", "ntc_sn").val(ntc_sn);
	var input2 = $("<input>").attr("type", "hidden").attr("name", "divisioncode").val(divisioncode);
	$("#ntcListForm").attr({action:'ntcDetail.a3',method:'post'}).append($(input)).append($(input2)).submit();
}

// Ntc 수정페이지
function ntcUpdateForm(ntc_sn){
	var divisioncode = 'U';
	var input = $("<input>").attr("type", "hidden").attr("name", "ntc_sn").val(ntc_sn);
	var input2 = $("<input>").attr("type", "hidden").attr("name", "divisioncode").val(divisioncode);
	$("#ntcDetailForm").attr({action:'ntcDetail.a3',method:'post'}).append($(input)).append($(input2)).submit();
}

// Ntc 삭제
function ntcDelete(ntc_sn){
	var input = $("<input>").attr("type", "hidden").attr("name", "ntc_sn").val(ntc_sn);
	$("#ntcDetailForm").attr({action:'ntcDelete.a3',method:'post'}).append($(input)).submit();
}

// Ntc 목록이동
function ntcList(formId){
	var form = "#" + formId;
	$(form).attr({action:'ntcList.a3',method:'post'}).submit();
}