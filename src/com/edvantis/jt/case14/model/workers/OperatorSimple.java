package com.edvantis.jt.case14.model.workers;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.edvantis.jt.case14.model.data.Order;


public class OperatorSimple extends OperatorAbstract {

	private static final long serialVersionUID = 6453675309100331512L;

	// temporary method that simulares how operator creates new TaxiOrder
	public static Order orderCreateTemp() {

		Order o = new Order();

		// data generator

		o.setDateAndTime(Timestamp.valueOf(LocalDateTime.now()));
		o.setId((int)(Math.random() * 1000));
		o.setAddr1("From: Volodymyra " + ((int) (Math.random() * 200)));
		o.setAddr2("To: Chernivetska " + ((int) (Math.random() * 200)));
		o.setDistance((int) (Math.random() * 1000));
		o.setOrderCost((int) (Math.random() * 1000));
		o.setCustomerPhone(Integer.toString((int) (Math.random() * 10000000)));
		o.setCarNumber("BC"+Integer.toString((int) (Math.random() * 100000))+"AA");
		o.setCarDriver("Vasil_" + ((int) (Math.random() * 100)));
		o.setIsDone(true);
		
		return o;
	}
		
		
	@Override
	public Order orderCreate() {

		return null;	
	}
		
	
	
	public void orderGetList() {
			
	}

	
	public void orderChange(int orderNumber) {
				
	}
	
	
	public void makeReport() {
			
	}



}
