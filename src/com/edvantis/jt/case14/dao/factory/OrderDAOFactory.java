package com.edvantis.jt.case14.dao.factory;

import com.edvantis.jt.case14.dao.OrderDAOabstract;
import com.edvantis.jt.case14.dao.hibernate.OrderDAOHibernate3;
import com.edvantis.jt.case14.dao.hibernate.OrderDAOHibernate;
import com.edvantis.jt.case14.dao.mysql.OrderDAOJBDC;

public class OrderDAOFactory {

	public static OrderDAOabstract getOrdersDbDAO(){
		
		final String ormType="hibernate";  // hibernate or JBDC
		
		if(ormType.equalsIgnoreCase("jdbc"))	 return OrderDAOJBDC.getReference();
		
		if(ormType.equalsIgnoreCase("hibernate")) return OrderDAOHibernate.getReference();	
		
		if(ormType.equalsIgnoreCase("hibernate3")) return OrderDAOHibernate3.getReference();  	// JUST FOR TESTING
		
		return null;
	}
	
}
