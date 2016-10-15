package A0000001.Archidom.Command.Notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import A0000001.Archidom.Command.A0000001Command;
import A0000001.Archidom.DAO.NoticeDAO;

public class NoticeListCommand implements A0000001Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		NoticeDAO noticeDao = new NoticeDAO();
	      Map<String, Object> paramMap = new HashMap<String, Object>();
	      
	      String searchType = request.getParameter("searchType");      // �Ķ���ͷ� �Ѿ�� ����Ʈ �˻�Ÿ��
	      String searchValue = request.getParameter("searchValue");   // �Ķ���ͷ� �Ѿ�� ����Ʈ �˻� ��
	      String requestPageString = request.getParameter("pageNum");   // �Ķ���ͷ� �Ѿ�� ���� ��������ȣ
	      String requestListSize = request.getParameter("listsize");   // �Ķ���ͷ� �Ѿ�� ������ ������
	      int requestPageNumber = 1;   // �⺻ ������ ��ȣ
	      int listsize = 10;         // �⺻ ������ ����Ʈ ������
	      
	      /* �Ķ���ͷ� �������� �Ѿ�� �� ���� (requestPageString) */
	      if(requestPageString != null && requestPageString.length() > 0){
	         requestPageNumber = Integer.parseInt(requestPageString);
	      }
	      
	      /* �Ķ���ͷ� ������ ����� �Ѿ�� �� ���� (requestListSize) */
	      if(requestListSize !=null && requestListSize.length() > 0){
	         listsize= Integer.parseInt(requestListSize);
	      }
	      
	      paramMap.put("searchType", searchType);
	      paramMap.put("searchValue", searchValue);

	      /* Notice ����Ʈ �� �Ǽ� */
	      int listCount = noticeDao.selectCount(paramMap);
	      int totalPageCount = calculateTotalPageCount(listCount, listsize);
	      int startRow = (requestPageNumber - 1) * listsize;
	      
	      paramMap.put("startRow", startRow);
	      paramMap.put("listsize", listsize);

	      /* Notice ����Ʈ ��ȸ */
	      List<Map<String,Object>> resultMap = noticeDao.noticeList(paramMap);
	      
	      request.setAttribute("noticeList", resultMap);         // �ѷ��� ����Ʈ ��
	      request.setAttribute("totalPage", totalPageCount);   // ��ü ������ ��
	      request.setAttribute("listCount", listCount);      // ����Ʈ �� �Ǽ�
	      request.setAttribute("listsize", listsize);         // ������ ����Ʈ ������
	      request.setAttribute("searchType", searchType);      // ������ �˻�Ÿ��
	      request.setAttribute("searchValue", searchValue);   // ������ �˻���
	      request.setAttribute("pageNum", requestPageNumber);   // ���� ������
	      
	      if(totalPageCount > 0){
	         int beginPageNumber = (requestPageNumber -1) / 10 * 10 + 1;
	         int endPageNumber = beginPageNumber + 9;
	         if(endPageNumber > totalPageCount){
	            endPageNumber = totalPageCount;
	         }
	         request.setAttribute("startPage", beginPageNumber);   // ���� ������ ��ȣ
	         request.setAttribute("endPage", endPageNumber);      // �� ������ ��ȣ
	      }
	      
	      return "/A0000001/jsp/notice/noticeList.jsp";
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
