package com.skishop.servlets.shopcart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.skishop.daoimpl.product.ProductDao;
import com.skishop.entity.Cart;

/**
 * 添加购物车的servlet
 * @author Naive
 * @date: 2019年10月16日 上午11:12:42
 */
@WebServlet("/CartAddServlet")
public class CartAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		ProductDao productDao = new ProductDao();
		Cart cart = new Cart();
		HttpSession session = request.getSession();
		if (session.getAttribute("cart")==null) {
			cart = new Cart();
		}else{
			cart = (Cart)session.getAttribute("cart");		
		}
		cart.addItem(productDao.QueryProduct(Integer.valueOf(request.getParameter("id"))));
		session.setAttribute("cart", cart);
		
		request.getRequestDispatcher("showcart.jsp").forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
