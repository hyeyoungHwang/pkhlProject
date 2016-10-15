package A0000001.Archidom.Command.Admin;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import A0000001.Archidom.Command.A0000001Command;
import A0000001.Archidom.DAO.AdminDAO;

public class AdminImageInsertCommand implements A0000001Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");

	      MultipartRequest multi = null;
	       String realPath;
	       int sizeLimit = 10 * 1024*1024;
	       //String savePath = "D:/pkhl/workspace/pkhl/WebContent/IMAGE";
	       String savePath = request.getServletContext().getRealPath("/A0000001/img/slides");
	       System.out.println(savePath);
	       multi = new MultipartRequest(request, savePath, sizeLimit, "utf-8",new DefaultFileRenamePolicy());
	       Enumeration files = multi.getFileNames();
	        String name = (String)files.nextElement();
	        String filename = multi.getFilesystemName(name);

	        Map<String, Object> paramMap = new HashMap<String, Object>();
	        
	        paramMap.put("filename", filename);
	        
	        AdminDAO adminDao = new AdminDAO();
	        
	        adminDao.adminImageInsert(paramMap);
	        
	      return "archidom/adminImageList.a1";
	}

}
