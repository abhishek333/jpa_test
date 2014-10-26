/**
 * 
 */
package asn.jpa_test.core.services;

import asn.jpa_test.core.entity.BaseEntity;
import asn.jpa_test.core.entity.unideirectional.Person;

/**
 * @author Abhishek
 *
 */
public interface IPersonService {

	Person save(Person person);
	BaseEntity get(Long id);
}
