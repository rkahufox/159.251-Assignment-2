package assign251_1.s16030627;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.velocity.Template;


public class MemAppender extends AppenderSkeleton{

	
	private static MemAppender defaultInstance = null;
	private List<LoggingEvent> logs = null;
	private int maxSize = 10000;     //Default size - ten thousand
	private static int appendedEvents = 0;
	private static int discardedLogs = 0;
	
	private MemAppender()
	{
		super();
		logs = new ArrayList<LoggingEvent>();
	}
	
	public static MemAppender getInstance()
	{
		if(defaultInstance == null)
		{
			defaultInstance = new MemAppender();
		}
		return defaultInstance;
	}
	
	public static MemAppender getInstance(List<LoggingEvent> list)
	{
		if(defaultInstance == null)
		{
			defaultInstance = new MemAppender();
			defaultInstance.logs = list;
		}
		else
		{
			defaultInstance.logs = list;
		}
		return defaultInstance;
	}
	
	public List<LoggingEvent> getLogList()
	{
		return logs;
	}
		

	
	public void setMaxSize(int i)
	{
		maxSize = i;
	}
	
	public int getMaxSize()
	{
		return maxSize;
	}
	

	@Override
	protected void append(LoggingEvent eventToLog) {
		logs.add(eventToLog);
		appendedEvents++;
		if(appendedEvents >= this.getMaxSize())
		{
			logs.remove(logs.size()-1);	
			System.out.println("Discarding log!");
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

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}
