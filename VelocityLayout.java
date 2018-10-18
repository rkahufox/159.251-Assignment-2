package assign251_1.s16030627;

import java.io.StringWriter;

import org.apache.log4j.PatternLayout;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.Template;
import java.io.StringWriter;

public class VelocityLayout extends PatternLayout {
	
	private VelocityContext thisContext = new VelocityContext();
	private StringWriter sw;
	private Template template;
	
	
	public VelocityLayout()
	{
		super();
	}
	
	
	public VelocityLayout(String string) 
	{
		this.setConversionPattern(string);
	}

	@Override
    public String format(LoggingEvent event)
	{	
		sw  = new StringWriter();
		template = new Template();
		
		
		thisContext.put("c", event.getLogger());
		thisContext.put("d", event.toString());
	    thisContext.put("m", event.getMessage());
		thisContext.put("p", event.getLevel());
		thisContext.put("t", event.getThreadName());
		thisContext.put("n", "\n");
					
	    template = Velocity.getTemplate("template.vm");
		
		template.merge(thisContext, sw);
		
		
				
		return sw.toString();
		
		
		
	}
	

	
}
