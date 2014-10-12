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
public class UserAddDetail extends BaseEntity {

	private String address;

	@OneToOne
	private UserInfo userInfo_FK;
	
	public UserAddDetail(){}
	public UserAddDetail(String address) {
		super();
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public UserInfo getUserInfo_FK() {
		return userInfo_FK;
	}
	public void setUserInfo_FK(UserInfo userInfo_FK) {
		this.userInfo_FK = userInfo_FK;
	}		
}
