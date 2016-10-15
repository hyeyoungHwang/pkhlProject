package A0000001.Archidom.Command.Admin;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import A0000001.Archidom.Command.A0000001Command;
import A0000001.Archidom.DAO.AdminDAO;

public class AdminImageDeleteCommand implements A0000001Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
	      
	      try {
	         String img = request.getParameter("img");
	         //String savePath = "D:/pkhl/workspace/pkhl/WebContent/IMAGE";
	          String savePath = request.getServletContext().getRealPath("/img/slides");
	          
	          AdminDAO adminDao = new AdminDAO();
	         Map<String, Object> paramMap = new HashMap<String, Object>();

	         paramMap.put("num", request.getParameter("num"));
	         paramMap.put("img", img);        
	           System.out.println("==========================================" + savePath + "/" + img);
	         new File(savePath + "/" + img).delete();
	         
	           adminDao.adminImageDelete(paramMap);
	      }catch(Exception ex) {
	         ex.printStackTrace();  
	      }
	       
	        
	      return "archidom/adminImageList.a1";
	}

}
