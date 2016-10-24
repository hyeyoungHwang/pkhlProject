package A0000003.ModelHouse.Command.User;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import A0000003.ModelHouse.Command.A0000003Command;
import A0000003.ModelHouse.DAO.UserDAO;

public class UserLoginCommand implements A0000003Command {
	
	/* User Login */
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		String viewpage = "";
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		paramMap.put("bsns_code", session.getAttribute("bsns_code"));
		paramMap.put("user_id", user_id);
		
		UserDAO userDao = new UserDAO();
		Map<String,Object> resultMap = userDao.userLogin(paramMap);
		
		if(resultMap != null){
			if(resultMap.get("USER_PW").equals(user_pw)){
				session.setAttribute("user_id", user_id);
				session.setAttribute("user_pw", user_pw);
				session.setAttribute("user_auth", resultMap.get("USER_AUTH"));
				viewpage = "modelhouse/index.a3";
			}
		}
		
		return viewpage;
	}

}
