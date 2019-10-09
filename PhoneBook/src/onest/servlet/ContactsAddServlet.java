package onest.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import onest.entity.Contacts;
import onest.dao.impl.*;

/**
 * Servlet implementation class ContactsAddServlet
 */
@WebServlet("/ContactsAddServlet")
public class ContactsAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactsAddServlet() {
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

		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String mobile = request.getParameter("mobile");
		String qq = request.getParameter("qq");
		String wechat = request.getParameter("wechat");
		String school = request.getParameter("school");
		String sex = request.getParameter("sex");
		Contacts contacts = new Contacts(name, address, mobile, qq, wechat, school, sex);
		contacts.setId((String)session.getAttribute("ID"));
		ContactsDaoImpI contactsDaoImpI = new ContactsDaoImpI();
		contactsDaoImpI.ContactsAdd(contacts);
		response.getWriter().println("<script> alert('添加成功');window.location='welcome.jsp'</script>");
	}

}
