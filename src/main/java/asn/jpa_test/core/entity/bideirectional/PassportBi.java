/**
 * 
 */
package asn.jpa_test.core.entity.bideirectional;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import asn.jpa_test.core.entity.BaseEntity;

/**
 * @author Abhishek
 *
 */
@Entity
public class PassportBi extends BaseEntity{
	
	private String passportNum;
	
	@OneToOne
	@JoinColumn(name="person_FK")
	private PersonBi owningPerson;
	
	public PassportBi(){}

	public String getPassportNum() {
		return passportNum;
	}

	public void setPassportNum(String passportNum) {
		this.passportNum = passportNum;
	}

	public PersonBi getOwningPerson() {
		return owningPerson;
	}

	public void setOwningPerson(PersonBi owningPerson) {
		this.owningPerson = owningPerson;
	}
	

}
