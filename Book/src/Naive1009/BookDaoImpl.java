package Naive1009;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 * 实现接口，对数据库操作
 * @author Naive
 * @date: 2019年10月9日 下午4:56:47
 */
public class BookDaoImpl implements BookDao {
	private Connection connection;
	public BookDaoImpl() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName(dbdriver);
			this.connection =DriverManager.getConnection(dburl,dbusername,dbpassword);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void BookAdd(Book book) {
		String BookAddsql = "";
		try {
			PreparedStatement pStatement = this.connection.prepareStatement(BookAddsql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void BookDelete(int id) {
		String BookDeletesql = "";

	}

	@Override
	public void BookUpdate(int id, Book book) {
		// TODO Auto-generated method stub

	}

	@Override
	public Book BookSelect(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Book> BookSelect() {
		// TODO Auto-generated method stub
		return null;
	}

}
