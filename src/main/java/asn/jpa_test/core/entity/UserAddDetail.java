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
public class UserAddDetail extends BaseEntity {

	private String address;

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
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserAddDetail [address=");
		builder.append(address);
		builder.append("]");
		return builder.toString();
	}
	
}
