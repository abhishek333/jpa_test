/**
 * 
 */
package asn.jpa_test.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import asn.jpa_test.entity.unideirectional.Passport;
import asn.jpa_test.entity.unideirectional.Person;
import asn.jpa_test.repository.PersonRepository;

/**
 * @author Abhishek
 *
 */
public class PersonMain {

	private static PersonRepository personRepository = null;
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		personRepository = ctx.getBean(PersonRepository.class);
		
		Long savedPersonId = 1L;//savePerson();
		
		deletePerson(savedPersonId);
	}

	private static void deletePerson(long id) {
		personRepository.delete(id);		
	}

	private static Long savePerson() {
		Person person = new Person();
		person.setName("Abhishek");
		Passport passport = new Passport();
		passport.setPassportNum("1323");
		person.setPassport(passport);
		
		Person savedPerson = personRepository.save(person);
		System.out.println(savedPerson);
		return savedPerson.getId();
	}
	
}
