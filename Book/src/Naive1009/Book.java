package Naive1009;

/**
 * 书本实体
 * @author Naive
 * @date: 2019年10月9日 下午4:38:20
 */
public class Book {
	/*
	 * id 书本的唯一标识
	 * bookName 书名
	 * price 价格
	 * description 描述
	 */
	private int id;
	private String bookName;
	private int price;
	private String description;
	
	public Book(){
		
	}
	public Book(int id,
			String bookName,
			int price,
			String description){
		this.id = id;
		this.bookName = bookName;
		this.price = price;
		this.description = description;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", price=" + price + ", description=" + description
				+ ", getId()=" + getId() + ", getBookName()=" + getBookName() + ", getPrice()=" + getPrice()
				+ ", getDescription()=" + getDescription() + "]";
	}
}
