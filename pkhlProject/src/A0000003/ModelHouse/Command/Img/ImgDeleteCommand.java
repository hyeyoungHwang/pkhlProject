package A0000003.ModelHouse.Command.Img;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import A0000003.ModelHouse.Command.A0000003Command;
import A0000003.ModelHouse.DAO.ImgDAO;

public class ImgDeleteCommand implements A0000003Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");

		ImgDAO ImgDAO = new ImgDAO();
		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("img_sn", request.getParameter("img_sn"));
		paramMap.put("bsns_code", session.getAttribute("bsns_code"));
		
		ImgDAO.imgDelete(paramMap);
		  
		return "modelhouse/imgList.a3";
	}

}
