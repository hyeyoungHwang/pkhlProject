<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="../A0000001/js/qna.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PKHL</title>
</head>
<body>
<section class="callaction">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="big-cta">
					<div class="cta-text">
						<h2><span>상세내용</span></h2>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<br><br>
<center>
	<form id="qnaDetailForm">
		<input type="hidden" name="qna_num" id="qna_num" value="${qnaDetail.QNA_NUM}">
		<input type="hidden" name="listsize" value="${listsize}">
		<input type="hidden" name="pageNum" value="${pageNum}">
		<input type="hidden" name="searchType" value="${searchType}">
		<input type="hidden" name="searchValue" value="${searchValue}">
		<input type="hidden" name="admin_id" value="${sessionScope.admin_id}">
	
		
		<table border = "2">
			<tr style="text-align: center;">
				<td width="100px">번호</td>
				<td width="30px">${qnaDetail.QNA_NUM}</td>
				<td width="200px"></td>
				<td width="100px">조회수</td>
				<td width="30px">${qnaDetail.QNA_HIT}</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;">작성자</td>
				<td colspan="3">${qnaDetail.QNA_NAME}</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;">제목</td>
				<td colspan="3">${qnaDetail.QNA_TITLE}</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align:center; height:300px ;">내용</td>
				<td colspan="3" height="300px">${qnaDetail.QNA_CONTENT}</td>
			</tr>
		</table><br><br>
		
		<input type="button" value="수정" onclick="javascript:qnaUpdateForm();">
		<input type="button" value="목록" onclick="javascript:qnaList('qnaDetailForm');">
		<input type="button" value="삭제" onclick="javascript:qnaDelete();">
		
		
		
		<h3>댓글 리스트</h3><br>
		<c:if test="${ansList == null}">
			<table border="1">
				<tr>
					<td>등록된 댓글이 없습니다.</td>
				</tr>
			</table>
		</c:if>
		<c:if test="${ansList != null}">
			<c:forEach items="${ansList}" var="ansList">
				<!-- ANS_NUM, QNA_NUM, ANS_CONTENT, REG_ID, REG_DT, UPD_ID, UPD_DT -->
				<div>
					<c:if test="${sessionScope.admin_id != ansList.REG_ID}">
						<span align="left">댓글번호 : ${ansList.ANS_NUM}</span>
						<span align="right">
							등록 : ${ansList.REG_ID} ( ${ansList.REG_DT} )
							수정 : ${ansList.UPD_ID} ( ${ansList.UPD_DT} )
						</span><br>
							내용 : ${ansList.ANS_CONTENT}<br>
					</c:if>
					
						
					<c:if test="${sessionScope.admin_id == ansList.REG_ID}">
					
						<span align="left">댓글번호 : ${ansList.ANS_NUM}</span>
						<span align="right">
							등록 : ${ansList.REG_ID} ( ${ansList.REG_DT} )
							수정 : ${ansList.UPD_ID} ( ${ansList.UPD_DT} )
						</span><br>
						
						<span id="before_upd_${ansList.ANS_NUM}">
							${ansList.ANS_CONTENT}<br>
							<a href="javascript:ansUpdateForm('${ansList.ANS_CONTENT}', '${ansList.ANS_NUM}');">수정</a> 	
							<a href="javascript:ansDelete('${ansList.ANS_NUM}');">삭제</a>
						</span>
						
						<span id="upd_form_${ansList.ANS_NUM}" style="display : none;">
							<textarea cols="50" rows="5" id="upd_ans_content" style="text-align: left;" >${ansList.ANS_CONTENT}</textarea>
							<br>
							<a href="javascript:ansUpdate('${ansList.ANS_NUM}');">수정완료</a> 	
							<a href="javascript:cancel('${ansList.ANS_CONTENT}', '${ansList.ANS_NUM}');">수정취소</a>
						</span>
						
						
					</c:if>
					
				</div>
			</c:forEach>
		</c:if>
		<br><br>
		
		<c:if test="${not empty sessionScope.admin_id}">
			<textarea name="ans_content" rows="5" cols="50" id="ans_content"></textarea>
			<a href="javascript:ansWrite();">댓글작성</a>
		</c:if>
	</form>
</center>
</body>
</html>