package Naive1009;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
/**
 * 实现接口，对数据库操作
 * @author Naive
 * @date: 2019年10月9日 下午4:56:47
 */
public class BookDaoImpl implements BookDao {
	private Connection connection;
	public BookDaoImpl() {
		try {
			Class.forName(dbdriver);
			this.connection =DriverManager.getConnection(dburl,dbusername,dbpassword);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public int Randomvalue() {
		Random ran = new Random();
		int rand = ran.nextInt(999999-100000+1)+100000;//生成随机数
		return rand;
	}
	
	@Override
	public boolean BookAdd(Book book) {
		String BookAddsql = "INSERT INTO book() VALUES(?,?,?,?)";
		try {
			PreparedStatement pStatement = this.connection.prepareStatement(BookAddsql);
			pStatement.setInt(1, Randomvalue());
			pStatement.setString(2, book.getBookName());
			pStatement.setInt(3, book.getPrice());
			pStatement.setString(4, book.getDescription());
			pStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean BookDelete(int id) {
		String BookDeletesql = "delete from book where id=?";
		try {
			PreparedStatement pStatement = this.connection.prepareStatement(BookDeletesql);
			pStatement.setInt(1, id);
			pStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean BookUpdate(int id, Book book) {
		String BookUpdatesql = "update book set bookName=?,price=?,description=? where id=?";
		try {
			PreparedStatement pStatement = this.connection.prepareStatement(BookUpdatesql);
			pStatement.setString(1, book.getBookName());
			pStatement.setInt(2, book.getPrice());
			pStatement.setString(3, book.getDescription());
			pStatement.setInt(4, id);
			pStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public Book BookSelect(int id) {
		String BookSelectsql = "select * from book where id=?";
		try {
			PreparedStatement pStatement = this.connection.prepareStatement(BookSelectsql);
			pStatement.setInt(1, id);
			ResultSet rSet=pStatement.executeQuery();
			if (rSet.next()) {
				Book book = new Book(id,
						rSet.getString("bookName"),
						rSet.getInt("price"),
						rSet.getString("description"));
				return book;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public ArrayList<Book> BookSelect() {
		String BookSelectsql = "select * from book";
		try {
			PreparedStatement pStatement = this.connection.prepareStatement(BookSelectsql);
			ArrayList<Book>arrayList = new ArrayList<Book>();
			ResultSet rSet=pStatement.executeQuery();
			while (rSet.next()) {
				Book book = new Book(rSet.getInt("id"),
						rSet.getString("bookName"),
						rSet.getInt("price"),
						rSet.getString("description"));
				arrayList.add(book);
			}
			return arrayList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
