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
	
	private Logger logger;
	private Logger fileLoggerVelocity;
	private Logger fileLoggerPattern;
	private List<LoggingEvent> logs;
	private MemAppender memAppender;
	private ConsoleAppender consoleAppender;
	private FileAppender fileAppender;
	private VelocityLayout velocityLay;
	
	@Before
	public void setup()
	{
		BasicConfigurator.configure();
		logger = Logger.getLogger("LOGGER");
		fileLoggerVelocity = Logger.getLogger("FILE_LOGGER_VELOCITY");
		fileLoggerPattern = Logger.getLogger("FILE_LOGGER_PATTERN");
		velocityLay = new VelocityLayout();
		memAppender = MemAppender.getInstance();
		
		
	
	}
	
	@After
	public void tearDown()
	{
		logs = null;
		logger = null;
		fileLoggerVelocity = null;
		fileLoggerPattern = null;
		memAppender = null;
		consoleAppender = null;
		fileAppender = null;
		velocityLay = null;
		System.gc();
		
	}
	
//	@Test
//	public void linkedListTest()
//	{
//		logs = new LinkedList<LoggingEvent>();
//		memAppender  = MemAppender.getInstance(logs);
//		logger.addAppender(memAppender);
//		memAppender.setMaxSize(100005);
//		
//		for(int i = 0; i < 100000; i++)
//		{
//			logger.warn("Linked list stress test hello");
//		}
//			
//	}
//
	@Test
	public void linkedListMaxSizeTest()
	{   
		logs = new LinkedList<LoggingEvent>();
		memAppender  = MemAppender.getInstance(logs);
		logger.addAppender(memAppender);
		memAppender.setLayout(velocityLay);
		memAppender.setMaxSize(1);
		
		for(int i = 0; i < 100000; i++)
		{
			logger.warn("Linked list stress test maxsize");
		}
	}
//	
//	
//	
//	@Test
//	public void arrayListTest()
//	{
//		logger.addAppender(memAppender);
//		memAppender.setLayout(new org.apache.log4j.PatternLayout()); 
//		memAppender.setMaxSize(100000);
//		
//		
//		
//		consoleAppender = new ConsoleAppender();
//		consoleAppender.setLayout(velocityLay);
//	
//		for(int i = 0; i < 100000; i++)
//		{
//			logger.log(Level.WARN, "Array list stress test");
//		}
//	 	
//	}
//	
//	
//	@Test
//	public void arrayListMaxSizeTest()
//	{
//		logger.addAppender(memAppender);
//		memAppender.setLayout(new org.apache.log4j.PatternLayout()); 
//		memAppender.setMaxSize(1);
//		
//		
//		
//		consoleAppender = new ConsoleAppender();
//		consoleAppender.setLayout(velocityLay);
//	
//		for(int i = 0; i < 100000; i++)
//		{
//			logger.log(Level.WARN, "Array list stress test");
//		}
//	 	
//	}
//	
//	
//	@Test
//	public void consoleAppenderWithVelocityLayoutTest()
//	{
//		consoleAppender = new ConsoleAppender();
//		logger.addAppender(consoleAppender);
//		consoleAppender.setLayout(velocityLay);
//		
//		for(int i = 0; i < 100000; i++)
//		{
//			logger.log(Level.WARN, "Console appender (velocity layout) stress test");
//		}
//		
//	}
//	
//	
//	@Test
//	public void consoleAppenderWithPatternLayoutTest()
//	{	
//		consoleAppender = new ConsoleAppender();
//		logger.addAppender(consoleAppender);
//		consoleAppender.setLayout(new org.apache.log4j.PatternLayout());
//		
//		for(int i = 0; i < 100000; i++)
//		{
//			logger.log(Level.WARN, "Console appender (pattern layout) stress test");
//		}
//		
//	}
//
//	
//	@Test
//	public void fileAppenderWithVelocityLayoutTest() throws IOException
//	{   
//		fileAppender = new FileAppender();		
//		fileLoggerVelocity.addAppender(new org.apache.log4j.FileAppender(velocityLay, "velocityLayoutLogs.txt", false));
//		for(int i = 0; i < 100000; i++)
//		{
//			fileLoggerVelocity.log(Level.WARN, "File appender (velocity layout) stress test");
//			
//		}
//		
//}	
//	
//	
//	@Test
//	public void fileAppenderWithPatternLayoutTest() throws IOException
//	{   
//		fileAppender = new FileAppender();		
//		fileLoggerPattern.addAppender(new org.apache.log4j.FileAppender(new org.apache.log4j.PatternLayout(), "patternLayoutFileLogs.txt"));
//      
//	    
//		for(int i = 0; i < 100000; i++)
//		{
//			fileLoggerPattern.log(Level.WARN, "File appender (pattern layout) stress test");
//		}
//		
//}				
	
		
		
}	
