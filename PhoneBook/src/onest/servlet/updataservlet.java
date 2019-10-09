package onest.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import onest.dao.impl.ContactsDaoImpI;
import onest.entity.Contacts;

/**
 * Servlet implementation class updataservlet
 */
@WebServlet("/updataservlet")
public class updataservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updataservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		ContactsDaoImpI contactsDaoImpI = new ContactsDaoImpI();
		Contacts contacts = new Contacts(request.getParameter("name"),
					request.getParameter("address"),
					request.getParameter("mobile"),
					request.getParameter("qq"),
					request.getParameter("wechat"),
					request.getParameter("school"),
					request.getParameter("sex"));
		contactsDaoImpI.ContactsUpdate(request.getParameter("pid"), request.getParameter("id"), contacts);
		response.getWriter().println("<script> alert('修改成功');window.location='welcome.jsp'</script>");
	}

}
