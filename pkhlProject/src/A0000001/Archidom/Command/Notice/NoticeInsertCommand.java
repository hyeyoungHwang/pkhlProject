package A0000001.Archidom.Command.Notice;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import A0000001.Archidom.Command.A0000001Command;
import A0000001.Archidom.DAO.NoticeDAO;

public class NoticeInsertCommand implements A0000001Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
	      
	      NoticeDAO noticeDao = new NoticeDAO();
	      Map<String, Object> paramMap = new HashMap<String, Object>();
	      HttpSession session = request.getSession();
	      
	      
	      paramMap.put("admin_id", session.getAttribute("admin_id"));
	      paramMap.put("admin_pw", session.getAttribute("admin_pw"));
	      paramMap.put("notice_title", request.getParameter("notice_title"));
	      paramMap.put("notice_content", request.getParameter("notice_content"));
	      
	      noticeDao.noticeInsert(paramMap);
	      
	      return "archidom/noticeList.a1";
	}

}
