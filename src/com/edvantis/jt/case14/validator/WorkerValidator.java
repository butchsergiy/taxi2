package com.edvantis.jt.case14.validator;

import com.edvantis.jt.case14.exceptions.WorkerExceptions;
import com.edvantis.jt.case14.model.workers.Worker;



public class WorkerValidator {
	
	
	public static void workerDataIsValid(Worker w) throws WorkerExceptions {
		
		try{
			
			if (w.getName()==null|| w.getName().isEmpty()){throw new WorkerExceptions(" Error. Worker without name.");} 
			if (w.getName().matches(".*\\d.*")) {
//				throw new WorkerExceptions(" Error = Name has digits. );
				System.out.println(" **Error = Name has digits. ("+w.getName()+"). But I pass this error for now");
			}
			
			System.out.println(" Name= "+w.getName() + " is valid. ");
			
// and mode and more more validation we can add here 
// for all fields of Worker object.
			
			}
		finally{}
					
			
	}
}
