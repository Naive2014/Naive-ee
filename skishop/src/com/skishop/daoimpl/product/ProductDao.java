package com.skishop.daoimpl.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.skishop.dao.DBUtil;
import com.skishop.dao.Productdao;
import com.skishop.entity.Product;
/**
 * 实现商品接口
 * @author Naive
 * @date: 2019年10月16日 上午11:14:48
 */
public class ProductDao implements Productdao{
	private Connection con=DBUtil.getCon();

	public ArrayList<Product> findAll(){
		try{
			ArrayList<Product> list=new ArrayList<Product>();
			PreparedStatement pstm=this.con.prepareStatement("select * from product");
			ResultSet rs=pstm.executeQuery();
			while(rs.next() ){
				Product product = new Product();
				product.setId(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setDescription(rs.getString(3));
				product.setListimg(rs.getString(4));
				product.setprice(rs.getInt(5));
				product.setDiscountprice(rs.getInt(6));
				list.add(product);
			}
			return list;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Product QueryProduct(int id) {
		String QueryProductsql = "select * from product where id=?";
		try {
			PreparedStatement pstm=this.con.prepareStatement(QueryProductsql);
			pstm.setInt(1, id);
			ResultSet rSet=pstm.executeQuery();
			if (rSet.next()) {
				Product product = new Product(rSet.getInt("id"),
						rSet.getString("name"),
						rSet.getString("description"),
						rSet.getString("listimg"),
						rSet.getInt("price"),
						rSet.getInt("discountprice"));
				return product;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


}
