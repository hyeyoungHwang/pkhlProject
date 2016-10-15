package A0000001.Archidom.Command.Notice;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import A0000001.Archidom.Command.A0000001Command;
import A0000001.Archidom.DAO.NoticeDAO;

public class NoticeUpdateCommand implements A0000001Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
	      
	      NoticeDAO noticeDAO = new NoticeDAO();
	      Map<String, Object> paramMap = new HashMap<String, Object>();
	      paramMap.put("notice_num",request.getParameter("notice_num"));
	      paramMap.put("notice_title",request.getParameter("notice_title"));
	      paramMap.put("notice_content",request.getParameter("notice_content"));
	      
	      noticeDAO.noticeUpdate(paramMap);
	      return "archidom/noticeDetail.a1";
	}

}
