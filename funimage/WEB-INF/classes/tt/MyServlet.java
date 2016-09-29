package tt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.websocket.Session;

import org.apache.catalina.core.ApplicationPart;

import tt.TurnImg;
/**
 * Servlet implementation class MyServlet
 */
//@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");  
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("开始处理：\n");
		String url ="",url0= "";
		try{
			String path = this.getServletContext().getRealPath("/");
			Part p = request.getPart("test0");
			if(p.getContentType().contains("image")){
				ApplicationPart ap = (ApplicationPart) p;
				String fname1 = ap.getSubmittedFileName();
				int path_index = fname1.lastIndexOf("\\")+1;
				String fname2 = fname1.substring(path_index, fname1.length());
				int minu = Calendar.getInstance().get(Calendar.MINUTE);
				int sec = Calendar.getInstance().get(Calendar.SECOND);
				url = path +"temp/"+minu+"_"+sec+ fname2;
				url0 = path  +"temp/copy"+minu+"_"+sec+ fname2;
				
				p.write(url);
				TurnImg test = new TurnImg();
				test.init();
				test.draw(url0, test.grayImage(url));
				request.setAttribute("uri", "temp/copy"+minu+"_"+sec+ fname2);
				request.getRequestDispatcher("/2.jsp").forward(request,response);
				/*out.println("上传成功哦~~<br>"+ url);
				out.println("<html>");
				out.println("<head><title>wangtatna</title><head>");
				out.println("<body>");
				out.println("<br><a href=\"http://localhost:8080/TTTT/index.jsp\">返回</a>");
				out.println("<br><a href=\"1.jsp\">1.jsp</a>");
				out.println("<% session.setAttribute(\"uri\", \""+"copy"+fname2+"\"); %>");
				out.println("<img src=\""+ "servlet/copy"+fname2 +"\"/>");
				out.println("</body>");
				out.println("</html>");*/
				
			}else{
				out.println("<head><title>潭老师逗你玩</title><head>");
				out.println("上床失败<br><h1 style=\"color:red\">你TM玩我呢！</h1><br>上传非图片，请重新上传图片<br>");
				out.println("<br><a href=\"index.jsp\">返回</a>");
			}
		}catch(IOException e){
			out.println(e.toString());
		}
		
		
				
		
		
		out.flush();out.close();
	}

}
