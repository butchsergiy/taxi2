package com.edvantis.jt.case14.model.data;

import java.util.LinkedList;
import java.util.List;
import com.edvantis.jt.case14.exceptions.OrderException;
import com.edvantis.jt.case14.validator.OrderValidator;



public class OrdersDB implements OrdersDBInterface{

	private static final OrdersDB s=new OrdersDB();			// Singleton 
	private List<Order> orders=new LinkedList<Order>();
		
		
// constructor  
	private OrdersDB(){
		
	}
	
	public static OrdersDB getReference(){
		return s;
	}

	
/*
 *  to do method - for that case when we need to work 
 * with data of specific period
 * public OrdersDB getOrdersForPeriod(LocalDate Date1, LocalDate Date2) {..}	
 */
	
	public int getOrdersDBSize(){
		return s.orders.size();
	}
	
	
	public void resetOrdersDB(){
		s.orders = new LinkedList<Order>();
	}
		
	
	public void orderAdd(Order order) throws OrderException {
		OrderValidator.orderDataIsValid(order);
		orders.add(order);
	}

	
	public void orderDel(int id) {
		for(Order o: orders){
			if (o.getId()==id) orders.remove(o);
		}
				
	}


	@Override
	public Order orderGet(int id) {
		for(Order o: orders){
			if(o.getId()==id) return o;
		}
		return null;	
	}


	@Override
	public Order orderSet(int number) {
		return null;		
	}

	
	public void printAll(){
		for(int i=0; i<orders.size(); i++){
			System.out.println();
			System.out.println("Order ID= "+orders.get(i).getId());
			System.out.println(orders.get(i).getDateAndTime());
			System.out.println(orders.get(i).getAddr1());
			System.out.println(orders.get(i).getAddr2());
			System.out.println(" km:\t"+orders.get(i).getDistance());
			System.out.println(" grn: \t"+orders.get(i).getOrderCost());
			System.out.println(" (phone) \t"+orders.get(i).getCustomerPhone());
			System.out.println(" car driver: \t"+orders.get(i).getCarDriver()); 
			System.out.println(" car number: \t"+orders.get(i).getCarNumber());
			System.out.println(" is done: \t"+orders.get(i).getIsDone());
			
		}
	}
	
	
	

	
}
