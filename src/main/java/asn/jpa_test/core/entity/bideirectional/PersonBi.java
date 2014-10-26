/**
 * 
 */
package asn.jpa_test.core.entity.bideirectional;

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
public class PersonBi extends BaseEntity{

	private String name;
	
	@OneToOne(optional=false, mappedBy="owningPerson", cascade=CascadeType.ALL,fetch=FetchType.EAGER)	
    private PassportBi passportBi;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PassportBi getPassportBi() {
		return passportBi;
	}

	public void setPassportBi(PassportBi passportBi) {
		this.passportBi = passportBi;
	}
	
	
}
