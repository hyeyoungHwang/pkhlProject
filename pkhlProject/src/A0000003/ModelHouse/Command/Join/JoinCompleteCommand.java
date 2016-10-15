package A0000003.ModelHouse.Command.Join;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import A0000003.ModelHouse.Command.A0000003Command;

public class JoinCompleteCommand implements A0000003Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/A0000003/jsp/index.jsp";
	}
}
