package assign251_1.s16030627;

import static org.junit.Assert.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.apache.log4j.Appender;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.TTCCLayout;
import org.apache.log4j.spi.LoggingEvent;



public class appenderTests {
	
	private Logger dlogger = Logger.getLogger("dLogger");
	private MemAppender memAppend;
	private VelocityLayout velocityLayout;
	private ConsoleAppender consoleAppender;
	private FileAppender fileAppender;
	private List<LoggingEvent> logs;
		
	
	@Before
	public void setUp() throws Exception {
		BasicConfigurator.configure();
		velocityLayout = new VelocityLayout("[%-5p] %d %c - %m%n\r\n");
		consoleAppender = new ConsoleAppender();
		memAppend = MemAppender.getInstance();
		
	}
	
	@After
	public void tearDown() throws Exception {
		dlogger = null;
		consoleAppender = null;
		fileAppender = null;
		memAppend = null;
	}
	
	// ------------------------ Appender Tests ------------------------
	
	
	
	@Test
	public void memAppendMaxSizeTest()
	{

		memAppend.setMaxSize(2000);
		assertEquals(memAppend.getMaxSize(), 2000);
	}
	
	@Test
	public void memAppendListConstructorTest()
	{
		memAppend = null;
		LinkedList<LoggingEvent> list = new LinkedList<LoggingEvent>();
		memAppend = MemAppender.getInstance(list);
		assertEquals(memAppend.getLogList(), list);
	}
	
	@Test
	public void discardAndAppendLogTest()
	{
			
		LoggingEvent event1 = new LoggingEvent("thisCategory", dlogger, Level.WARN, "This is event 1", null);
		LoggingEvent event2 = new LoggingEvent("thisCategory", dlogger, Level.WARN, "This is event 2", null);
		memAppend.setMaxSize(2);
		memAppend.append(event1);
		memAppend.append(event2);
		
		assertEquals(memAppend.getDiscardedLogCount(), 1);
		assertEquals(memAppend.getCurrentLogs().get(0), event1);
		
	}
	
	@Test 
	public void requiredLayoutTest()
	{
		assertFalse(memAppend.requiresLayout());
	}
	
	// ------------------------ Layout Tests ------------------------
	
	@Test
	public void formatTest()
	{
		LoggingEvent eventToFormat = new LoggingEvent("thisCategory", dlogger, Level.WARN, "This is an event to format", null);
		assertEquals(velocityLayout.format(eventToFormat), ("Logger : " + eventToFormat.getLogger() + " toString : " + eventToFormat.toString() + " Message : " + eventToFormat.getMessage() + " Level : " + eventToFormat.getLevel() + " ThreadName : " + eventToFormat.getThreadName() + "\n"));
		
	}
	
	
	
	
	
	
	
	
	
}
