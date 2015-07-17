package com.edvantis.jt.case14.exceptions;


public class OrderException extends Exception{
	
	private static final long serialVersionUID = 5493244124652225822L;

	
	public OrderException(String s) throws OrderException{
		super(s);
		System.out.println(" You entered new order with mistakes. " + s + " Please enter correct fields.");
		
		throw this;
		// we can add here more actions to do when new Order has bad data in his fields
	}
	
	public OrderException(){
		
	}
	
}
