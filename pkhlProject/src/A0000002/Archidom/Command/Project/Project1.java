package A0000002.Archidom.Command.Project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import A0000002.Archidom.Command.A0000002Command;

public class Project1 implements A0000002Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		/*return "/jsp/project/project1.jsp";*/
		return "/A0000002/jsp/project/project1.jsp";
		
	}

}
