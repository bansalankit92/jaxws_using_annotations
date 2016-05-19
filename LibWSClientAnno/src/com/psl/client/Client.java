
package com.psl.client;


import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import com.psl.service.LibServiceServiceStub;
import com.psl.service.LibServiceServiceStub.Book;
import com.psl.service.LibServiceServiceStub.BookList;
import com.psl.service.LibServiceServiceStub.BookListE;
import com.psl.service.LibServiceServiceStub.BookListResponse;
import com.psl.service.LibServiceServiceStub.BookListResponseE;
import com.psl.service.LibServiceServiceStub.GetBookNamebyID;
import com.psl.service.LibServiceServiceStub.GetBookNamebyIDE;
import com.psl.service.LibServiceServiceStub.GetBookNamebyIDResponse;
import com.psl.service.LibServiceServiceStub.GetBookNamebyIDResponseE;
import com.psl.service.LibServiceServiceStub.GetBookbyID;
import com.psl.service.LibServiceServiceStub.GetBookbyIDE;
import com.psl.service.LibServiceServiceStub.GetBookbyIDResponse;
import com.psl.service.LibServiceServiceStub.GetBookbyIDResponseE;





public class Client {

	public static void main(String[] args) {
		
		try {
			LibServiceServiceStub stub=new LibServiceServiceStub();
			System.out.println("******* Book name by ID***********");
			
			GetBookNamebyIDE gbne=new GetBookNamebyIDE();
			
			GetBookNamebyID gbid=new GetBookNamebyID();
			gbid.setId(2);
			
			gbne.setGetBookNamebyID(gbid);
			
			GetBookNamebyIDResponseE res=stub.getBookNamebyID(gbne);
			
			GetBookNamebyIDResponse res1=res.getGetBookNamebyIDResponse();
			
			
			System.out.println("book name : "+res1.get_return());
			
			
			
			System.out.println("\n*******List of Books***********");
			
			BookListE ble=new BookListE();
			
			BookList bl=new BookList();
			
			ble.setBookList(bl);;
			BookListResponseE brese=stub.bookList(ble);
			BookListResponse bres=brese.getBookListResponse();
			Book[] lb=bres.get_return();
			for(Book b:lb)
				System.out.println("name = "+b.getName()+" author="+b.getAuthor());
			
			
			
			
			System.out.println("\n*******Book details by ID***********");
			GetBookbyIDE gbide=new GetBookbyIDE();
			GetBookbyID gbid1=new GetBookbyID();
			gbid1.setId(2);
			
			gbide.setGetBookbyID(gbid1);
			GetBookbyIDResponseE rese=stub.getBookbyID(gbide);
			GetBookbyIDResponse gbidres=rese.getGetBookbyIDResponse();
			
			Book b=gbidres.get_return();
			
			System.out.println("book name : "+b.getAuthor());
			
			
		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
				
		}
		
	}

}
