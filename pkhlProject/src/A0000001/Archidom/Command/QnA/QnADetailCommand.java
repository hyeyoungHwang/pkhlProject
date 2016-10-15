package A0000001.Archidom.Command.QnA;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import A0000001.Archidom.Command.A0000001Command;
import A0000001.Archidom.DAO.QnADAO;

public class QnADetailCommand implements A0000001Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		QnADAO qnaDao = new QnADAO();

	      String viewpage = "/A0000001/jsp/qna/qnaDetail.jsp";
	      String divisioncode = request.getParameter("divisioncode");
	      if(divisioncode != null && divisioncode.length() > 0){
	         viewpage= "/A0000001/jsp/qna/qnaUpdate_Form.jsp";
	      }
	      
	      Map<String, Object> paramMap = new HashMap<String, Object>();
	      paramMap.put("qna_num", Integer.parseInt(request.getParameter("qna_num")));
	      
	      Map<String,Object> resultMap = qnaDao.qnaDetail(paramMap);
	      List<Map<String,Object>> ansList = qnaDao.ansList(paramMap);
	      
	      request.setAttribute("qnaDetail", resultMap);
	      request.setAttribute("ansList", ansList);
	      request.setAttribute("listsize", request.getParameter("listsize"));
	      request.setAttribute("pageNum", request.getParameter("pageNum"));
	      request.setAttribute("searchType", request.getParameter("searchType"));
	      request.setAttribute("searchValue", request.getParameter("searchValue"));
	      
	      return viewpage;
	}

}
