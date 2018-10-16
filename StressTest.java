package assign251_1.s16030627;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.velocity.Template;
import java.io.StringWriter;




public class StressTest {
	
	private Logger logger = Logger.getLogger("LOGGER");
	private List<LoggingEvent> logs;
	private MemAppender memAppender;
	private ConsoleAppender consoleAppender;
	private FileAppender fileAppender;
	private VelocityLayout layout;
	
	@Before
	public void setup()
	{
		BasicConfigurator.configure();
		layout = new VelocityLayout();
			
	}
	
	@After
	public void tearDown()
	{
		logs = null;
		memAppender = null;
		consoleAppender = null;
		fileAppender = null;
		layout = null;
	}
	
//	@Test
//	public void linkedListTest()
//	{
//		
//		logs = new LinkedList<LoggingEvent>();
//		memAppender  = MemAppender.getInstance(logs);
//		logger.addAppender(memAppender);
//		memAppender.setLayout(layout);
//		
//		for(int i = 0; i < 1000000; i++)
//		{
//			logger.log(Level.WARN, "Linked list stress test");
//		}
//			
//	}
//	
//	
//	@Test
//	public void arrayListTest()
//	{
//		logs = new ArrayList<LoggingEvent>();
//		memAppender  = MemAppender.getInstance(logs);
//		logger.addAppender(memAppender);
//		memAppender.setLayout(layout); 
//		memAppender.setMaxSize(100000);
//		
//		
//		
////		consoleAppender = new ConsoleAppender();
////		consoleAppender.setLayout(layout);
////		
//		for(int i = 0; i < 1000000; i++)
//		{
//			logger.log(Level.WARN, "Array list stress test");
//		}
//	 	
//	}
//	
//	
//	@Test
//	public void consoleAppenderTest()
//	{
//		consoleAppender = new ConsoleAppender();
//		logger.addAppender(consoleAppender);
//		consoleAppender.setLayout(layout);
//		
//		for(int i = 0; i < 1000000; i++)
//		{
//			logger.log(Level.WARN, "Console appender stress test");
//		}
//		
//	}
	
	
	@Test
	public void fileAppenderTest() throws IOException
	{
		fileAppender = new FileAppender();		
		logger.addAppender(new org.apache.log4j.FileAppender(layout, "fileAppenderLogs.txt"));
//		fileAppender.setLayout(new org.apache.log4j.SimpleLayout());
//		fileAppender.setFile("theLogs.txt");
	
		for(int i = 0; i < 1000; i++)
		{
			logger.log(Level.WARN, "File appender stress test");
		}
		
}

	
	
	
	
	
	
	
	
	

}
