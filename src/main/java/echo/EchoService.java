package echo;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/")
public class EchoService
{
	private static Logger logger= Logger.getLogger(EchoService.class.getName());
	
	@Path("/echo")
	@GET
	@Consumes("text/plain")
	@Produces("text/plain")
	public String echo(@QueryParam("message") String message) {
		
		if(logger.isLoggable(Level.FINE))
			logger.fine(String.format("echo service called with message %s",message));
		
		try {
			String host= InetAddress.getLocalHost().getHostName();
			String time= new SimpleDateFormat("yyyy-MM-dd-hh:mm:SSS").format(new Date());			
			return String.format("echo from server %s at time %s: %s", host,time,message);
		} catch (Exception e) {
			Response badRequestResponse= Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
			throw new WebApplicationException(badRequestResponse);			
		}
	}	
	
	@PostConstruct
	public void initialize() {
		if (logger.isLoggable(Level.CONFIG))
			logger.config("EchoService initialized");
	}
}
