package Naive1009;

import java.util.ArrayList;

/**
 * 定义接口
 * @author Naive
 * @date: 2019年10月9日 下午4:42:04
 */
public interface BookDao {
	public String dbpassword="123456";
	public String dbusername="root";
	public String dbdriver="com.mysql.jdbc.Driver";
	public String dburl="jdbc:mysql://localhost:3306/Book";
	/**
	 * 生成随机id
	 * @return 生成的id
	 */
	public int Randomvalue();
	/**
	 * 增加书本
	 * @param book书本类
	 */
	public boolean BookAdd(Book book);
	/**
	 * 根据id删除书本
	 * @param id书本唯一标识
	 */
	public boolean BookDelete(int id);
	/**
	 * 更新书本
	 * @param id确定更新的书本
	 * @param book书本类
	 */
	public boolean BookUpdate(int id, Book book);
	/**
	 * 按指定id查询书本
	 * @param id书本唯一标识
	 * @return 查询到的书本
	 */
	public Book BookSelect(int id);
	/**
	 * 查询全部书本
	 * @return 全部书本
	 */
	public ArrayList<Book> BookSelect();
}
