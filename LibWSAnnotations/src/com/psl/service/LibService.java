package com.psl.service;

import java.util.List;

import javax.jws.WebService;

import com.psl.bean.Book;
import com.psl.dao.DAOLibraryImpl;


@WebService(endpointInterface = "com.psl.service.ILibraryWS")
public class LibService implements ILibraryWS {
	DAOLibraryImpl imp = new DAOLibraryImpl();

	@Override
	public String getBookNamebyID(int id) {

		Book b = imp.getBookByID( id);
		if (b != null)
			return b.getName() + " **<br>  Author : " + b.getAuthor();
		else
			return "No Book Available With this ID";
	}

	@Override
	public boolean addBook(int id, String name, String author, double price,
			String isbn) {
		Book b = new Book(id, name, author, price, isbn);
		if (imp.addBookToDB(b))
			return true;

		return false;
	}

	@Override
	public Book getBookbyID(int id) {

		
		// System.out.println(l);
		// Book b = imp.getBookByID(l, id);
		return imp.getBookByID(id);

	}
	
	
	@Override
	public Book getBookbyName(String name) {
		return imp.getBookByName( name);
		
	}

	@Override
	public List<Book> bookList() {

		// List<Book> l = imp.getBooksList();
		// System.out.println(l);
		// Book b = imp.getBookByID(l, id);
		return imp.getBooksList();

	}
	
	
	@Override
	public Book getBookbyNameOrID(String arg) {
		try{
			int id=	Integer.parseInt(arg);
			return imp.getBookByID(id);
						
			}catch(java.lang.NumberFormatException e){
				
				return imp.getBookByName( arg);
			}
				
	}


}
