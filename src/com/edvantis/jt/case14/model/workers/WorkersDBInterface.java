package com.edvantis.jt.case14.model.workers;

import com.edvantis.jt.case14.exceptions.WorkerExceptions;



public interface WorkersDBInterface {

	public void workerAdd(Worker w) throws WorkerExceptions;
	public void workerDel(int id);
	public void workersPrint();
	
}
