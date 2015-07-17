package com.edvantis.jt.case14.controller;

import com.edvantis.jt.case14.dao.OrderDAOabstract;
import com.edvantis.jt.case14.dao.WorkerDAOabstract;
import com.edvantis.jt.case14.dao.factory.OrderDAOFactory;
import com.edvantis.jt.case14.dao.factory.WorkerDAOFactory;
import com.edvantis.jt.case14.exceptions.WorkerExceptions;
import com.edvantis.jt.case14.model.data.*;
import com.edvantis.jt.case14.model.workers.*;


public class TaxiService {

	public static void main(String[] args) {

		OrdersDB ordersDB0 = OrdersDB.getReference();	// instance of OrdersDB class in ram
		WorkersDB workersDB0 = WorkersDB.getReference();// instance of WorkersDB class in ram
		
		OrderDAOabstract ordersDAO = OrderDAOFactory.getOrdersDbDAO(); 		// instance of OrderDAO class for CRUD operations with MySQL
		WorkerDAOabstract workersDAO = WorkerDAOFactory.getOrdersDbDAO();	// instance of WorkerDAO class for CRUD operations with MySQL
		
/*
 * SIMULATION bussines logic with WORKERS
 */
		
		Manager man1=new Manager(1,"Vova Biggest Manager","Manager");		//create first manager, and only he has right to create and add new workers(operators and drivers)
		try{workersDB0.workerAdd(man1);} catch (WorkerExceptions e){}
		try{workersDB0.workerAdd(man1.workerCreateTemp()); }catch (WorkerExceptions e){}			// here I simulate how Manager adding of new worker(random)
		try{workersDB0.workerAdd(man1.workerCreateTemp()); }catch (WorkerExceptions e){}			// here I simulate how Manager adding of new worker(random)		 			
			
		workersDB0.workersPrint();
		System.out.println("------------------------------------");
		
		workersDAO.readAllWorkers();
		
		
		
		
/*
 * SIMULATION bussines logic with ORDERS 
 */
		System.out.println("\n----------------\n---- ORDERS ----");



		
				
// +Here I read all data from ordersDB table of database  
		ordersDAO.readAllordersDB();
		
			
// +Finding order ib MySQL DB by ID. WORKS
//		try {ordersDB0.orderAdd(ordersDBDAO.findById(1005));} catch (OrderException e) {e.printStackTrace();}
		
		
// +Deleting Order fromMySQL DB. WORKS
//		ordersDBDAO.delOrder(1005);
		
		System.out.println("------------------------------------");
		System.out.println("1. We already have " + ordersDB0.getOrdersDBSize() + " orders in RAM.");
		System.out.println("------------------------------------");
				
//		// just for testing. I simulate process of creating of order and adding that order to ordersDB. 
//		try {ordersDB0.orderAdd(OperatorSimple.orderCreateTemp());} catch (OrderException e) {}
//		try {ordersDB0.orderAdd(OperatorSimple.orderCreateTemp());} catch (OrderException e) {}
//		try {ordersDB0.orderAdd(OperatorSimple.orderCreateTemp());} catch (OrderException e) {}
//
		man1.doReportWithOrders();
		System.out.println("------------------------------------");
		System.out.println("2. We already have " + ordersDB0.getOrdersDBSize() + " orders in RAM.");
		System.out.println("------------------------------------");
		

// +Adding order to MySQL DB. WORKS
//		ordersDBDAO.addToOrdersDB(OperatorSimple.orderCreateTemp());
//		ordersDBDAO.addToOrdersDB(OperatorSimple.orderCreateTemp());
		
		
		
		ordersDAO.closeSessionFactory();
		workersDAO.closeSessionFactory();
			
	}
}
