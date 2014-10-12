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

	@Query(value="SELECT DISTINCT u from UserInfo u WHERE u.userName=:userName")
	UserInfo findByUserName(@Param("userName")String userName);
	
	@Query(value="SELECT ua FROM UserAuth ua WHERE ua.userInfo_FK.id = :id")
	UserAuth findUserAuthByUserInfoId(@Param("id")Long id);

	@Query(value="SELECT ua FROM UserAddDetail ua WHERE ua.userInfo_FK.id = :id")
	UserAddDetail findUserAddDetailByUserInfoId(Long id);
}
