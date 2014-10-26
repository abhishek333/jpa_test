/**
 * 
 */
package asn.jpa_test.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import asn.jpa_test.core.entity.BaseEntity;
import asn.jpa_test.core.entity.unideirectional.Person;

/**
 * @author Abhishek
 *
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

}
