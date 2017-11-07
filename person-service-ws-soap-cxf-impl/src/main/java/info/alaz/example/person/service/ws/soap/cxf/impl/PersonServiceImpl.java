package info.alaz.example.person.service.ws.soap.cxf.impl;

import info.alaz.osgi.example.person.service.ws.soap.Person;
import info.alaz.osgi.example.person.service.ws.soap.PersonService;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.PathParam;

public class PersonServiceImpl implements PersonService {
	 Map<String, Person> personMap;
	 public static final String PERSON_ID_FLD = "id";

	 public PersonServiceImpl() {
		  personMap = new HashMap<String, Person>();
		  Person person = createExamplePerson();
		  personMap.put("1", person);
	 }

	 private Person createExamplePerson() {
		  Person person = new Person();
		  person.setId("1");
		  person.setName("Chris");
		  return person;
	 }

	 @RolesAllowed("admin")
	 public Person[] getAll() {
		  return personMap.values().toArray(new Person[] {});
	 }

	 public Person getPerson(@PathParam(PERSON_ID_FLD) String id) {
		  return personMap.get(id);
	 }

	 public void updatePerson(@PathParam(PERSON_ID_FLD) String id, Person person) {
		  person.setId(id);
		  System.out.println("Update request received for " + person.getId() + " name:" + person.getName());
		  personMap.put(id, person);
	 }

	 public void addPerson(Person person) {
		  System.out.println("Add request received for " + person.getId() + " name:" + person.getName());
		  personMap.put(person.getId(), person);
	 }
}
