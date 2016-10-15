package A0000001.Archidom.Command.Main;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import A0000001.Archidom.Command.A0000001Command;
import A0000001.Archidom.DAO.AdminDAO;

public class IndexCommand implements A0000001Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		AdminDAO adminDao = new AdminDAO();
		List<Map<String,Object>> resultMap = adminDao.adminImageList();
		request.setAttribute("imageList", resultMap);
		
		return "/A0000001/jsp/template/main.jsp";
		
	}

}
