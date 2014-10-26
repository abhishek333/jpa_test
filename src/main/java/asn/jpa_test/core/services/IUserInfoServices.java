/**
 * 
 */
package asn.jpa_test.core.services;

import java.util.List;

import asn.jpa_test.core.entity.UserAddDetail;
import asn.jpa_test.core.entity.UserAuth;
import asn.jpa_test.core.entity.UserInfo;

/**
 * @author Abhishek
 *
 */
public interface IUserInfoServices {
	UserInfo save(UserInfo userInfo);
	void delete(UserInfo userInfo);
	UserInfo findById(Long id);
	UserInfo findByUserName(String userName);
	UserAuth findUserAuthByUserInfoId(Long id);
	UserAddDetail findUserAddDetailByUserInfoId(Long id);
	List<UserInfo> findAll();
	void delete(Long userId);
	void update(UserInfo userInfo);
}
