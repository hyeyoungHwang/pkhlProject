/* Notice 글쓰기 유효성 체크 */
function noticeInsertCheck(){
   var notice_title = document.noticeWriteForm.notice_title.value;
   var notice_content = document.noticeWriteForm.notice_content.value;
   
   if(notice_title == ""){
      alert(" * 제목을 입력해주세요. ");
      return;
   }
   if(notice_content == ""){
      alert(" * 내용을 입력해주세요. ");
      return;
   }
   document.noticeWriteForm.submit();
}

// Notice 글쓰기
function noticeWrite(){
	var viewpage = "/A0000001/jsp/notice/noticeWrite_Form.jsp";
	var input = $("<input>").attr("type", "hidden").attr("name", "viewpage").val(viewpage);
	$("#noticeListForm").attr({action:'view.a1',method:'post'}).append($(input)).submit();
}

//Notice 검색 조회
function noticeSearch(){
	$("#pageNum").val(1);
	$("#noticeListForm").attr({action:'noticeList.a1',method:'post'}).submit();
}

//Notice 페이지 전환
function noticeSetPageNum(pageno){
	$("#pageNum").val(pageno);
	$("#noticeListForm").attr({action:'noticeList.a1',method:'post'}).submit();
}

// Notice 상세보기
function noticeDetail(notice_num){
	var divisioncode = 'N';
	var input = $("<input>").attr("type", "hidden").attr("name", "notice_num").val(notice_num);
	var input2 = $("<input>").attr("type", "hidden").attr("name", "divisioncode").val(divisioncode);
	$("#noticeListForm").attr({action:'noticeDetail.a1',method:'post'}).append($(input)).append($(input2)).submit();
}

// Notice 수정페이지
function noticeUpdateForm(notice_num){
	var divisioncode = 'U';
	var input = $("<input>").attr("type", "hidden").attr("name", "notice_num").val(notice_num);
	var input2 = $("<input>").attr("type", "hidden").attr("name", "divisioncode").val(divisioncode);
	$("#noticeDetailForm").attr({action:'noticeDetail.a1',method:'post'}).append($(input)).append($(input2)).submit();
}

// Notice 삭제
function noticeDelete(notice_num){
	var input = $("<input>").attr("type", "hidden").attr("name", "notice_num").val(notice_num);
	$("#noticeDetailForm").attr({action:'noticeDelete.a1',method:'post'}).append($(input)).submit();
}

// Notice 목록이동
function noticeList(formId){
	var form = "#" + formId;
	$(form).attr({action:'noticeList.a1',method:'post'}).submit();
}

