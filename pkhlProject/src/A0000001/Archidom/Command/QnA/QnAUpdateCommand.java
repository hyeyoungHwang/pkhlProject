package A0000001.Archidom.Command.QnA;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import A0000001.Archidom.Command.A0000001Command;
import A0000001.Archidom.DAO.QnADAO;

public class QnAUpdateCommand implements A0000001Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
	      
	      QnADAO qnaDao = new QnADAO();
	      Map<String, Object> paramMap = new HashMap<String, Object>();
	      paramMap.put("qna_num",request.getParameter("qna_num"));
	      paramMap.put("qna_name", request.getParameter("qna_name"));
	      paramMap.put("qna_title",request.getParameter("qna_title"));
	      paramMap.put("qna_content",request.getParameter("qna_content"));
	      
	      qnaDao.qnaUpdate(paramMap);
	      
	      return "archidom/qnaDetail.a1";
	}

}
