package com.psl.controller;


import java.io.IOException;
import java.rmi.RemoteException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.axis2.AxisFault;

import com.psl.service.LibServiceServiceStub;
import com.psl.service.LibServiceServiceStub.AddBook;
import com.psl.service.LibServiceServiceStub.AddBookE;
import com.psl.service.LibServiceServiceStub.AddBookResponse;
import com.psl.service.LibServiceServiceStub.AddBookResponseE;

/**
 * Servlet implementation class AddBookServlet
 */


@WebServlet(name="AddBookServlet", urlPatterns={"/addBook","/AddBookServlet"})
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AddBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			LibServiceServiceStub stub=new LibServiceServiceStub();
			AddBookE abe=new AddBookE();
			
			AddBook ab=new AddBook();
			ab.setId(Integer.parseInt(request.getParameter("id")));
			ab.setName(request.getParameter("name").trim());
			ab.setAuthor(request.getParameter("author").trim());
			ab.setIsbn(request.getParameter("isbn").trim());
			ab.setPrice(Double.parseDouble(request.getParameter("price").trim()));
		
			abe.setAddBook(ab);
		
			AddBookResponseE rese=stub.addBook(abe);
			
			AddBookResponse res=rese.getAddBookResponse();
			boolean o=res.get_return();
			//System.out.println();
			if(o)
				response.getWriter().println("Book Added Successfully\n\n\n go to link http://localhost:8080/LibraryWSClient/addBook.jsp ");	
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
		
		}
	}

}
