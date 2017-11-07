package info.alaz.example.person.service.ws.soap.cxf.impl;

import java.io.IOException;

import info.alaz.osgi.example.person.service.ws.soap.PersonService;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

/**
 * Start the service to test in the IDE
 */
public class PersonServiceStarter {
	 public void startService() {
		  PersonServiceImpl personServiceImpl = new PersonServiceImpl();
		  JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
		  factory.setAddress("http://localhost:8282/person");
		  factory.setServiceClass(PersonService.class);
		  factory.setServiceBean(personServiceImpl);
		  Server server = factory.create();
		  server.start();
	 }

	 public static void main(String[] args) throws IOException {
		  new PersonServiceStarter().startService();
		  System.in.read();
	 }
}
