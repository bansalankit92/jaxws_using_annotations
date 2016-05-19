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
import com.psl.service.LibServiceServiceStub.Book;
import com.psl.service.LibServiceServiceStub.GetBookNamebyID;
import com.psl.service.LibServiceServiceStub.GetBookNamebyIDE;
import com.psl.service.LibServiceServiceStub.GetBookNamebyIDResponse;
import com.psl.service.LibServiceServiceStub.GetBookNamebyIDResponseE;
import com.psl.service.LibServiceServiceStub.GetBookbyID;
import com.psl.service.LibServiceServiceStub.GetBookbyIDE;
import com.psl.service.LibServiceServiceStub.GetBookbyIDResponse;
import com.psl.service.LibServiceServiceStub.GetBookbyIDResponseE;
import com.psl.service.LibServiceServiceStub.GetBookbyName;
import com.psl.service.LibServiceServiceStub.GetBookbyNameE;
import com.psl.service.LibServiceServiceStub.GetBookbyNameOrID;
import com.psl.service.LibServiceServiceStub.GetBookbyNameOrIDE;
import com.psl.service.LibServiceServiceStub.GetBookbyNameOrIDResponse;
import com.psl.service.LibServiceServiceStub.GetBookbyNameOrIDResponseE;
import com.psl.service.LibServiceServiceStub.GetBookbyNameResponse;
import com.psl.service.LibServiceServiceStub.GetBookbyNameResponseE;

/**
 * Servlet implementation class BookDetails
 */
@WebServlet(name = "BookDetails", urlPatterns = { "/BookDetails",
		"/bookDetails" })
public class BookDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			LibServiceServiceStub stub = new LibServiceServiceStub();
			// System.out.println("******* Book name by ID***********");

			/*
			 * String bookID=request.getParameter("id").trim(); GetBookbyIDE
			 * gbide=new GetBookbyIDE(); GetBookbyID gbid=new GetBookbyID();
			 * 
			 * GetBookbyNameE gbne=new GetBookbyNameE(); GetBookbyName gbn=new
			 * GetBookbyName(); Book b;
			 * 
			 * try{ int id= Integer.parseInt(bookID); gbid.setId(id);
			 * gbide.setGetBookbyID(gbid); GetBookbyIDResponseE
			 * res=stub.getBookbyID(gbide);
			 * 
			 * GetBookbyIDResponse res1=res.getGetBookbyIDResponse();
			 * b=(res1.get_return());
			 * 
			 * }catch(java.lang.NumberFormatException e){ gbn.setName(bookID);
			 * gbne.setGetBookbyName(gbn); GetBookbyNameResponseE
			 * gbnrespe=stub.getBookbyName(gbne); GetBookbyNameResponse
			 * gbnresp=gbnrespe.getGetBookbyNameResponse();
			 * b=gbnresp.get_return();
			 * 
			 * } if(b==null){
			 * 
			 * response.getWriter().println("no_book_found"); }else
			 * response.getWriter
			 * ().println(""+b.getId()+","+b.getName()+","+b.getAuthor
			 * ()+","+b.getPrice()+","+b.getIsbn());
			 */
			GetBookbyNameOrIDE gbnie = new GetBookbyNameOrIDE();
			GetBookbyNameOrID gbni = new GetBookbyNameOrID();
			gbni.setNameOrId(request.getParameter("id").trim());

			gbnie.setGetBookbyNameOrID(gbni);

			GetBookbyNameOrIDResponseE gbnieres = stub.getBookbyNameOrID(gbnie);
			GetBookbyNameOrIDResponse gbnires = gbnieres
					.getGetBookbyNameOrIDResponse();
			Book b = gbnires.get_return();
			if (b == null) {

				response.getWriter().println("no_book_found");
			} else
				response.getWriter().println(
						"" + b.getId() + "," + b.getName() + ","
								+ b.getAuthor() + "," + b.getPrice() + ","
								+ b.getIsbn());

		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
