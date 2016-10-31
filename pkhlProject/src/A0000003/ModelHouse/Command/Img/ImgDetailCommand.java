package A0000003.ModelHouse.Command.Img;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import A0000003.ModelHouse.Command.A0000003Command;
import A0000003.ModelHouse.DAO.ImgDAO;

public class ImgDetailCommand implements A0000003Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		ImgDAO ImgDAO = new ImgDAO();
		String viewpage = "";	// view∆‰¿Ã¡ˆ
		String savePath = request.getServletContext().getRealPath("/A0000003/images");
		
		if(request.getParameter("divisioncode") == null || request.getParameter("divisioncode").equals("N")){
			viewpage = "/A0000003/jsp/img/imgDetail.jsp";
		}else if(request.getParameter("divisioncode").equals("U")){
			viewpage = "/A0000003/jsp/img/imgUpdate_Form.jsp";
		}

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("img_sn", Integer.parseInt(request.getParameter("img_sn")));
		paramMap.put("bsns_code",session.getAttribute("bsns_code"));
		Map<String,Object> resultMap = ImgDAO.imgDetail(paramMap);

		request.setAttribute("imgDetail", resultMap);
		request.setAttribute("listsize", request.getParameter("listsize"));
		request.setAttribute("savePath", savePath);
		request.setAttribute("pageNum", request.getParameter("pageNum"));
		request.setAttribute("searchType", request.getParameter("searchType"));
		request.setAttribute("searchValue", request.getParameter("searchValue"));

		return viewpage;
	}

}
