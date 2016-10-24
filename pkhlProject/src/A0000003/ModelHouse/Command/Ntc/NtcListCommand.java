package A0000003.ModelHouse.Command.Ntc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import A0000003.ModelHouse.Command.A0000003Command;
import A0000003.ModelHouse.DAO.NtcDAO;

public class NtcListCommand implements A0000003Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		
		NtcDAO ntcDao = new NtcDAO();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		int pageNum = 1;	// 기본 페이지 번호
		int listsize = 10;	// 기본 페이지 리스트 사이즈

		String searchType = request.getParameter("searchType");		// 검색타입
		String searchValue = request.getParameter("searchValue");	// 검색 값
		String requestPageString = request.getParameter("pageNum");	// 페이지 번호
		String requestListSize = request.getParameter("listsize");	// 페이지 리스트 사이즈

		/* 파라미터로 페이지 번호가 넘어올 때 수행 (requestPageString) */
		if(requestPageString != null && requestPageString.length() > 0){
			pageNum = Integer.parseInt(requestPageString);
		}

		/* 파라미터로 페이지 사이즈가 넘어올 때 수행 (requestListSize) */
		if(requestListSize !=null && requestListSize.length() > 0){
			listsize= Integer.parseInt(requestListSize);
		}

		paramMap.put("searchType", searchType);
		paramMap.put("searchValue", searchValue);
		paramMap.put("bsns_code", session.getAttribute("bsns_code"));

		/* Ntc 리스트 총 건수 */
		int listCount = ntcDao.ntcListCount(paramMap);
		/* 페이지 총 수 */
		int totalPageCount = calculateTotalPageCount(listCount, listsize);
		int startRow = (pageNum - 1) * listsize;

		paramMap.put("startRow", startRow);
		paramMap.put("listsize", listsize);

		/* Ntc 리스트 조회 */
		List<Map<String,Object>> resultMap = ntcDao.ntcList(paramMap);

		request.setAttribute("ntcList", resultMap);				// 리스트
		request.setAttribute("totalPageCount", totalPageCount);	// 총 페이지 수
		request.setAttribute("listCount", listCount);			// 리스트 총 건수
		request.setAttribute("listsize", listsize);				// 페이지 리스트 사이즈
		request.setAttribute("searchType", searchType);			// 페이지 검색 타입
		request.setAttribute("searchValue", searchValue);		// 페이지 검색 값
		request.setAttribute("pageNum", pageNum);				// 현재 페이지
		
		if(totalPageCount > 0){
			int beginPageNumber = (pageNum - 1) / 10 * 10 + 1;
			int endPageNumber = beginPageNumber + 9;
			if(endPageNumber > totalPageCount){
				endPageNumber = totalPageCount;
			}
			request.setAttribute("startPage", beginPageNumber);	// 시작 페이지 번호
			request.setAttribute("endPage", endPageNumber);		// 끝 페이지 번호
		}

		return "/A0000003/jsp/ntc/ntcList.jsp";
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