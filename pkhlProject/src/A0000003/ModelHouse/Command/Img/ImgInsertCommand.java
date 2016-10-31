package A0000003.ModelHouse.Command.Img;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import A0000003.ModelHouse.Command.A0000003Command;
import A0000003.ModelHouse.DAO.ImgDAO;

public class ImgInsertCommand implements A0000003Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");

		ImgDAO ImgDAO = new ImgDAO();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		HttpSession session = request.getSession(); 
		
		MultipartRequest multi = null;
		//String realPath;
		int sizeLimit = 10 * 1024 * 1024;
		String savePath = request.getServletContext().getRealPath("/A0000003/images");
		System.out.print(savePath);
		multi = new MultipartRequest(request, savePath, sizeLimit, "utf-8",new DefaultFileRenamePolicy());
		
		Enumeration files = multi.getFileNames();
		String name = (String)files.nextElement();
		String img_file_nm = multi.getFilesystemName(name);
		
		paramMap.put("img_file_nm", img_file_nm);
		paramMap.put("bsns_code", session.getAttribute("bsns_code"));
		paramMap.put("user_id", session.getAttribute("user_id"));
		paramMap.put("img_title", multi.getParameter("img_title"));
		paramMap.put("img_content", multi.getParameter("img_content"));
		
		
		ImgDAO.imgInsert(paramMap);
		
		return "modelhouse/imgList.a3";
	}

}
