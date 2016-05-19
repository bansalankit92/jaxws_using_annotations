package com.psl.dao;

import java.util.List;

import com.psl.bean.Book;

public interface IDAOLibrary {

	void addBooksToDB(String  fileName);
	boolean addBookToDB(Book b);
	List<Book> getBooksList();
	
	Book getBookByName(String name);
	Book getBookByID(int id);
	
}
