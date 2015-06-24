package qrcode_reader;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItemStream;
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
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jspFilePath = "/jsp/input.jsp";

		RequestDispatcher dispatch = request.getRequestDispatcher(jspFilePath);
		dispatch.forward(request, response);

		System.out.println("call get method");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		String text = "";
		try{
//			FileItemIterator iter = upload.getItemIterator(request);
//			//			while (iter.hasNext()) {
//			FileItemStream item = iter.next();
			
			FileItemStream item = upload.getItemIterator(request).next();

			text = QRCodeDecoder.decodeQRCode(ImageIO.read(item.openStream()));
			request.setAttribute("result", text);
		} catch(Exception e){
			e.printStackTrace();
		}

		System.out.println(text);
		String jspFilePath = "/jsp/result.jsp";

		RequestDispatcher dispatch = request.getRequestDispatcher(jspFilePath);
		dispatch.forward(request, response);
		System.out.println("call post method");
	}

}
