package com.Model;

public class Compte {
	
	String name ;
	String last_name ;
	String email ;
	String password;
	
	
	

	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Compte(String name, String last_name, String email, String password) {
		super();
		this.name = name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getLast_name() {
		return last_name;
	}



	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}
	
	

	
}
