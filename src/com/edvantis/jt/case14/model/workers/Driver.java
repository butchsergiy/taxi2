package com.edvantis.jt.case14.model.workers;

import com.edvantis.jt.case14.model.data.OrdersDB;


public class Driver extends Worker{

	private static final long serialVersionUID = 8786415050168205592L;

	/**
	 * Driver can see his orders
	 */

	public void printThisDriverOrders() {
		OrdersDB o=OrdersDB.getReference();
		
		for(int i=0; i<o.getOrdersDBSize(); i++){
			if(o.orderGet(i).getCarDriver()==this.getName()){
				System.out.println("");
				System.out.println(" Order ID: \t" + o.orderGet(i).getId());
				System.out.println(" Order date: \t" + o.orderGet(i).getDateAndTime());
				System.out.println(" Order distance: \t" + o.orderGet(i).getDistance());
				System.out.println(" Order cost: \t" + o.orderGet(i).getOrderCost());
			}
						
		}
	}
	
}
