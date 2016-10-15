package A0000001.Archidom.Command.Admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import A0000001.Archidom.Command.A0000001Command;

public class AdminImageInsertFormCommand implements A0000001Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
        return "/A0000001/jsp/admin/adminImageInsertForm.jsp";
	}

}
