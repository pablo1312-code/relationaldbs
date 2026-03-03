package relationaldbs;



import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
/**
 * 
 * @author panblo
 * 3 mar 2026
 */


public class LoggingTest {
	/**
	 * Static members of a class have only one copy in the memory no matter
	 * how many objects of the class we have created 
	 * A final variables value can not be modified 
	 */
	
	
private final static Logger logger = (Logger) LoggerFactory.getLogger(LoggingTest.class); 
	public static void main(String[] args) {
	
//		logger.setLevel(Level.TRACE);
//	    logger.setLeveL(Level.DEBUG);
//	    Logger.setLeveL(Level.INFO);
//	    Logger.setLeveL(Level.WARN);
//	    Logger.setLeveL(Level.ERROR);
		division(20, 0);
	}
	
	private static void division(int i, int j) {
		//this level of information has less importance 
		logger.trace("trace info-very detailed info: You have entered the method division");
		//We use this level of information for test 
		logger.debug("test info: division method test");
		//We use this level of log for normal and general information 
		logger.info("main general info to show our app is running normally");
		//We use this level of log for potential problems 
		logger.warn("unexpected problem but not vital");
		//This is for errors 
		logger.error("serious problem that should be resolved");
		if(j== 0) {
			logger.info("the user has pass a zero as dividend");
			return;
		}
		try {
			int result= i/j;
			logger.info("the result is :" + result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
