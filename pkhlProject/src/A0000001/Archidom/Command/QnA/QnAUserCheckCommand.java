package A0000001.Archidom.Command.QnA;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import A0000001.Archidom.Command.A0000001Command;
import A0000001.Archidom.DAO.QnADAO;

public class QnAUserCheckCommand implements A0000001Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		QnADAO qnaDao = new QnADAO();
	      Map<String, Object> paramMap = new HashMap<String, Object>();
	      String viewPage = null;
	      
	      paramMap.put("qna_num", request.getParameter("qna_num"));
	      paramMap.put("qna_pwd", request.getParameter("qna_pwd"));
	      
	      int userCheckCnt = qnaDao.qnaUserCheck(paramMap);
	      System.out.println("successpage : "+request.getParameter("successpage"));
	      if(userCheckCnt>=1){
	         viewPage = request.getParameter("successpage");
	         request.setAttribute("listsize", request.getParameter("listsize"));
	         request.setAttribute("pageNum", request.getParameter("pageNum"));
	         request.setAttribute("searchType", request.getParameter("searchType"));
	         request.setAttribute("searchValue", request.getParameter("searchValue"));
	      }else{
	         viewPage = "/A0000001/jsp/qna/qnaUserCheck.jsp";
	         request.setAttribute("qna_num", request.getParameter("qna_num"));
	         request.setAttribute("successpage", request.getParameter("successpage"));
	         request.setAttribute("divisioncode", request.getParameter("divisioncode"));
	         request.setAttribute("listsize", request.getParameter("listsize"));
	         request.setAttribute("pageNum", request.getParameter("pageNum"));
	         request.setAttribute("searchType", request.getParameter("searchType"));
	         request.setAttribute("searchValue", request.getParameter("searchValue"));
	      }
	      System.out.println(viewPage);
	      return viewPage;
	}

}
