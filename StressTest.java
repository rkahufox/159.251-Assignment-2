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
	private VelocityLayout velocityLay;
	
	@Before
	public void setup()
	{
		BasicConfigurator.configure();
		velocityLay = new VelocityLayout();
			
	}
	
	@After
	public void tearDown()
	{
		logs = null;
		memAppender = null;
		consoleAppender = null;
		fileAppender = null;
		velocityLay = null;
	}
	
//	@Test
//	public void linkedListTest()
//	{
//		
//		logs = new LinkedList<LoggingEvent>();
//		memAppender  = MemAppender.getInstance(logs);
//		logger.addAppender(memAppender);
//		memAppender.setLayout(velocityLay);
//		
//		for(int i = 0; i < 1000; i++)
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
//		memAppender.setLayout(new org.apache.log4j.PatternLayout()); 
//		memAppender.setMaxSize(100000);
//		
//		
//		
//		consoleAppender = new ConsoleAppender();
//		consoleAppender.setLayout(velocityLay);
//	
//		for(int i = 0; i < 1000; i++)
//		{
//			logger.log(Level.WARN, "Array list stress test");
//		}
//	 	
//	}
	
	
	@Test
	public void consoleAppenderWithVelocityLayoutTest()
	{
		consoleAppender = new ConsoleAppender();
		logger.addAppender(consoleAppender);
		consoleAppender.setLayout(velocityLay);
		
		for(int i = 0; i < 100000; i++)
		{
			logger.log(Level.WARN, "Console appender (velocity layout) stress test");
		}
		
	}
//	
//	
//	@Test
//	public void fileAppenderWithVelocityLayoutTest() throws IOException
//	{
//		fileAppender = new FileAppender();		
//		logger.addAppender(new org.apache.log4j.FileAppender(velocityLay, "fileLogs.txt"));
//
//	
//		for(int i = 0; i < 1000; i++)
//		{
//			logger.log(Level.WARN, "File appender (velocity layout) stress test");
//		}
//		
//		
//		
//	
//		
//}

	@Test
	public void consoleAppenderWithPatternLayoutTest()
	{
		consoleAppender = new ConsoleAppender();
		logger.addAppender(consoleAppender);
		consoleAppender.setLayout(new org.apache.log4j.PatternLayout());
		
		for(int i = 0; i < 100000; i++)
		{
			logger.log(Level.WARN, "Console appender (pattern layout) stress test");
		}
	}
	
	
	
	
	
	
	

}
