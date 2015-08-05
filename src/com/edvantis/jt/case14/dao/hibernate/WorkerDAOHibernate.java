package com.edvantis.jt.case14.dao.hibernate;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.edvantis.jt.case14.dao.WorkerDAOabstract;
import com.edvantis.jt.case14.exceptions.WorkerExceptions;
import com.edvantis.jt.case14.model.workers.Worker;
import com.edvantis.jt.case14.model.workers.WorkersDB;


public class WorkerDAOHibernate extends WorkerDAOabstract {

	// Singleton creation with Initialization-on-demand and classHolder idiom
	private WorkerDAOHibernate(){}		
	private static class SingletonHolder{private static final WorkerDAOHibernate INSTANCE = new WorkerDAOHibernate();}
	public static WorkerDAOHibernate getReference(){return SingletonHolder.INSTANCE;}	
	
	
	WorkersDB ordersDB0 = WorkersDB.getReference();

	private static final Log log = LogFactory.getLog(WorkerDAOHibernate.class);

	private static SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			if (sessionFactory == null) {
				Configuration configuration = new Configuration().configure();
				StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties());
				SessionFactory sessionFactory = configuration
						.buildSessionFactory(serviceRegistryBuilder.build());
				return sessionFactory;
			}
			return sessionFactory;
		} catch (Throwable ex) {
			System.err
					.println(" \nXxXXxxxxXXXxxx Initial SessionFactory creation failed."
							+ ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		getSessionFactory().close();
	}

	Session session = null;

	Transaction transaction = null;
	   		
	
	/*
	 * WORKS
	 */
	@Override
	public Worker readById(int id) {
		log.debug("getting Worker instance with id: " + id);
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			Worker instance = (Worker) session.get(
					"com.edvantis.jt.case14.model.data.Worker", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	/*
	 * WORKS
	 */
	@Override
	public void createWorker(Worker w) {
		try {
			session = sessionFactory.openSession();			
			transaction = session.beginTransaction();
			session.save(w);
			session.flush();
			transaction.commit();
			System.out.println("Worker is Saved");
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
		  finally{			  
	        session.close();        
	    }
	    }
		
		
	/*
	 * WORKS
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void readAllWorkers() {
		System.out.println("*** Reading all records from DB ...");
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		Worker w;
		try {
			List orderss = session.createQuery("FROM Worker").list();
			for (Iterator it = orderss.iterator(); it.hasNext();) {
				w = (Worker) it.next();
				ordersDB0.workerAdd(w);
				System.out.println("\tWorker (" + w.getId() + ") \tName: "
						+ w.getName() + ". \tBirthday: " + w.getBirthDate()
						+ ". \tPosition: " + w.getPosition());
			}
			transaction.commit();
		} catch (RuntimeException  re) {
			log.error("attach failed", re);
			System.out.println(re.getMessage());
			
		} catch (WorkerExceptions re) {
			log.error("attach failed", re);
			System.out.println(re.getMessage());
		} finally {
			session.close();
		}
	}
		
		
	/*
	 * WORKS
	 */
	@Override
	public void delWorker(int id) {
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			Worker w = (Worker) session.get(Worker.class, id);

			System.out.print("Deleting Worker #" + id + " ... ");

			if (w == null) {
				log.debug("get successful, no instance found");
				System.out.println("get successful, no instance found in DB");
			} else {
				session.delete(w);
				transaction.commit();
				log.debug("get successful, instance found and deleted");
				System.out
						.println("get successful, instance found and deleted from DB");
			}

		} catch (RuntimeException re) {
			log.error("del failed", re);
			System.out.println("del failed" + re.getMessage());
			throw re;
		}
	}
	
	@Override
	public void updateWorker(int id) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void updateWorker(Worker w) {
		// TODO Auto-generated method stub
	}
	
	
	@Override
	public void closeSessionFactory() {
		sessionFactory.close();
	}
	
	
	

	
	
}

// MySQL
//CREATE TABLE `taxiservice`.`workersdb` (
//		  `id` INT NOT NULL,
//		  `name` VARCHAR(45) NULL,
//		  `position` VARCHAR(45) NULL,
//		  `birthDate` DATE NULL,
//		  `accessLevel` INT NULL,
//		  `carNumber` VARCHAR(45) NULL,
//		  `password` VARCHAR(45) NULL,
//		  `logget` BIT(1) NULL,
//		  PRIMARY KEY (`id`));

//INSERT INTO `taxiservice`.`workersdb` (`id`, `name`, `position`, `birthDate`, `accessLevel`, `carNumber`, `password`, `logget`) VALUES ('1', 'Vol Ivanovich Tut', 'Operator_simple', '1950-01-01', '1', ' ', '1', false);
