package onest.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import onest.dao.impl.ContactsDaoImpI;
import onest.dao.impl.UsersDaoImpl;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		HttpSession session = request.getSession(); 
		UsersDaoImpl usersDaoImpl = new UsersDaoImpl();
		ContactsDaoImpI contactsDaoImpI = new ContactsDaoImpI();
		if (request.getParameter("id")!=null) {
			contactsDaoImpI.ContactsDeleteALL(request.getParameter("id"));
			usersDaoImpl.UsersDelete(request.getParameter("id"));
			session.invalidate();
			response.getWriter().println("<script> alert('删除成功，请重新登录');window.location='login.jsp'</script>");
		}else if (request.getParameter("Exit").equals("esc")) {
			session.invalidate();
			response.sendRedirect("login.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
