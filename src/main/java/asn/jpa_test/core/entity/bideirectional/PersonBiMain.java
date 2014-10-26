/**
 * 
 */
package asn.jpa_test.core.entity.bideirectional;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import asn.jpa_test.core.repository.PersonRepository;

/**
 * @author Abhishek
 *
 */
public class PersonBiMain {
	private static PersonRepository personRepository = null;
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		personRepository = ctx.getBean(PersonRepository.class);
		
		Long savedPersonId = savePerson();
		
		//deletePerson(savedPersonId);
	}

	private static void deletePerson(long id) {
		personRepository.delete(id);		
	}

	private static Long savePerson() {
		PersonBi person = new PersonBi();
		person.setName("Abhishek");
		PassportBi passport = new PassportBi();
		passport.setPassportNum("1323");
		passport.setOwningPerson(person);
		person.setPassportBi(passport);
		
		//PersonBi savedPerson = personRepository.save(person);
		//System.out.println(savedPerson);
		return null;//savedPerson.getId();
	}

}
