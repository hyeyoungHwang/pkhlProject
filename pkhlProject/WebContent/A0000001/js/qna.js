/* QnA 글쓰기 유효성 체크 */
function qnaInsertCheck(){
   var name = document.qnaWriteForm.qna_name.value;
   var pwd = document.qnaWriteForm.qna_pwd.value;
   var title = document.qnaWriteForm.qna_title.value;
   var content = document.qnaWriteForm.qna_content.value;
   
   if(name == ""){
      alert(" * 이름을 입력해주세요. ");
      return;
   }
   if(pwd == ""){
      alert(" * 비밀번호를 입력해주세요. ");
      return;
   }
   if(title == ""){
      alert(" * 제목을 입력해주세요. ");
      return;
   }
   if(content == ""){
      alert(" * 내용을 입력해주세요. ");
      return;
   }
   
   document.qnaWriteForm.submit();
}

// QnA 글쓰기
function qnaWrite(){
	var viewpage = "/A0000001/jsp/qna/qnaWrite_Form.jsp";
	var input = $("<input>").attr("type", "hidden").attr("name", "viewpage").val(viewpage);
	$("#listForm").attr({action:'view.a1',method:'post'}).append($(input)).submit();
}

function qnaWriteMain(){
	location.href="view.a1?viewpage=/A0000001/jsp/qna/qnaWrite_Form.jsp";
}
//QnA 검색 조회
function qnaSearch(){
	$("#pageNum").val(1);
	$("#listForm").attr({action:'qnaList.a1',method:'post'}).submit();
}

//QnA 페이지 전환
function qnaSetPageNum(pageno){
	$("#pageNum").val(pageno);
	$("#listForm").attr({action:'qnaList.a1',method:'post'}).submit();
}

// QnA 비밀글상세
function qnaDetailPrivate(qna_num){
	var viewpage = "/A0000001/jsp/qna/qnaUserCheck.jsp";
	var successpage = "archidom/qnaDetail.a1";
	var input = $("<input>").attr("type", "hidden").attr("name", "viewpage").val(viewpage);
	var input2 = $("<input>").attr("type", "hidden").attr("name", "successpage").val(successpage);
	var input3 = $("<input>").attr("type", "hidden").attr("name", "qna_num").val(qna_num);
	
	$("#listForm").attr({action:'view.a1',method:'post'}).append($(input)).append($(input2)).append($(input3)).submit();
}

// QnA 공개글상세
function qnaDetailPublic(qna_num){
	var input = $("<input>").attr("type", "hidden").attr("name", "qna_num").val(qna_num);
	$("#listForm").attr({action:'qnaDetail.a1',method:'post'}).append($(input)).submit();
}

// QnA 수정페이지
function qnaUpdateForm(){
	var viewpage = "/A0000001/jsp/qna/qnaUserCheck.jsp";
	var successpage = "archidom/qnaDetail.a1";
	var divisioncode = "U";
	var input = $("<input>").attr("type", "hidden").attr("name", "viewpage").val(viewpage);
	var input2 = $("<input>").attr("type", "hidden").attr("name", "successpage").val(successpage);
	var input3 = $("<input>").attr("type", "hidden").attr("name", "divisioncode").val(divisioncode);

	$("#qnaDetailForm").attr({action:'view.a1',method:'post'}).append($(input)).append($(input2)).append($(input3)).submit();
}

// QnA 삭제
function qnaDelete(){
	var viewpage = "/A0000001/jsp/qna/qnaUserCheck.jsp";
	var successpage = "archidom/qnaDelete.a1";
	var input = $("<input>").attr("type", "hidden").attr("name", "viewpage").val(viewpage);
	var input2 = $("<input>").attr("type", "hidden").attr("name", "successpage").val(successpage);
	$("#qnaDetailForm").attr({action:'view.a1',method:'post'}).append($(input)).append($(input2)).submit();
}

// QnA 목록이동
function qnaList(formId){
	var form = "#" + formId;
	$(form).attr({action:'qnaList.a1',method:'post'}).submit();
}

//QnA 댓글작성
function ansWrite(){
	$("#qnaDetailForm").attr({action:'ansInsert.a1',method:'post'}).submit();
}


//QnA 댓글삭제
function ansDelete(ans_num){
	var qna_num = $("<input>").attr("type", "hidden").attr("name", "qna_num").val(qna_num);
	var ans_num = $("<input>").attr("type", "hidden").attr("name", "ans_num").val(ans_num);
	$("#qnaDetailForm").attr({action:'ansDelete.a1',method:'post'}).append($(qna_num)).append($(ans_num)).submit();
}

//QnA 댓글 수정폼
function ansUpdateForm(ans_content, ans_num){

	$("#before_upd_" + ans_num).css('display', 'none');
	$("#upd_form_" + ans_num).css('display', 'block');
	
	
	/*
	var html = '<textarea rows="5" cols="50" name="' + ans_num + '_ans_upd_form" id="' + ans_num + '_ans_upd_form">'
		 			+ ans_content 
		 	   + '</textarea><br>'
		 	   + '<a href="javascript:ansUpdate(' + ans_num + ');">수정</a>'
			   + '<a href="javascript:cancel(' + ans_content + ', ' + ans_num + ');">취소</a>';
	
	$("#span_" + ans_num).replaceWith(html);*/
	
}

//QnA 댓글 수정 취소
function cancel(ans_content, ans_num){
	$("#before_upd_" + ans_num).css('display', 'block');
	$("#upd_form_" + ans_num).css('display', 'none');
	
	/*var html = '<span id="span_"' + ans_num + '">'
					+ ans_content + '<br>'
					+ '<a href="javascript:ansUpdateForm(\"' + ans_content + '\",' + ans_num + ');">수정</a>'
					+ '<a href="javascript:ansDelete(' + ans_num + ');">삭제</a>'
			+ '</span>';

	$("#" + ans_num + "_ans_upd_form").replaceWith(html);*/
	
}

//QnA 댓글 수정
function ansUpdate(ans_num){
	var text = $("#upd_ans_content").val();
	alert("text " + text);
	var upd_ans_content = $("<input>").attr("type", "hidden").attr("name", "upd_ans_content").val(text);
	var ans_num = $("<input>").attr("type", "hidden").attr("name", "ans_num").val(ans_num);
	$("#qnaDetailForm").attr({action:'ansUpdate.a1',method:'post'}).append($(ans_num)).append($(upd_ans_content)).submit();
}


