package A0000001.Archidom.Command.QnA.Answer;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import A0000001.Archidom.Command.A0000001Command;
import A0000001.Archidom.DAO.QnADAO;

public class AnsDeleteCommand implements A0000001Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
	      
	      QnADAO qnaDao = new QnADAO();
	      Map<String, Object> paramMap = new HashMap<String, Object>();
	      
	      paramMap.put("qna_num", request.getParameter("qna_num"));
	      paramMap.put("ans_num", request.getParameter("ans_num"));
	      qnaDao.ansDelete(paramMap);
	      
	      request.setAttribute("listsize", request.getParameter("listsize"));
	      request.setAttribute("pageNum", request.getParameter("pageNum"));
	      request.setAttribute("searchType", request.getParameter("searchType"));
	      request.setAttribute("searchValue", request.getParameter("searchValue"));
	      String viewpage = "archidom/qnaDetail.a1";
	      return viewpage;
	}

}
