/**
 * 
 */
package asn.jpa_test.core.entity.unideirectional;

import javax.persistence.Entity;

import asn.jpa_test.core.entity.BaseEntity;

/**
 * @author Abhishek
 *
 */
@Entity
public class Passport extends BaseEntity {

	private String passportNum;
	
	public Passport(){}

	public String getPassportNum() {
		return passportNum;
	}

	public void setPassportNum(String passportNum) {
		this.passportNum = passportNum;
	}
	
	
}
