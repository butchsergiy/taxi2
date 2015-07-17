package com.edvantis.jt.case14.model.data;

import com.edvantis.jt.case14.exceptions.OrderException;



public interface OrdersDBInterface {
	
	public void orderAdd(Order order) throws OrderException;
	public void orderDel(int number);
	public Order orderGet(int number);
	public Order orderSet(int number);
	
	
	

}
