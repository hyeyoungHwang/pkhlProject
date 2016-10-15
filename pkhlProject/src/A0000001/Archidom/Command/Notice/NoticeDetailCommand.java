package A0000001.Archidom.Command.Notice;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import A0000001.Archidom.Command.A0000001Command;
import A0000001.Archidom.DAO.NoticeDAO;

public class NoticeDetailCommand implements A0000001Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		NoticeDAO noticeDao = new NoticeDAO();
	      String viewpage = "";

	      if(request.getParameter("divisioncode") == null ||request.getParameter("divisioncode").equals("N")){
	         viewpage = "/A0000001/jsp/notice/noticeDetail.jsp";
	      }else if(request.getParameter("divisioncode").equals("U")){
	         viewpage = "/A0000001/jsp/notice/noticeUpdate_Form.jsp";
	      }
	      
	      
	      Map<String, Object> paramMap = new HashMap<String, Object>();
	      paramMap.put("notice_num", Integer.parseInt(request.getParameter("notice_num")));
	      
	      Map<String,Object> resultMap = noticeDao.noticeDetail(paramMap);
	      
	      request.setAttribute("noticeDetail", resultMap);
	      request.setAttribute("listsize", request.getParameter("listsize"));
	      request.setAttribute("pageNum", request.getParameter("pageNum"));
	      request.setAttribute("searchType", request.getParameter("searchType"));
	      request.setAttribute("searchValue", request.getParameter("searchValue"));
	      
	      return viewpage;
	}

}
