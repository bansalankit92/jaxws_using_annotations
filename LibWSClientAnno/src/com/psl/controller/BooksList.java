package com.psl.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.psl.service.LibServiceServiceStub;
import com.psl.service.LibServiceServiceStub.Book;
import com.psl.service.LibServiceServiceStub.BookList;
import com.psl.service.LibServiceServiceStub.BookListE;
import com.psl.service.LibServiceServiceStub.BookListResponse;
import com.psl.service.LibServiceServiceStub.BookListResponseE;



/**
 * Servlet implementation class BooksList
 */

@WebServlet(name="BooksList", urlPatterns={"/BooksList","/booklist"})

public class BooksList extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BooksList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LibServiceServiceStub stub=new LibServiceServiceStub();
		BookListE ble=new BookListE();
		
		BookList bl=new BookList();
		
		ble.setBookList(bl);;
		BookListResponseE brese=stub.bookList(ble);
		BookListResponse bres=brese.getBookListResponse();
		Book[] lb=bres.get_return();
		
		for(Book b:lb)
			//response.getWriter().println(" *ID : "+b.getId()+" *Name : "+b.getName()+" *Author : "+b.getAuthor()+" *Price :"+b.getPrice()+" *ISBN : "+b.getIsbn()+"<br>");
		response.getWriter().println(""+b.getId()+","+b.getName()+","+b.getAuthor()+","+b.getPrice()+","+b.getIsbn()+":");

	}

}
