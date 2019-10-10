package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Naive1009.Book;
import Naive1009.BookDaoImpl;

/**
 * Servlet implementation class Submit
 */
@WebServlet("/Submit")
public class Submit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Submit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		BookDaoImpl bookDaoImpl = new BookDaoImpl();
		
		if (request.getParameter("id")=="") {
			Book book = new Book();
			book.setBookName(request.getParameter("bookName"));
			book.setPrice(Integer.valueOf(request.getParameter("price")));
			book.setDescription(request.getParameter("description"));
			if (bookDaoImpl.BookAdd(book)) {
				response.getWriter().println("<script> alert('提交成功');top.location='TestServlet'</script>");
			}else{
				response.getWriter().println("<script> alert('提交失败');top.location='TestServlet'</script>");
			}
		}else{
			int id = Integer.valueOf(request.getParameter("id"));
			Book book = new Book(id,
					request.getParameter("bookName"),
					Integer.valueOf(request.getParameter("price")),
					request.getParameter("description"));
			if (bookDaoImpl.BookUpdate(id, book)) {
				response.getWriter().println("<script> alert('提交成功');top.location='TestServlet'</script>");
			}else {
				response.getWriter().println("<script> alert('提交失败');top.location='TestServlet'</script>");
			}
		}
		//doGet(request, response);
	}

}
