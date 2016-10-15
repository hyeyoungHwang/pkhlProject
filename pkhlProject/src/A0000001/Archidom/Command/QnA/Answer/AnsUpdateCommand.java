package A0000001.Archidom.Command.QnA.Answer;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import A0000001.Archidom.Command.A0000001Command;
import A0000001.Archidom.DAO.QnADAO;

public class AnsUpdateCommand implements A0000001Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
	      
	      Map<String, Object> paramMap = new HashMap<String, Object>();
	      
	      int qna_num = Integer.parseInt(request.getParameter("qna_num"));
	      int ans_num = Integer.parseInt(request.getParameter("ans_num"));
	      String admin_id= request.getParameter("admin_id");
	      String upd_ans_content = request.getParameter("upd_ans_content");
	      
	      
	      paramMap.put("qna_num", qna_num);
	      paramMap.put("ans_num", ans_num);
	      paramMap.put("admin_id", admin_id);
	      paramMap.put("upd_ans_content", upd_ans_content);
	      
	      
	      QnADAO qnaDao = new QnADAO();
	      
	      qnaDao.ansUpdate(paramMap);
	      
	      return "archidom/qnaDetail.a1";
	}

}
