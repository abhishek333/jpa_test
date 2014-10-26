/**
 * 
 */
package asn.jpa_test.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import asn.jpa_test.core.entity.onetomany.Parent;

/**
 * @author Abhishek
 *
 */
public interface ParentRepository extends JpaRepository<Parent, Long> {

}
