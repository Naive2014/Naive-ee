package onest.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import onest.dao.ContactsDao;
import onest.entity.Contacts;

public class ContactsDaoImpI implements ContactsDao {
	//常量
	public String dbpassword="123456";
	public String dbusername="root";
	public String dbdriver="com.mysql.jdbc.Driver";
	public String dburl="jdbc:mysql://localhost:3306/phonebook";

	private Connection connection;
	public ContactsDaoImpI(){
		//数据库操作初始化
		//加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(dburl,dbusername,dbpassword);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void ContactsAdd(Contacts contacts) {
		// TODO Auto-generated method stub
		String usersupdatesql = "INSERT INTO contacts() VALUES(?,?,?,?,?,?,?,?,?);";
		try {
			PreparedStatement pStatement = this.connection.prepareStatement(usersupdatesql);
			//生成随机pid
			Random ran = new Random();
			int pid = ran.nextInt(999-100+1)+100;
			pStatement.setString(1, contacts.getId());
			pStatement.setString(2, Integer.toString(pid));
			pStatement.setString(3, contacts.getName());
			pStatement.setString(4, contacts.getAddress());
			pStatement.setString(5, contacts.getMobile());
			pStatement.setString(6, contacts.getQQ());
			pStatement.setString(7, contacts.getWechat());
			pStatement.setString(8, contacts.getSchool());
			pStatement.setString(9, contacts.getSex());
			pStatement.execute();//执行
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	public ArrayList<Contacts> ContactsSelect(String id) {
		// TODO Auto-generated method stub
		String ArrayListsql = "select * from contacts where id=?";
		try {
			PreparedStatement pStatement=this.connection.prepareStatement(ArrayListsql);
			pStatement.setString(1, id);
			ResultSet rSet=pStatement.executeQuery();
			ArrayList<Contacts> arrayList = new ArrayList<Contacts>();
			while (rSet.next()) {
				String name = rSet.getString("name");
				String address = rSet.getString("address");
				String mobile = rSet.getString("mobile");
				String qq = rSet.getString("qq");
				String wechat = rSet.getString("wechat");
				String school = rSet.getString("school");
				String sex = rSet.getString("sex");
				String pid = rSet.getString("pid");
				Contacts contacts = new Contacts(name, address, mobile, qq, wechat, school, sex);
				contacts.setPid(pid);
				contacts.setId(id);
				arrayList.add(contacts);//把对象放到ArrayList
			}
			return arrayList;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Contacts ContactsSelectOne(String pid, String id) {
		// TODO Auto-generated method stub
		String ContactsSelectOnesql = "select * from Contacts where id=? and pid=?";
		try {
			PreparedStatement pStatement=this.connection.prepareStatement(ContactsSelectOnesql);
			pStatement.setString(1, id);
			pStatement.setString(2, pid);
			ResultSet rSet=pStatement.executeQuery();
			if (rSet.next()) {
				String name = rSet.getString("name");
				String address = rSet.getString("address");
				String mobile = rSet.getString("mobile");
				String qq = rSet.getString("qq");
				String wechat = rSet.getString("wechat");
				String school = rSet.getString("school");
				String sex = rSet.getString("sex"); 
				Contacts contacts = new Contacts(name, address, mobile, qq, wechat, school, sex);
				return contacts;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void ContactsDelete(String pid, String id) {
		// TODO Auto-generated method stub
		String ContactsDeletesql = "delete from contacts where id=? and pid=?";
		try {
			PreparedStatement pStatement=this.connection.prepareStatement(ContactsDeletesql);
			pStatement.setString(1, id);
			pStatement.setString(2, pid);
			pStatement.execute();//执行
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Override
	public void ContactsDeleteALL(String id){
		String ContactsDeleteALLsql = "delete from contacts where id=?";
		try {
			PreparedStatement pStatement=this.connection.prepareStatement(ContactsDeleteALLsql);
			pStatement.setString(1, id);
			pStatement.execute();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void ContactsUpdate(String pid, String id, Contacts contacts) {
		// TODO Auto-generated method stub
		String ContactsUpdatesql = "update contacts set name=?,address=?,mobile=?,qq=?,wechat=?,school=?,sex=? where id=? and pid=?";
		try {
			PreparedStatement pStatement=this.connection.prepareStatement(ContactsUpdatesql);
			pStatement.setString(1, contacts.getName());
			pStatement.setString(2, contacts.getAddress());
			pStatement.setString(3, contacts.getMobile());
			pStatement.setString(4, contacts.getQQ());
			pStatement.setString(5, contacts.getWechat());
			pStatement.setString(6, contacts.getSchool());
			pStatement.setString(7, contacts.getSex());
			pStatement.setString(8, id);
			pStatement.setString(9, pid);
			pStatement.execute();//执行
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
/*CREATE TABLE contacts(
	id INT NOT NULL ,
	pid INT AUTO_INCREMENT,
	name VARCHAR(30) NOT NULL,
	address VARCHAR(30),
	mobile VARCHAR(30),
	qq VARCHAR(30),
	wechat VARCHAR(30),
	school VARCHAR(60),
	sex VARCHAR(5),
	PRIMARY KEY (pid)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;*/
