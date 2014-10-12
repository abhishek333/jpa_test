/**
 * 
 */
package asn.jpa_test.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * @author Abhishek
 *
 */
@Entity
public class UserInfo extends BaseEntity {

	private String fullName;
	private String userName;
	
	@OneToOne(optional=false, mappedBy="userInfo_FK", cascade=CascadeType.ALL)
	private UserAuth userAuth;
	
	@OneToOne(optional=false, mappedBy="userInfo_FK", cascade=CascadeType.ALL)
	private UserAddDetail userAddDetail;
	
	public UserInfo(){}
	public UserInfo(String fullName, String userName, UserAuth userAuth,
			UserAddDetail userAddDetail) {
		super();
		this.fullName = fullName;
		this.userName = userName;
		this.userAuth = userAuth;
		this.userAddDetail = userAddDetail;
	}
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public UserAuth getUserAuth() {
		return userAuth;
	}
	public void setUserAuth(UserAuth userAuth) {
		this.userAuth = userAuth;
	}
	public UserAddDetail getUserAddDetail() {
		return userAddDetail;
	}
	public void setUserAddDetail(UserAddDetail userAddDetail) {
		this.userAddDetail = userAddDetail;
	}
	
	@Override
	public String toString() {
		return "UserInfo [fullName=" + fullName + ", userName=" + userName
				+ ", userAuth=" + getUserAuth() + ", userAddDetails="
				+ getUserAddDetail() + "]";
	}
	
}
