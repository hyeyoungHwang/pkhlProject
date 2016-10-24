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
		
		int pageNum = 1;	// �⺻ ������ ��ȣ
		int listsize = 10;	// �⺻ ������ ����Ʈ ������

		String searchType = request.getParameter("searchType");		// �˻�Ÿ��
		String searchValue = request.getParameter("searchValue");	// �˻� ��
		String requestPageString = request.getParameter("pageNum");	// ������ ��ȣ
		String requestListSize = request.getParameter("listsize");	// ������ ����Ʈ ������

		/* �Ķ���ͷ� ������ ��ȣ�� �Ѿ�� �� ���� (requestPageString) */
		if(requestPageString != null && requestPageString.length() > 0){
			pageNum = Integer.parseInt(requestPageString);
		}

		/* �Ķ���ͷ� ������ ����� �Ѿ�� �� ���� (requestListSize) */
		if(requestListSize !=null && requestListSize.length() > 0){
			listsize= Integer.parseInt(requestListSize);
		}

		paramMap.put("searchType", searchType);
		paramMap.put("searchValue", searchValue);
		paramMap.put("bsns_code", session.getAttribute("bsns_code"));

		/* Ntc ����Ʈ �� �Ǽ� */
		int listCount = ntcDao.ntcListCount(paramMap);
		/* ������ �� �� */
		int totalPageCount = calculateTotalPageCount(listCount, listsize);
		int startRow = (pageNum - 1) * listsize;

		paramMap.put("startRow", startRow);
		paramMap.put("listsize", listsize);

		/* Ntc ����Ʈ ��ȸ */
		List<Map<String,Object>> resultMap = ntcDao.ntcList(paramMap);

		request.setAttribute("ntcList", resultMap);				// ����Ʈ
		request.setAttribute("totalPageCount", totalPageCount);	// �� ������ ��
		request.setAttribute("listCount", listCount);			// ����Ʈ �� �Ǽ�
		request.setAttribute("listsize", listsize);				// ������ ����Ʈ ������
		request.setAttribute("searchType", searchType);			// ������ �˻� Ÿ��
		request.setAttribute("searchValue", searchValue);		// ������ �˻� ��
		request.setAttribute("pageNum", pageNum);				// ���� ������
		
		if(totalPageCount > 0){
			int beginPageNumber = (pageNum - 1) / 10 * 10 + 1;
			int endPageNumber = beginPageNumber + 9;
			if(endPageNumber > totalPageCount){
				endPageNumber = totalPageCount;
			}
			request.setAttribute("startPage", beginPageNumber);	// ���� ������ ��ȣ
			request.setAttribute("endPage", endPageNumber);		// �� ������ ��ȣ
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