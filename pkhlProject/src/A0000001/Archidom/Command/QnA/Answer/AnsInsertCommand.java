package A0000001.Archidom.Command.QnA.Answer;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import A0000001.Archidom.Command.A0000001Command;
import A0000001.Archidom.DAO.QnADAO;

public class AnsInsertCommand implements A0000001Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
	      
	      Map<String, Object> paramMap = new HashMap<String, Object>();
	      
	      int qna_num = Integer.parseInt(request.getParameter("qna_num"));
	      String admin_id = request.getParameter("admin_id");
	      String ans_content = request.getParameter("ans_content");
	      
	      paramMap.put("qna_num", qna_num);
	      paramMap.put("admin_id", admin_id);
	      paramMap.put("ans_content", ans_content);
	      
	      
	      QnADAO qnaDao = new QnADAO();
	      qnaDao.ansInsert(paramMap);
	      
	      return "archidom/qnaDetail.a1";
	}

}
