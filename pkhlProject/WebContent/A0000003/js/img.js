/* img 글쓰기 유효성 체크 */
function imgInsertCheck(){
   var img_title = document.getElementById("img_title");
   var img_content = document.getElementById("img_content");
   
   var imgWriteForm = document.getElementById("imgWriteForm");
   var input = document.createElement("input");
   
   if(img_title.value == ""){
      alert(" * 제목을 입력해주세요. ");
      return;
   }
   if(img_content.value == ""){
      alert(" * 내용을 입력해주세요. ");
      return;
   }
   
   document.imgWriteForm.submit();
}


// img 글쓰기
function imgWrite(){
	var viewpage = "/A0000003/jsp/img/imgWrite_Form.jsp";
	var input = $("<input>").attr("type", "hidden").attr("name", "viewpage").val(viewpage);
	$("#imgListForm").attr({action:'view.a3',method:'post'}).append($(input)).submit();
}

// img 검색 조회
function imgSearch(){
	$("#pageNum").val(1);
	$("#imgListForm").attr({action:'imgList.a3',method:'post'}).submit();
}

// img 페이지 전환
function imgSetPageNum(pageno){
	$("#pageNum").val(pageno);
	$("#imgListForm").attr({action:'imgList.a3',method:'post'}).submit();
}

// img 상세보기
function imgDetail(img_sn){
	var divisioncode = 'N';
	var input = $("<input>").attr("type", "hidden").attr("name", "img_sn").val(img_sn);
	var input2 = $("<input>").attr("type", "hidden").attr("name", "divisioncode").val(divisioncode);
	$("#imgListForm").attr({action:'imgDetail.a3',method:'post'}).append($(input)).append($(input2)).submit();
}

// img 수정페이지
function imgUpdateForm(img_sn){
	var divisioncode = 'U';
	var input = $("<input>").attr("type", "hidden").attr("name", "img_sn").val(img_sn);
	var input2 = $("<input>").attr("type", "hidden").attr("name", "divisioncode").val(divisioncode);
	$("#imgDetailForm").attr({action:'imgDetail.a3',method:'post'}).append($(input)).append($(input2)).submit();
}

// img 삭제
function imgDelete(img_sn){
	var input = $("<input>").attr("type", "hidden").attr("name", "img_sn").val(img_sn);
	$("#imgDetailForm").attr({action:'imgDelete.a3',method:'post'}).append($(input)).submit();
}

// img 목록이동
function imgList(formId){
	var form = "#" + formId;
	$(form).attr({action:'imgList.a3',method:'post'}).submit();
}