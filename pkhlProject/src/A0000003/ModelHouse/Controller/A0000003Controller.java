package A0000003.ModelHouse.Controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import A0000003.ModelHouse.Command.A0000003Command;

/**
 * Servlet implementation class A0000003Controller
 */
@WebServlet("/A0000003Controller")
public class A0000003Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private Map commandMap = new HashMap();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A0000003Controller() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		String props = config.getInitParameter("settingConfig");
	      Properties pr = new Properties();
	      FileInputStream  f = null;
	      
	      try {
	         f = new FileInputStream(props); 
	         pr.load(f); 
	         
	      } catch (Exception e) {
	         throw new ServletException();
	      } finally {
	         if( f != null) try { f.close(); } catch(Exception e) { }
	      }
	      
	      Iterator  keyIter = pr.keySet().iterator();
	      
	      while( keyIter.hasNext() ){
	         String command = (String)keyIter.next();
	         String className = pr.getProperty(command);
	         
	         try {
	            Class commandClass = Class.forName(className);
	            Object commandInstance = commandClass.newInstance();
	            commandMap.put(command, commandInstance);
	            
	         } catch (Exception e) {
	            e.printStackTrace();
	         }
	      }
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			actionDo(request, response);
		} catch (Throwable e) {
			e.printStackTrace();
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			actionDo(request, response);
		} catch (Throwable e) {
			e.printStackTrace();
		}	
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
	      
	      String viewPage = null;
	      String viewCheck = null;
	      A0000003Command a0000003Command = null;
	      
	      String command = request.getRequestURI();
	      System.out.println("1 " + command);
	      
	      if( command.indexOf(request.getRequestURI()) == 0 ) {
	    	  System.out.println(request.getRequestURI());
	         command = command.substring(1);
	      }
	      System.out.println("2 " +command);
	      
	      
	      a0000003Command = (A0000003Command) commandMap.get(command);
	      viewPage = a0000003Command.execute(request, response);
	      viewCheck = viewPage.substring(viewPage.length()-3);
	      
	     
	      while(viewCheck.equals(".a3")){
	         a0000003Command = (A0000003Command) commandMap.get(viewPage);
	         viewPage = a0000003Command.execute(request, response);
	         viewCheck = viewPage.substring(viewPage.length()-3);
	      }
	      
	      System.out.println("3 " +viewPage);
	      request.setAttribute("content", viewPage);
	      
	      RequestDispatcher dispatcher = request.getRequestDispatcher("/A0000003/jsp/template/template.jsp");
	      dispatcher.forward(request, response);
	}

}
