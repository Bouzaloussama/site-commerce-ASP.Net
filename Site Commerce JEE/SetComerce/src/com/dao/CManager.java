package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.Model.Book;
import com.Model.Compte;

public class CManager {
	
	public void AddBook(String FileName ,String bookName,String auteurName, int prix) {
		DBInteraction.connect();
		 int idmax = CManager.maxIdTable("book");
		 int id = idmax +1 ;
		String sql="insert into book values('"+id+"','"+bookName+"','"+auteurName+"','"+prix+"')";
		DBInteraction.Update(sql);
		DBInteraction.deconnect();
	}
	
	
	public Book FindBook(String nameBook){
		DBInteraction.connect();
        String sql="select * from book where name like lower('"+nameBook+"%')";
		Book c = null;
		ResultSet rs = DBInteraction.Select(sql);
		try {
			if(rs.next())
			{
				c = new Book();
				c.setId( rs.getInt(1));
				c.setBookName( rs.getString(2));
				c.setAuteurName( rs.getString(3));
				c.setPrix( rs.getInt(4));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return c ;
	}
	
	
	public Book FindBookById(int id){
		DBInteraction.connect();
        String sql="select * from book where id='"+id+"'";
		Book c = null;
		ResultSet rs = DBInteraction.Select(sql);
		try {
			if(rs.next())
			{
				c = new Book();
				c.setBookName( rs.getString(2));
				c.setAuteurName( rs.getString(3));
				c.setPrix( rs.getInt(4));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return c ;
	}
	
	public void AddIndex(String adr, int nouvel) {
		DBInteraction.connect();
		int ancien = 0;//CManager.conteur(adr);
		double pri =  ((nouvel - ancien)*1.3157 + 12.30) ;
		String sql="update lydic set index_ancien='"+ancien+"',index_nouvel='"+nouvel+"',pri='"+pri+"' where adrees='"+adr+"'";
		DBInteraction.Update(sql);
		DBInteraction.deconnect();
	}
	
	
	/*public Home Authentificate(String adr) {
		Home c=null;
		DBInteraction.connect();
		String sql="select * from lydic where adrees='"+adr+"'";
		
		ResultSet rs = DBInteraction.Select(sql);
		try {
			if(rs.next())
			{
				c=new Home();
				c.setAdresse(rs.getString(1));
				c.setAndex_ancien(rs.getInt(2));
				c.setAndex_nouvel(rs.getInt(3));
				c.setPri(rs.getDouble(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}*/
	
	
	public static int maxIdTable(String table){
		DBInteraction.connect();
        String sql="select * from "+table+" where id= (select Max(id) from "+table+")";
		int c = 0;
		ResultSet rs = DBInteraction.Select(sql);
		try {
			if(rs.next())
			{
				
				c = rs.getInt(1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return c ;
	}

	
	//###############################  for compte ####################################
	
	public void  Register(String name, String last_name,String tell,String email,String password) {
		DBInteraction.connect();
	
		String sql="insert into compte1 (name,last_name,tell,email,password) values('"+name+"','"+last_name+"','"+tell+"','"+email+"','"+password+"')";
		DBInteraction.Update(sql);
		DBInteraction.deconnect();
	}
	
	
	public Compte Authentificate(String log, String pass) {
		Compte c=null;
		DBInteraction.connect();
		String sql="select * from compte1 where email='"+log+"' and password='"+pass+"'";
		
		ResultSet rs = DBInteraction.Select(sql);
		try {
			if(rs.next())
			{
				c=new Compte();
				c.setName(rs.getString(2));
				c.setLast_name(rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}
	
	
	public String FindType(String log, String pass) {
		DBInteraction.connect();
		String sql="select * from compte1 where email='"+log+"' and password='"+pass+"'";
		String c = "" ;
		ResultSet rs = DBInteraction.Select(sql);
		try {
			if(rs.next())
			{
				
				
				c = rs.getString(7);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}
  //############################# for Panier ############################
	
	public void AddBookToPanier(String bookName,String auteurName, int prix) {
		DBInteraction.connect();
		int nb=1;
		String sql="insert into panier (name,auteur,prix,compt) values('"+bookName+"','"+auteurName+"','"+prix+"','"+nb+"')";
		DBInteraction.Update(sql);
		DBInteraction.deconnect();
	}
	
	public void DeletBookPanier(int id) {
		DBInteraction.connect();
		
		String sql="delete from panier where id='"+id+"'";
		DBInteraction.Update(sql);
		DBInteraction.deconnect();
	}
	
	public int TotalPrixe(){
		DBInteraction.connect();
        String sql="select SUM(prix) from panier";
		int c = 0;
		ResultSet rs = DBInteraction.Select(sql);
		try {
			if(rs.next())
			{
				
				c = rs.getInt(1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return c ;
	}

}
