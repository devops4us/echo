package echo;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
public class EchoApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> result= new HashSet<>();
		result.add(EchoService.class);
		return result;
	}
	
}
