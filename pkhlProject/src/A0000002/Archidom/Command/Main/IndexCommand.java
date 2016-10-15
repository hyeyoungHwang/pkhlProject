package A0000002.Archidom.Command.Main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import A0000002.Archidom.Command.A0000002Command;

public class IndexCommand implements A0000002Command {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		return "/A0000002/jsp/test.jsp";
	}

}
