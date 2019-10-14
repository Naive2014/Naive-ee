package com.skishop.daoimpl.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.skishop.dao.DBUtil;
import com.skishop.dao.Productdao;
import com.skishop.entity.Product;

public class ProductDao implements Productdao{

	public ArrayList<Product> findAll(){
		try{
			ArrayList<Product> list=new ArrayList<Product>();
			Connection con=DBUtil.getCon();
			PreparedStatement pstm=con.prepareStatement("select * from product");
			ResultSet rs=pstm.executeQuery();
			while(rs.next() ){
				Product product = new Product();
				product.setId(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setDescription(rs.getString(3));
				product.setListimg(rs.getString(4));
				product.setPrince(rs.getInt(5));
				product.setDiscountprince(rs.getInt(6));
				list.add(product);
			}
			return list;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
}
