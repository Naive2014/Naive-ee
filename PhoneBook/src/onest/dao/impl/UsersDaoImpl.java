package onest.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import onest.dao.UsersDao;
import onest.entity.Users;

public class UsersDaoImpl implements UsersDao {

	//数据库连�?
	private Connection connection;
	private String dburl="jdbc:mysql://localhost:3306/phonebook";
	private String dbuname="root";
	private String dbupwd="123456";
	public UsersDaoImpl() {
		// TODO Auto-generated constructor stub
		//数据库操作初始化
		//加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection(dburl,dbuname,dbupwd);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//创建连接
	}
	
	@Override//添加数据
	public void UsersInsert(Users users) {
		// TODO Auto-generated method stub
		String usersupdatesql="INSERT INTO users() VALUES(?,?,?,?,?,?,?,?,?);";
        try {
			PreparedStatement pStatement=this.connection.prepareStatement(usersupdatesql);
			//生成随机ID
			Random ran = new Random();
			int id = ran.nextInt(99999-10000+1)+10000;
			pStatement.setString(1, Integer.toString(id));
			pStatement.setString(2, users.getUsername());
			pStatement.setString(3, users.getAddress());
			pStatement.setString(4, users.getMobile());
			pStatement.setString(5, users.getName());
			pStatement.setString(6, users.getQQ());
			pStatement.setString(7, users.getWechat());
			pStatement.setString(8, users.getEmail());
			pStatement.setString(9, users.getPassword());
			pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}

	@Override//查询数据
	public Users UsersSelect(String id) {
		// TODO Auto-generated method stub
		String usersselectsql = "SELECT * FROM users where id=?";
		try {
			PreparedStatement pStatement=this.connection.prepareStatement(usersselectsql);
			pStatement.setString(1, id);
			ResultSet rSet=pStatement.executeQuery();
			if (rSet.next()) {
				String username  = rSet.getString("username");
				String password  = rSet.getString("password");
				String address  = rSet.getString("address");
				String mobile  = rSet.getString("mobile");
				String name  = rSet.getString("name");
				String qq  = rSet.getString("qq");
				String wechat  = rSet.getString("wechat");
				String email  = rSet.getString("email");
				Users users = new Users(username, password, address, mobile, name, qq, wechat, email);
				return users;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override//修改信息
	public void UsersUpdate(String id, Users users) {
		// TODO Auto-generated method stub
		//修改个人信息功能的实�?
		String usersupdatesql="update users set address=?,mobile=?,name=?,qq=?,wechat=?,email=?,password=? where id=?";
        try {
			PreparedStatement pStatement=this.connection.prepareStatement(usersupdatesql);
			pStatement.setString(1, users.getAddress());
			pStatement.setString(2, users.getMobile());
			pStatement.setString(3, users.getName());
			pStatement.setString(4, users.getQQ());
			pStatement.setString(5, users.getWechat());
			pStatement.setString(6, users.getEmail());
			pStatement.setString(7, users.getPassword());
			pStatement.setString(8, id);
			pStatement.execute();//执行
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	@Override//删除数据
	public void UsersDelete(String id) {
		// TODO Auto-generated method stub
		String Deletedata = "delete from users where id=?";
		try {
			PreparedStatement rSet = this.connection.prepareStatement(Deletedata);
			rSet.setString(1, id);
			rSet.execute();//执行
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override//判断登录
	public boolean UsersLogin(String username, String password) {
		// TODO Auto-generated method stub
		String usersloginsql="select * from users where username=? and password=?";
		try {
			PreparedStatement pStatement=this.connection.prepareStatement(usersloginsql);
			//填参数?
			pStatement.setString(1, username);
			pStatement.setString(2, password);
			ResultSet rSet=pStatement.executeQuery();
			if(rSet.next()){
				//表示获取到符合条件的数据库表记录 即登录成功?
				return true;
			}else{
				//登录失败
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	@Override//获取ID
	public String UsersGetID(String username)
	{
		String usersloginsql = "select id from users where username=?";
		Users users = new Users();
		try {
			PreparedStatement pStatement = this.connection.prepareStatement(usersloginsql);
			// 填参数
			pStatement.setString(1, username);
			ResultSet rSet = pStatement.executeQuery();
			if (rSet.next()) {
				//更新UsersID
				users.setid(rSet.getString("id"));
				return rSet.getString("id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	/*数据库表代码
	-u root -p
	删除数据库
	drop database phonebook;
	删除表
	drop TABLE users;
	新建数据库
	CREATE database phonebook;
	选择数据库
	use phonebook;
	查询代码
	select * from users;
	新建表
	CREATE TABLE users(
	id INT NOT NULL AUTO_INCREMENT,
	username VARCHAR(30) NOT NULL,
	address VARCHAR(30),
	mobile VARCHAR(30),
	name VARCHAR(30),
	qq VARCHAR(30),
	wechat VARCHAR(30),
	email VARCHAR(30),
	password VARCHAR(30) NOT NULL,
	PRIMARY KEY (id)
    )ENGINE=InnoDB DEFAULT CHARSET=utf8;*/
}
