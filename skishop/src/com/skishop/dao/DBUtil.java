package com.skishop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 * 数据库连接
 * @author Naive
 * @date: 2019年10月16日 上午11:15:11
 */
public class DBUtil {
	static{
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static Connection getCon(){
		try{
			Connection con=DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/ski_db?useUnicode=true&characterEncoding=UTF-8","root","123456");
			return con;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
