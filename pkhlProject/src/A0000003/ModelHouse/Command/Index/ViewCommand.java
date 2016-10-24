package A0000003.ModelHouse.Command.Index;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import A0000003.ModelHouse.Command.A0000003Command;

public class ViewCommand implements A0000003Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String view = request.getParameter("viewpage");
		return view;
	}

}
