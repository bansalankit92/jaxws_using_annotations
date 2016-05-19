package com.psl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.psl.bean.Book;
import com.util.IDBConnection;
import com.util.JDBCConnectionImpl;

public class DAOLibraryImpl implements IDAOLibrary {
	IDBConnection db = new JDBCConnectionImpl();
	public void addBooksToDB(String fileName) {

	}

	public List<Book> getBooksList() {
		
		Connection conn = null;
		conn = db.getConection();
		Statement ps = null;

		List<Book> retList = new ArrayList<Book>();

		try {
			ps = conn.createStatement();
			ResultSet rs = ps.executeQuery("select * from library");

			while (rs.next()) {
				Book b = new Book();
				b.setId(rs.getInt(1));
				b.setName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getDouble(4));
				b.setIsbn(rs.getString(5));
				//System.out.println(b);
				retList.add(b);
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			if (conn != null)
				db.closeConnection();
		}

		return retList;
	}

	@Override
	public Book getBookByID( int id) {
		Connection conn = null;
		conn = db.getConection();
		Statement ps = null;

		

		try {
			ps = conn.createStatement();
			ResultSet rs = ps.executeQuery("select * from library where id="+id);

			if(rs.next()){
				Book b = new Book();
				b.setId(rs.getInt(1));
				b.setName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getDouble(4));
				b.setIsbn(rs.getString(5));
				//System.out.println(b);
				return b;
			
			}return null;
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			if (conn != null)
				db.closeConnection();
		}
		
		
		return null;
	}

	public Book getBookByName(String name) {
		
		Connection conn = null;
		conn = db.getConection();
		Statement ps = null;

		

		try {
			ps = conn.createStatement();
			ResultSet rs = ps.executeQuery("select * from library where name='"+name+"'");

			if(rs.next()){
				Book b = new Book();
				b.setId(rs.getInt(1));
				b.setName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getDouble(4));
				b.setIsbn(rs.getString(5));
				//System.out.println(b);
				return b;
			
			}return null;
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			if (conn != null)
				db.closeConnection();
		}
		
		return null;
	}

	public boolean addBookToDB(Book b) {
		IDBConnection db = new JDBCConnectionImpl();
		Connection conn = null;
		conn = db.getConection();
		Statement ps = null;
		try {
			ps = conn.createStatement();
			
			ps.execute("insert into library values(" + b.getId() + ",'"
					+ b.getName() + "','" + b.getAuthor() + "'," + b.getPrice()
					+ ",'" + b.getIsbn() + "')");
			return true;

		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			if (conn != null)
				db.closeConnection();
		}
		return false;

	}

}
