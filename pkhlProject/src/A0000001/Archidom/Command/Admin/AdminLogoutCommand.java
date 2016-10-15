package A0000001.Archidom.Command.Admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import A0000001.Archidom.Command.A0000001Command;

public class AdminLogoutCommand implements A0000001Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
	      session.removeAttribute("admin_id");
	      session.removeAttribute("admin_pw");
	      return "archidom/index.a1";
	}

}
