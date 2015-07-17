package com.edvantis.jt.case14.dao;

import com.edvantis.jt.case14.exceptions.OrderException;
import com.edvantis.jt.case14.model.data.Order;



public abstract class OrderDAOabstract {

	public abstract void addToOrdersDB(Order o);
	public abstract void readAllordersDB();
	public abstract void updateOrder(Order order) throws OrderException;
	public abstract void updateOrder(int id);
	public abstract void delOrder(int id);
	public void closeSessionFactory() {}
	public Order findById(int id) {return null;}

	
}
