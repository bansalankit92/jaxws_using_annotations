package com.psl.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import com.psl.bean.Book;

@WebService(name="LibraryWS",serviceName="LibraryWS")
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL, parameterStyle=ParameterStyle.WRAPPED)
public interface ILibraryWS {

	@WebMethod(action="getBookNamebyID") String getBookNamebyID(@WebParam(name="id") int id);

	@WebMethod(action="addBook") boolean addBook(@WebParam(name="id")int id, @WebParam(name="name")String name, @WebParam(name="author")String author,
			@WebParam(name="price")double price,
			@WebParam(name="isbn")String isbn);

	@WebMethod(action="getBookbyID") Book getBookbyID(@WebParam(name="id")int id);

	@WebMethod(action="bookList") List<Book> bookList();

	@WebMethod(action="getBookbyName") Book getBookbyName(@WebParam(name="name")String name);

	@WebMethod(action="getBookbyNameOrID")Book getBookbyNameOrID(@WebParam(name="nameOrId")String arg);

}
