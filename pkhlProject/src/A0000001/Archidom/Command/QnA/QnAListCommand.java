package A0000001.Archidom.Command.QnA;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import A0000001.Archidom.Command.A0000001Command;
import A0000001.Archidom.DAO.QnADAO;

public class QnAListCommand implements A0000001Command {

	@Override
	   public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	      
	      QnADAO   qnaDao = new QnADAO();
	      Map<String, Object> paramMap = new HashMap<String, Object>();
	      
	      String searchType = request.getParameter("searchType");      // 파라미터로 넘어온 리스트 검색타입
	      String searchValue = request.getParameter("searchValue");   // 파라미터로 넘어온 리스트 검색 값
	      String requestPageString = request.getParameter("pageNum");   // 파라미터로 넘어온 현재 페이지번호
	      String requestListSize = request.getParameter("listsize");   // 파라미터로 넘어온 페이지 사이즈
	      int requestPageNumber = 1;   // 기본 페이지 번호
	      int listsize = 10;         // 기본 페이지 리스트 사이즈
	      
	      /* 파라미터로 페이지가 넘어올 때 수행 (requestPageString) */
	      if(requestPageString != null && requestPageString.length() > 0){
	         requestPageNumber = Integer.parseInt(requestPageString);
	      }
	      
	      /* 파라미터로 페이지 사이즈가 넘어올 때 수행 (requestListSize) */
	      if(requestListSize !=null && requestListSize.length() > 0){
	         listsize= Integer.parseInt(requestListSize);
	      }
	      
	      paramMap.put("searchType", searchType);
	      paramMap.put("searchValue", searchValue);

	      /* QnA 리스트 총 건수 */
	      int listCount = qnaDao.selectCount(paramMap);
	      int totalPageCount = calculateTotalPageCount(listCount, listsize);
	      int startRow = (requestPageNumber - 1) * listsize;
	      
	      paramMap.put("startRow", startRow);
	      paramMap.put("listsize", listsize);

	      /* QnA 리스트 조회 */
	      List<Map<String,Object>> resultMap = qnaDao.qnaList(paramMap);
	      
	      request.setAttribute("qnaList", resultMap);         // 뿌려줄 리스트 값
	      request.setAttribute("totalPage", totalPageCount);   // 전체 페이지 수
	      request.setAttribute("listCount", listCount);      // 리스트 총 건수
	      request.setAttribute("listsize", listsize);         // 페이지 리스트 사이즈
	      request.setAttribute("searchType", searchType);      // 페이지 검색타입
	      request.setAttribute("searchValue", searchValue);   // 페이지 검색값
	      request.setAttribute("pageNum", requestPageNumber);   // 현재 페이지
	      
	      if(totalPageCount > 0){
	         int beginPageNumber = (requestPageNumber -1) / 10 * 10 + 1;
	         int endPageNumber = beginPageNumber + 9;
	         if(endPageNumber > totalPageCount){
	            endPageNumber = totalPageCount;
	         }
	         request.setAttribute("startPage", beginPageNumber);   // 시작 페이지 번호
	         request.setAttribute("endPage", endPageNumber);      // 끝 페이지 번호
	      }
	      
	      return "/A0000001/jsp/qna/qnaList.jsp";
	   }
	   
	   public int calculateTotalPageCount(int listCount, int listsize){
	      if(listCount == 0){
	         return 0;
	      }
	      int pageCount = listCount / listsize;
	      if(listCount % listsize > 0){
	         pageCount++;
	      }
	      return pageCount;
	   }

}
