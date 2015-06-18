package qrcode_reader;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Main() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jspFilePath = "/jsp/test.jsp";
		
		RequestDispatcher dispatch = request.getRequestDispatcher(jspFilePath);
		dispatch.forward(request, response);
		
		System.out.println("call get method");
//		PrintWriter writer = response.getWriter();
//		
//		writer.println("test");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(factory);
		
		try{
			List list = sfu.parseRequest(request);
			Iterator iterator = list.iterator();
			while(iterator.hasNext()){
				FileItem item = (FileItem)iterator.next();
				System.out.println(item.getName());
			}
		} catch(FileUploadException e){
			e.printStackTrace();
		}
		String jspFilePath = "/jsp/test.jsp";
		
		RequestDispatcher dispatch = request.getRequestDispatcher(jspFilePath);
		dispatch.forward(request, response);
		System.out.println("call post method");
	}

}
