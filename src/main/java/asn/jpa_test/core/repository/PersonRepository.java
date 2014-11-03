/**
 * 
 */
package asn.jpa_test.core.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import asn.jpa_test.core.entity.unideirectional.Person;
import asn.jpa_test.web.mvc.json.dto.PersonJson;

/**
 * @author Abhishek
 *
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

	@Query("select new asn.jpa_test.web.mvc.json.dto.PersonJson(p.id, p.name) from Person p")
	Page<PersonJson> findAllPersonJson(Pageable pageable);
}
