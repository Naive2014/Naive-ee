package onest.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import onest.dao.impl.*;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		//登录功能的实体?
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获取客户端传递过来的账号和密�?
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		//�?测帐号和密码是否合法 借助Dao来进行实�?
		HttpSession session = request.getSession(); 
		UsersDaoImpl usersDaoImpl=new UsersDaoImpl();
		boolean loginok=usersDaoImpl.UsersLogin(username, password);
		if(loginok){
			//登录成功 session的写
			response.getWriter().println("登录成功!");
			//用session存SQL中的ID 
			session.setAttribute("ID", usersDaoImpl.UsersGetID(username));
			session.setMaxInactiveInterval(0);
			response.sendRedirect("welcome.jsp");
		}else{
			//登录失败
			//账号名和密码输入错误 提示 继续登录
			response.getWriter().println("<script> alert('您输入的用户名或者密码错误，请重新登录');window.location='login.jsp'</script>");
		}
	}

}
