package com.Model;

public class Book {

	String bookName ;
	String auteurName ;
	int prix ;
	int id;
	
	
	
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Book(String bookName, String auteurName , int prix, int id) {
		super();
		this.bookName = bookName;
		this.auteurName = auteurName;
		this.prix=prix ;
	}
	
	
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuteurName() {
		return auteurName;
	}
	public void setAuteurName(String auteurName) {
		this.auteurName = auteurName;
	}
	
	public int getPrix() {
		return prix;
	}
	
	public void setPrix(int prix) {
		this.prix=prix;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	
	
}
