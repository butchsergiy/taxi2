package com.edvantis.jt.case14.exceptions;

public class WorkerExceptions extends Exception{

	private static final long serialVersionUID = 738626007350406826L;
	
	

	public WorkerExceptions(String s){
		System.out.println(" *** You entered new worker with mistakes." + s + " Please enter correct fields.");
	
		// we can add here more actions to do when Worker has bad data in his fields
		
	}
	
}
