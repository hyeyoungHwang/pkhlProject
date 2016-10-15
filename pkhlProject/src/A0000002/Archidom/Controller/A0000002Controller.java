package A0000002.Archidom.Controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import A0000002.Archidom.Command.A0000002Command;

/**
 * Servlet implementation class A0000002Controller
 */
@WebServlet("/A0000002Controller")
public class A0000002Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Map commandMap = new HashMap();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A0000002Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
       try {
          execute(request, response);
       } catch (Throwable e) {
          e.printStackTrace();
       }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
       // TODO Auto-generated method stub
       try {
          execute(request, response);
       } catch (Throwable e) {
          e.printStackTrace();
       }
    }
    
    //�ʱ�ȭ - 1ȸ ȣ���
    //��ɾ�� ��ɾ�ó�� Ŭ������ ���εǾ� �ִ� properties ������ �о �����ϴ� ����...
    @Override
    public void init(ServletConfig config) throws ServletException {
       //web.xml���� propertyConfig�� �ش��ϴ� init-param�� ���� �о��
       String props = config.getInitParameter("settingConfig");
       //��ɾ�� ó��Ŭ������ ���������� ������ Properties ��ü ����
       Properties pr = new Properties();
       FileInputStream  f = null;
       
       try {
          //Command.properties ������ ������ �о��
          f = new FileInputStream(props); 
          //Command.properties ������ ������ Properties ��ü�� ����
          pr.load(f); 
          
       } catch (Exception e) {
          throw new ServletException();
       } finally {
          if( f != null) try { f.close(); } catch(Exception e) { }
       } //try end
       
       Iterator  keyIter = pr.keySet().iterator();
       
       while( keyIter.hasNext() ){
          String command = (String)keyIter.next();
          //properties ������ ���ó�� �κ��� �޾ƿ´�.(Ŭ����������...)
          String className = pr.getProperty(command); 

          try {
             //forName()�� ���ڿ��� Ŭ������ ��ȯ...
             Class commandClass = Class.forName(className);
             //Ŭ������ ��ȯ���ױ� ������ ��ü ������...
             Object commandInstance = commandClass.newInstance();
             commandMap.put(command, commandInstance);
             
          } catch (Exception e) {
             e.printStackTrace();
          }
       } //end while
    }
    
    protected void execute(HttpServletRequest request, HttpServletResponse response)
          throws Throwable {
    	 String viewPage = null;
	      String viewCheck = null;
	      A0000002Command a0000002Command = null;
	      
	      String command = request.getRequestURI();
	      System.out.println("1 " + command);
	      
	      if( command.indexOf(request.getContextPath()) == 0 ) {
	         command = command.substring(request.getContextPath().length() + 1);
	      }
	      System.out.println("2 " +command);
	      
	      
	      a0000002Command = (A0000002Command) commandMap.get(command);
	      viewPage = a0000002Command.execute(request, response);
	      viewCheck = viewPage.substring(viewPage.length()-3);
	      
	     
	      while(viewCheck.equals(".a2")){
	    	  a0000002Command = (A0000002Command) commandMap.get(viewPage);
	         viewPage = a0000002Command.execute(request, response);
	         viewCheck = viewPage.substring(viewPage.length()-3);
	      }
	      
	      System.out.println("3 " +viewPage);
	      request.setAttribute("content", viewPage);
	      
	      RequestDispatcher dispatcher = request.getRequestDispatcher("/A0000002/jsp/template/template.jsp");
	      dispatcher.forward(request, response);
       
      
    }

}
