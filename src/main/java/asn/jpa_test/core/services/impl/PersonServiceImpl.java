/**
 * 
 */
package asn.jpa_test.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import asn.jpa_test.core.entity.BaseEntity;
import asn.jpa_test.core.entity.unideirectional.Person;
import asn.jpa_test.core.repository.PersonRepository;
import asn.jpa_test.core.services.IPersonService;
import asn.jpa_test.web.mvc.json.dto.PersonJson;

/**
 * @author Abhishek
 *
 */
@Service
public class PersonServiceImpl implements IPersonService {

	private static final int PAGE_SIZE = 5;

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

	@Override
	public Page<PersonJson> findAllPersonJson(int pageNumber) {
		PageRequest request =
	            new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.DESC, "name");
		return personRepository.findAllPersonJson(request);
	}

}
