package com.edvantis.jt.case14.dao;

import com.edvantis.jt.case14.model.workers.Worker;


public abstract class WorkerDAOabstract {

	public abstract void 	createWorker(Worker w);
	public abstract void 	readAllWorkers();	
	public abstract Worker 	readById(int id); 
	public abstract void 	updateWorker(Worker w);
	public abstract void 	updateWorker(int id);
	public abstract void 	delWorker(int id);
	
	public void closeSessionFactory() {}
	
}
