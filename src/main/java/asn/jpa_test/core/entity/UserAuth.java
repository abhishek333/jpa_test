/**
 * 
 */
package asn.jpa_test.core.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * @author Abhishek
 *
 */
@Entity
public class UserAuth extends BaseEntity {

	private String passVal;
		
	public UserAuth(){}
	public UserAuth(String passVal) {
		super();
		this.passVal = passVal;
	}

	public String getPassVal() {
		return passVal;
	}

	public void setPassVal(String passVal) {
		this.passVal = passVal;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserAuth [passVal=");
		builder.append(passVal);
		builder.append("]");
		return builder.toString();
	}
	
}
