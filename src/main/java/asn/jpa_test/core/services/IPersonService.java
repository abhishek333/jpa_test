/**
 * 
 */
package asn.jpa_test.core.services;

import org.springframework.data.domain.Page;

import asn.jpa_test.core.entity.BaseEntity;
import asn.jpa_test.core.entity.unideirectional.Person;
import asn.jpa_test.web.mvc.json.dto.PersonJson;

/**
 * @author Abhishek
 *
 */
public interface IPersonService {

	Person save(Person person);
	BaseEntity get(Long id);
	Page<PersonJson> findAllPersonJson(int pageNumber);
}
