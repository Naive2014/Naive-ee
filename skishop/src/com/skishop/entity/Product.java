package com.skishop.entity;
/**
 * 商品实体类
 * @author Naive
 * @date: 2019年10月16日 上午11:14:28
 */
public class Product {
	private int id;
	private String name;
	private String description;
	private String listimg;
	private int price;
	private int discountprice;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int id, String name, String description, String listimg, int price, int discountprice) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.listimg = listimg;
		this.price = price;
		this.discountprice = discountprice;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getListimg() {
		return listimg;
	}
	public void setListimg(String listimg) {
		this.listimg = listimg;
	}
	public int getprice() {
		return price;
	}
	public void setprice(int price) {
		this.price = price;
	}
	public int getDiscountprice() {
		return discountprice;
	}
	public void setDiscountprice(int discountprice) {
		this.discountprice = discountprice;
	}
	
}
