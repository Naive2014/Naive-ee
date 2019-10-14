package com.skishop.entity;

public class Product {
	
	private int id;
	private String name;
	private String description;
	private String listimg;
	private int prince;
	private int discountprince;
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
	public int getPrince() {
		return prince;
	}
	public void setPrince(int prince) {
		this.prince = prince;
	}
	public int getDiscountprince() {
		return discountprince;
	}
	public void setDiscountprince(int discountprince) {
		this.discountprince = discountprince;
	}
	
}
