package A0000001.Archidom.Command.Company;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import A0000001.Archidom.Command.A0000001Command;

public class RepairCommand implements A0000001Command{
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return "/A0000001/jsp/company/repair.jsp";
		
	}

}
