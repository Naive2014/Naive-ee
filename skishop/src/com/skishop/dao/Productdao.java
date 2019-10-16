package com.skishop.dao;

import java.util.ArrayList;

import com.skishop.entity.Product;
/**
 * 定义商品接口
 * @author Naive
 * @date: 2019年10月16日 上午11:15:27
 */

public interface Productdao {
	/**
	 * 查询全部
	 * @return 查询到的数据
	 */
	public ArrayList<Product> findAll();
	/**
	 * 根据id查找商品
	 * @param id 商品id
	 * @return 查询到的商品
	 */
	public Product QueryProduct(int id);
}
