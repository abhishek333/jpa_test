/**
 * 
 */
package asn.jpa_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import asn.jpa_test.entity.BaseEntity;
import asn.jpa_test.entity.unideirectional.Person;

/**
 * @author Abhishek
 *
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

}
