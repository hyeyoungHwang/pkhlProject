package A0000002.Archidom.Command.Menu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import A0000002.Archidom.Command.A0000002Command;

public class Intro implements A0000002Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		/*return "/jsp/menu/about.jsp";*/
		return "/A0000002/jsp/menu/intro.jsp";
	}

}
