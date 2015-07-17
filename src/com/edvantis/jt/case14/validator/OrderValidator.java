package com.edvantis.jt.case14.validator;

import com.edvantis.jt.case14.exceptions.OrderException;
import com.edvantis.jt.case14.model.data.Order;

public class OrderValidator {

	public static void orderDataIsValid (Order o) throws OrderException {
		
		try{
			
			if (o.getAddr1()==null || o.getAddr1().isEmpty() || o.getAddr2()== null || o.getAddr2().isEmpty() || 
				o.getCustomerPhone()== null ||o.getCustomerPhone().isEmpty()){throw new OrderException(" Error. Order without full information (addr1 or addr2 or CustomerPhone).");} 
			
			if ((!o.getCustomerPhone().matches("[0-9]+")) || (13 < o.getCustomerPhone().length()) || (o.getCustomerPhone().length() < 7))
				{throw new OrderException("Order ID: "+o.getId()+" has Error = Customer number is faulty. ("+o.getCustomerPhone()+"). Must contains more than 7 digits");} 
			
			if (o.getAddr1().length()>45) {throw new OrderException("Addr1 is too long. Must be less than 45 symbols");}
			if (o.getAddr2().length()>45) {throw new OrderException("Addr2 is too long. Must be less than 45 symbols");}
			if ((o.getAddr34()!=null)&&(o.getAddr34().length()>45)) {throw new OrderException("Addr34 is too long. Must be less than 45 symbols");}
			if ((o.getCustomerName()!=null)&&(o.getCustomerName().length()>45)) {throw new OrderException("CustomerName is too long. Must be less than 45 symbols");}
			if ((o.getCarDriver()!=null)&&(o.getCarDriver().length()>45)) {throw new OrderException("CarDriver is too long. Must be less than 45 symbols");}
			if ((o.getCarNumber()!=null)&&(o.getCarNumber().length()>12)) {throw new OrderException("CarNumber is too long. Must be less than 12 symbols");}

						
// and mode and more more validation we can add here 
// for all fields of Order object.
			
			}
		finally{}
					
			
	}
}
