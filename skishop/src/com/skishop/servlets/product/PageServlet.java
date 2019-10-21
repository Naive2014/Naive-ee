package com.skishop.servlets.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skishop.daoimpl.product.ProductDao;
import com.skishop.entity.Page;
import com.skishop.entity.Product;

/**
 * 分页servlet
 * @author Naive
 * @date: 2019年10月18日 下午4:00:13
 */
@WebServlet("/PageServlet")
public class PageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageServlet() {
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
		
		String p = null;
		int pagenum = 1;
		try {
			p = request.getParameter("pagenum");
			pagenum = Integer.valueOf(p);
		} catch (Exception e) {
			pagenum = 1;
		}
		ProductDao productDao = new ProductDao();
		Page<Product> page = new Page<Product>(pagenum, 4);
		ArrayList<Product> arrayList = productDao.FindProuctPage(pagenum, 4);
		int count = productDao.findCount();
		page.setTotalCount(count);
		page.setList(arrayList);
		request.setAttribute("page", page);
		request.getRequestDispatcher("shop.jsp").forward(request, response);
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
