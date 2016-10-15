package A0000003.ModelHouse.Command.Index;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import A0000003.ModelHouse.Command.A0000003Command;

public class IndexCommand implements A0000003Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Index ���������� ����ڵ常 ���� ����
		HttpSession session = request.getSession();
		session.setAttribute("bsns_code", "A0000003"); 
		
		return "/A0000003/jsp/index.jsp";
	}

}
