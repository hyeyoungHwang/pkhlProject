package A0000001.Archidom.Command.QnA;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import A0000001.Archidom.Command.A0000001Command;
import A0000001.Archidom.DAO.QnADAO;

public class QnAInsertCommand implements A0000001Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
	      
	      /*(기본-공개글) 체크 : 비밀글(N) / 비체크 : 공개글(Y) */ 
	      String qna_open_yn = "Y";
	      
	      if(request.getParameter("qna_open_yn")!=null){
	         qna_open_yn = "N";
	      }
	      
	      QnADAO qnaDao = new QnADAO();
	      Map<String, Object> paramMap = new HashMap<String, Object>();
	      
	      paramMap.put("qna_name", request.getParameter("qna_name"));
	      paramMap.put("qna_title", request.getParameter("qna_title"));
	      paramMap.put("qna_content", request.getParameter("qna_content"));
	      paramMap.put("qna_pwd", request.getParameter("qna_pwd"));
	      paramMap.put("qna_open_yn", qna_open_yn);
	      
	      qnaDao.qnaInsert(paramMap);
	      
	      return "archidom/qnaList.a1";
	}

}
