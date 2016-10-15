package A0000003.ModelHouse.Command.Join;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import A0000003.ModelHouse.Command.A0000003Command;
import A0000003.ModelHouse.DAO.JoinDAO;

public class JoinInsertCommand implements A0000003Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
	
		System.out.println("=====1");
		
		JoinDAO joinDao = new JoinDAO();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("user_nm", request.getParameter("user_nm"));
		paramMap.put("user_id", request.getParameter("user_id"));
		paramMap.put("user_pw", request.getParameter("user_pw"));
		paramMap.put("user_tel", request.getParameter("user_tel"));
		paramMap.put("user_phone", request.getParameter("user_phone"));
		paramMap.put("user_email", request.getParameter("user_email"));
		paramMap.put("zip", request.getParameter("zip"));
		paramMap.put("addr", request.getParameter("addr"));
		paramMap.put("detail_addr", request.getParameter("detail_addr"));
		
		String bsnsCode = joinDao.selectBsnsCode(paramMap);
		paramMap.put("bsns_code", bsnsCode);
		
 		joinDao.joinInsert(paramMap);
		
		/*(기본-공개글) 체크 : 비밀글(N) / 비체크 : 공개글(Y) */ 
		/* String qna_open_yn = "Y";
		  
		if(request.getParameter("qna_open_yn")!=null){
			qna_open_yn = "N";
		}
		  
		QnADAO qnaDao = new QnADAO();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		  
		paramMap.put("qna_name", request.getParameter("qna_name"));
		  
		qnaDao.qnaInsert(paramMap);*/
		System.out.println("=====2");
		return "modelhouse/joinComplete.a3";
	}
	
}
