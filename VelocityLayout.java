package assign251_1.s16030627;

import java.io.StringWriter;

import org.apache.log4j.PatternLayout;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

public class VelocityLayout extends PatternLayout {
	
	private static VelocityContext thisContext = new VelocityContext();
	private static StringWriter sw = new StringWriter();
	
	//stringwriter context template make variable from event.get return writer.tostring override format
	
	@Override
    public String format(LoggingEvent event)
	{
		
    	
		
		thisContext.put("c", event.getLogger());
		thisContext.put("d", event.toString());
	    thisContext.put("m", event.getMessage());
		thisContext.put("p", event.getLevel());
		thisContext.put("t", event.getThreadName());
		thisContext.put("n", "\n");
		
		Template template = Velocity.getTemplate("template.vm");
		
		template.merge(thisContext, sw);
		
		return sw.toString();
	}
	

	
}
