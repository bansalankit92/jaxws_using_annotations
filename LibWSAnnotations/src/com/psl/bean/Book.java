package com.psl.bean;

public class Book {

	private int id;
	private String name;
	private String author;
	private double price;
	private String isbn;
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Book(int id, String name, String author, double price, String isbn) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
		this.isbn = isbn;
	}
	public Book() {
		super();
	}
	@Override
	public String toString() {
		return "BOOK [id=" + id + ", name=" + name + ", author=" + author
				+ ", price=" + price + ", isbn=" + isbn + "]\n";
	}
	
	
	
	
}
