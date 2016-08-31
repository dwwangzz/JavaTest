package log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Demo {
	
	//private static final Logger log = LogManager.getLogger(Demo.class.getName());
	private static final Logger log = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		/*Thread1 thread1 = new Thread1();
		Thread2 thread2 = new Thread2();
		thread1.start();
		thread2.start();*/
		
		test();
	}
	
	public static void test(){
		System.out.println(log.isDebugEnabled()+"/"+log.isErrorEnabled()+"/"+log.isWarnEnabled()+"/"+log.isInfoEnabled());
		log.trace("trace");
		log.debug("debug");
		log.info("info");
		log.warn("warn");
		log.error("error");
		log.fatal("fatal");
	}
}
