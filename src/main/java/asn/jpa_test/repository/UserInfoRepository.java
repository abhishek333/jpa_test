/**
 * 
 */
package asn.jpa_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import asn.jpa_test.entity.UserAddDetail;
import asn.jpa_test.entity.UserAuth;
import asn.jpa_test.entity.UserInfo;

/**
 * @author Abhishek
 *
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

	@Query(value="SELECT DISTINCT u FROM UserInfo u WHERE u.userName=:userName")
	UserInfo findByUserName(@Param("userName")String userName);
	
	@Query(value="SELECT u.userAuth FROM UserInfo u WHERE u.id = :id")
	UserAuth findUserAuthByUserInfoId(@Param("id")Long id);

	@Query(value="SELECT u.userAddDetail FROM UserInfo u WHERE u.id = :id")
	UserAddDetail findUserAddDetailByUserInfoId(Long id);
}
