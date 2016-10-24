package A0000003.ModelHouse.Command.Ntc;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import A0000003.ModelHouse.Command.A0000003Command;
import A0000003.ModelHouse.DAO.NtcDAO;

public class NtcUpdateCommand implements A0000003Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");

		NtcDAO ntcDao = new NtcDAO();

		Map<String, Object> paramMap = new HashMap<String, Object>();
	
		paramMap.put("ntc_num",request.getParameter("ntc_num"));
		paramMap.put("ntc_title",request.getParameter("ntc_title"));
		paramMap.put("ntc_content",request.getParameter("ntc_content"));

		ntcDao.ntcUpdate(paramMap);
		return "modelhouse/ntcDetail.a3";
		
	}
}