package onest.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import onest.dao.impl.UsersDaoImpl;
import onest.entity.Users;

/**
 * Servlet implementation class ReviseUsers
 */
@WebServlet("/ReviseUsers")
public class ReviseUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviseUsers() {
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
		
		HttpSession session = request.getSession(); 
		UsersDaoImpl usersDaoImpl = new UsersDaoImpl(); 
		Users users = new Users();
		users.setPassword(request.getParameter("password"));
		users.setAddress(request.getParameter("address"));
		users.setMobile(request.getParameter("mobile"));
		users.setName(request.getParameter("name"));
		users.setQQ(request.getParameter("qq"));
		users.setWechat(request.getParameter("wechat"));
		users.setEmail(request.getParameter("email"));
		//修改信息
		usersDaoImpl.UsersUpdate((String)session.getAttribute("ID"), users);
		System.out.println((String)session.getAttribute("ID"));
//		response.getWriter().println("<script> alert('修改成功');window.location.href='welcome.jsp?ID="+(String)request.getParameter("ID")+"'</script>");
		response.getWriter().println("<script> alert('修改成功');window.location='welcome.jsp'</script>");
	}

}
