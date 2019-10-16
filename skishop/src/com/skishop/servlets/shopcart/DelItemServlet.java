package com.skishop.servlets.shopcart;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.skishop.entity.Cart;
import com.skishop.entity.CartItem;

/**
 * 删除购物车商品的servlet
 * @author Naive
 * @date: 2019年10月16日 上午11:13:36
 */
@WebServlet("/DelItemServlet")
public class DelItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelItemServlet() {
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
		
		int id = Integer.valueOf(request.getParameter("id"));
		HttpSession session = request.getSession();
		Cart cart = (Cart)session.getAttribute("cart");
		Map<Integer, CartItem> map = cart.getMap();
		map.remove(id);
		cart.setMap(map);
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
