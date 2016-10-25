package A0000003.ModelHouse.Command.Ntc;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import A0000003.ModelHouse.Command.A0000003Command;
import A0000003.ModelHouse.DAO.NtcDAO;

public class NtcDetailCommand implements A0000003Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		NtcDAO ntcDao = new NtcDAO();
		String viewpage = "";	// view∆‰¿Ã¡ˆ

		if(request.getParameter("divisioncode") == null || request.getParameter("divisioncode").equals("N")){
			viewpage = "/A0000003/jsp/ntc/ntcDetail.jsp";
		}else if(request.getParameter("divisioncode").equals("U")){
			viewpage = "/A0000003/jsp/ntc/ntcUpdate_Form.jsp";
		}

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("ntc_sn", Integer.parseInt(request.getParameter("ntc_sn")));
		paramMap.put("bsns_code",session.getAttribute("bsns_code"));
		Map<String,Object> resultMap = ntcDao.ntcDetail(paramMap);

		request.setAttribute("ntcDetail", resultMap);
		request.setAttribute("listsize", request.getParameter("listsize"));
		request.setAttribute("pageNum", request.getParameter("pageNum"));
		request.setAttribute("searchType", request.getParameter("searchType"));
		request.setAttribute("searchValue", request.getParameter("searchValue"));

		return viewpage;
	}
}