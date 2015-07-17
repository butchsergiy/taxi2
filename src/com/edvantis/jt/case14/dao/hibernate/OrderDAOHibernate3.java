package com.edvantis.jt.case14.dao.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.edvantis.jt.case14.dao.OrderDAOabstract;
import com.edvantis.jt.case14.model.data.Order;

public class OrderDAOHibernate3 extends OrderDAOabstract {
		
//	Session s = sf.openSession();
//	Transaction tx = s.beginTransaction();
//	
//	Order o = new Order();
//	o = OperatorSimple.orderCreateTemp();
//	try {OrderValidator.orderDataIsValid(o);} catch (OrderException e) {e.printStackTrace();}
//	
//	s.save(o);
//	s.flush();
//	tx.commit();
//	s.clear();
//	sf.close();
	
	// Private constructor for Singleton
	private OrderDAOHibernate3(){
		}		
	
	public static OrderDAOHibernate3 getReference(){
		return singleton;
	}
	
	private static final OrderDAOHibernate3 singleton = new OrderDAOHibernate3();   		// Singleton
	
	Configuration cfg = new Configuration();
	
	{cfg.configure();}  //"hibernate2.cfg.xml"
	
	
	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
	SessionFactory sf = cfg.buildSessionFactory(serviceRegistry);
	
	
	
	
	/* 
	 * Method to CREATE an order in the database 
	 */
	@Override
	public void addToOrdersDB(Order o) {
	      Session session = sf.openSession();
	      Transaction tx = null;
	      
	      try{
	         tx = session.beginTransaction();
	         
//	         ID = (Integer) session.save(o); 
	         session.save(o);
	         
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }

	
	
	   /* Method to  READ all orders from DB MySQL *///////////////////////////////////////xxxxxxxxxxxxxxxxxxxxxxxxxXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
	@Override
	public void readAllordersDB() {
//	      Session session = sf.openSession();
//	      Transaction tx = null;
//	      OrdersDB orderDB = OrdersDB.getReference();
//	      
//	      try{
//	         tx = session.beginTransaction();
//	         List<Order> list = session.createQuery("FROM ordersdb").list();    //////////////?????????????   org.hibernate.hql.internal.ast.QuerySyntaxException: ordersdb is not mapped [FROM ordersdb]
//	         
//	        
//	         for (Iterator iterator = list.iterator(); iterator.hasNext();){
//	            Order o = (Order) iterator.next(); 
//	            orderDB.orderAdd(o);
//	            System.out.println("Order # " + o.getId()); 
//	            System.out.println("Order time: " + o.getDateAndTime()); 
//	            System.out.println("Order Addres" + o.getAddr1()); 
//	            System.out.println("Order Addres" + o.getAddr2());
//	         }
//	         tx.commit();
//	      }catch (HibernateException | OrderException e) {
//	         if (tx!=null) tx.rollback();
//	         e.printStackTrace(); 
//	      }finally {
//	         session.close(); 
//	      }
	   }
	   
	   
	   
	   /* Method to UPDATE order */
	   @Override
//		public void updateOrder(int id) {
		public void updateOrder(Order order) {
	      Session session = sf.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         Order or =(Order)session.get(Order.class, order.getId());   /////xxxxxxxxxxxxxxxxxxxxxxxxxxx
	         session.update(or); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }
	   
	   
	   	@Override
	public void updateOrder(int id) {
		// TODO Auto-generated method stub
		
	}
	   
	   
	   /* Method to DELETE an order from the records */
	   @Override
		public void delOrder(int id){
	      Session session = sf.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         Order order = (Order)session.get(Order.class, id); 
	         session.delete(order); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }
	   
	   






	



	

	
	
	
}

