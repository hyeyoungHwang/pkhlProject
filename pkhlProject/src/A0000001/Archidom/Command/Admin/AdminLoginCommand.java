package A0000001.Archidom.Command.Admin;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import A0000001.Archidom.Command.A0000001Command;
import A0000001.Archidom.DAO.AdminDAO;

public class AdminLoginCommand implements A0000001Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		  String admin_id = request.getParameter("admin_id");
	      String admin_pw = request.getParameter("admin_pw");
	      String viewpage = "/A0000001/jsp/admin/adminLogin_Form.jsp";
	      
	      AdminDAO adminDao = new AdminDAO();
	      Map<String, Object> paramMap = new HashMap<String, Object>();
	      paramMap.put("admin_id", admin_id);
	      
	      Map<String,Object> resultMap = adminDao.adminLogin(paramMap);
	      
	      if(resultMap != null){
	         if(resultMap.get("ADMIN_PW").equals(admin_pw)){
	            HttpSession session = request.getSession();
	            session.setAttribute("admin_id", admin_id);
	            session.setAttribute("admin_pw", admin_pw);
	            viewpage = "archidom/index.a1";
	         }
	      }
	      return viewpage;
	      
	}

}
