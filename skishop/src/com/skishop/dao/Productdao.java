package com.skishop.dao;

import java.util.ArrayList;

import com.skishop.entity.Product;


public interface Productdao {
	/**
	 * 查询全部
	 * @return 查询到的数据
	 */
	public ArrayList<Product> findAll();
	
	
}
