package com.edvantis.jt.case14.model.workers;

import com.edvantis.jt.case14.model.data.Order;

/**
 *  Abstract class for operators.
 *  they can create new order
 * 
 *
 */



public abstract class OperatorAbstract extends Worker {

	private static final long serialVersionUID = 1677387747829483850L;


	abstract public Order orderCreate();
	abstract public void orderGetList();
	abstract public void orderChange(int orderNumber);
	
	
	abstract public void makeReport();
}
