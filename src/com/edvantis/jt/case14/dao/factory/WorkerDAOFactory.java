package com.edvantis.jt.case14.dao.factory;

import com.edvantis.jt.case14.dao.WorkerDAOabstract;
import com.edvantis.jt.case14.dao.hibernate.WorkerDAOHibernate;


public class WorkerDAOFactory {

	public static WorkerDAOabstract getOrdersDbDAO(){
		
		final String ormType="hibernate";  // hibernate or JBDC
			
		if(ormType.equalsIgnoreCase("hibernate")) 	return WorkerDAOHibernate.getReference();	
		if(ormType.equalsIgnoreCase("jdbc"))	 	return WorkerDAOHibernate.getReference();	// must be WorkerDAOJDBC.getReference() but in future
		
		return null;
	}
	
}
