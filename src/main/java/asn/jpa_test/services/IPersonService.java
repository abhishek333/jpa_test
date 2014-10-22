/**
 * 
 */
package asn.jpa_test.services;

import asn.jpa_test.entity.BaseEntity;
import asn.jpa_test.entity.unideirectional.Person;

/**
 * @author Abhishek
 *
 */
public interface IPersonService {

	Person save(Person person);
	BaseEntity get(Long id);
}
