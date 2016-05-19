package com.psl.client;

import javax.xml.ws.Endpoint;

import com.psl.service.LibService;

public class Client {

	public static void main(String[] args) {
		
		System.out.println("********");
		
		LibService ser=new LibService();
		//ser.addBook(2, "java4", "gosling4", 2200.50, "432qwe78946");
		
		//System.out.println(ser.getBookbyName("java4"));
		
		
		Endpoint endpoint=Endpoint.publish("http://localhost:8888/WS/library", new LibService());
		  
		 //endpoint.stop();
		System.out.println("**////////******");

	}

}
