package info.alaz.osgi.example.person.service.ws.soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {
	 private final static String NAMESPACE = "http://person.osgi.example.alaz.info";
	 private final static QName PERSON_QNAME = new QName(NAMESPACE, "person");

	 @XmlElementDecl(namespace = NAMESPACE, name = "person")
	 public JAXBElement<Person> createPerson(Person person) {
		  return new JAXBElement<Person>(PERSON_QNAME, Person.class, person);
	 }
}
