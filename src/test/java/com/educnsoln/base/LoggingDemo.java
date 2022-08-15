

package com.educnsoln.base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingDemo {

	// Looger level -
	
	//ALL – This level will prioritize and include everything in the logs.
	
	//trace-
	//DEBUG – This level will log debugging information.
	//INFO – This level will log the progress of the application.
	//WARN – This level will show information regarding warnings, that may not stop the execution but may still cause problems.
	//ERROR – This level will show messages that inform users about error events that may not stop the application.
	//FATAL – This will print information critical to the system that may even crash the application.
	
	static Logger log=LogManager.getLogger(LoggingDemo.class);
	
	public static void main (String [] args) {
		
		log.info("this is sample info");		
		log.info("this is info loogger");
		log.debug("this is debug loogger");
		log.warn("this is warn loogger");
		log.error("this is error loogger");
		log.fatal("this is fatal loogger");
		
		System.out.println("this is sample print");
	   }
  }

	
	
	
