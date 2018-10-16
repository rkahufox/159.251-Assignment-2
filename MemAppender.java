package assign251_1.s16030627;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

public class MemAppender extends AppenderSkeleton{

	
	public static MemAppender defaultInstance = new MemAppender();
	private static List<LoggingEvent> logs = null;
	private static int maxSize, appendedEvents, discardedLogs;
	
	private MemAppender()
	{						
		super();
	}
	
	private MemAppender(List<LoggingEvent> list)
	{
		super();
		MemAppender.logs = list;
		
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
		return true;
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
