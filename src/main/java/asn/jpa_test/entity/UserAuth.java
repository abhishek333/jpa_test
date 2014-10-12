/**
 * 
 */
package asn.jpa_test.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * @author Abhishek
 *
 */
@Entity
public class UserAuth extends BaseEntity {

	private String passVal;
	
	@OneToOne
	//@MapsId
	private UserInfo userInfo_FK;
	
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
	public UserInfo getUserInfo_FK() {
		return userInfo_FK;
	}
	public void setUserInfo_FK(UserInfo userInfo_FK) {
		this.userInfo_FK = userInfo_FK;
	}
	
	
}
