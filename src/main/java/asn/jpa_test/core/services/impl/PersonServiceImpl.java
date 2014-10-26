/**
 * 
 */
package asn.jpa_test.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import asn.jpa_test.core.entity.BaseEntity;
import asn.jpa_test.core.entity.unideirectional.Person;
import asn.jpa_test.core.repository.PersonRepository;
import asn.jpa_test.core.services.IPersonService;

/**
 * @author Abhishek
 *
 */
public class PersonServiceImpl implements IPersonService {

	@Autowired private PersonRepository personRepository;
	
	/* (non-Javadoc)
	 * @see asn.jpa_test.services.IPersonService#save(asn.jpa_test.entity.unideirectional.Person)
	 */
	@Override
	public Person save(Person person) {		
		return personRepository.save(person);
	}

	/* (non-Javadoc)
	 * @see asn.jpa_test.services.IPersonService#get(java.lang.Long)
	 */
	@Override
	public BaseEntity get(Long id) {
		return personRepository.findOne(id);
	}

}
