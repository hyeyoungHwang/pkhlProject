package A0000001.Archidom.Command.Main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import A0000001.Archidom.Command.A0000001Command;

public class ViewCommand implements A0000001Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String view = request.getParameter("viewpage");
	      
	      /* 문의사항 */
	      if(request.getParameter("qna_num")!=null){
	         int qna_num = Integer.parseInt(request.getParameter("qna_num"));
	         request.setAttribute("qna_num", qna_num);
	      }
	      
	      /* 공지사항 */
	      if(request.getParameter("notice_num")!=null){
	         int notice_num = Integer.parseInt(request.getParameter("notice_num"));
	         request.setAttribute("notice_num", notice_num);
	      }
	      
	      request.setAttribute("successpage", request.getParameter("successpage"));
	      request.setAttribute("divisioncode", request.getParameter("divisioncode"));
	      request.setAttribute("listsize", request.getParameter("listsize"));
	      request.setAttribute("pageNum", request.getParameter("pageNum"));
	      request.setAttribute("searchType", request.getParameter("searchType"));
	      request.setAttribute("searchValue", request.getParameter("searchValue"));

	      return view;
	      
	}

}
