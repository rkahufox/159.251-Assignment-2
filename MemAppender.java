package assign251_1.s16030627;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

public class MemAppender extends AppenderSkeleton{

	
	private static MemAppender myAppender = null;
	private static List<LoggingEvent> logs = new ArrayList<LoggingEvent>();
	private static int maxSize, appendedEvents, discardedLogs;
	
	protected MemAppender()
	{						
		//Cannot create class unless through initialise method.
	}
	
	
	public static MemAppender initialise() {
	      if(myAppender == null) {
	         MemAppender myAppender = new MemAppender();       //Singleton pattern to ensure only one instance.
	      }
	      return myAppender;
	   }
	
	
	@Override
	public void close() {
		
	}


	@Override
	protected void append(LoggingEvent eventToLog) {
		logs.add(eventToLog);
		appendedEvents++;
		if(appendedEvents == maxSize)
		{
			logs.remove(logs.size()-1);	
			discardedLogs++;
		}
		
	}


	@Override
	public boolean requiresLayout() {
		return false;
	}

	
	protected java.util.List<org.apache.log4j.spi.LoggingEvent> getCurrentLogs()
	{
		List<LoggingEvent> returnList = (List<LoggingEvent>) java.util.Collections.unmodifiableList(logs);
		return returnList;
	}
	
	protected long getDiscardedLogCount()
	{	
		return (long)discardedLogs;
	}
	
	
	
}
