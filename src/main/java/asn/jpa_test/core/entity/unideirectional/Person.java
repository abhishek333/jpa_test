/**
 * 
 */
package asn.jpa_test.core.entity.unideirectional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import asn.jpa_test.core.entity.BaseEntity;

/**
 * @author Abhishek
 *
 */
@Entity
public class Person extends BaseEntity{

	private String name;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name="PASS_ID",insertable=true,
        updatable=true,nullable=true,unique=true)
    private Passport passport;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}	
	
}
