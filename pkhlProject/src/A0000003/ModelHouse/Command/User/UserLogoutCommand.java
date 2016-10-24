package A0000003.ModelHouse.Command.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import A0000003.ModelHouse.Command.A0000003Command;

public class UserLogoutCommand implements A0000003Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("user_id");
		session.removeAttribute("user_pw");
		session.removeAttribute("user_auth");
		return "modelhouse/index.a3";
	}

}
