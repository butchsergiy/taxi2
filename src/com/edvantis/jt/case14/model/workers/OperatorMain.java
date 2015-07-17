package com.edvantis.jt.case14.model.workers;

import java.time.Period;
import com.edvantis.jt.case14.model.data.OrdersDB;



public class OperatorMain extends OperatorSimple{

	private static final long serialVersionUID = 1190464896713530329L;
	
	OrdersDB 	o =	OrdersDB.getReference();
	
	public void orderDel(int id){
		o.orderDel(id);
		
	}
	
	
	
	// Main operator can olso print report for some period, e.g. day, week... 	
	public void makeReport(Period p) {
		// future will show if we do need this method
	}
}
