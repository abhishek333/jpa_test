/**
 * 
 */
package asn.jpa_test.test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import asn.jpa_test.core.entity.UserAddDetail;
import asn.jpa_test.core.entity.UserAuth;
import asn.jpa_test.core.entity.UserInfo;
import asn.jpa_test.core.services.IUserInfoServices;

/**
 * @author Abhishek
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-test.xml")
@EnableTransactionManagement
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserInfoServiceTest {

	@Autowired private IUserInfoServices userInfoServices;
	@Autowired private UserInfo userInfo;
	
	@Test
	public void test11_print(){
		System.out.println(userInfo);
	}
	
	@Test
	public void test1_save(){		
		userInfoServices.save(userInfo);
		assertThat(userInfo.getId(), instanceOf(Long.class));
	}
	
	@Test
	public void test2_userAuthSaved(){		
		UserAuth userAuth = userInfo.getUserAuth();
		assertThat(userAuth, instanceOf(UserAuth.class));
	}
	
	@Test
	public void test3_userAdditionalDetailSaved(){
		UserAddDetail userAddDetail = userInfo.getUserAddDetail();
		assertThat(userAddDetail, instanceOf(UserAddDetail.class));
	}
	
	@Test
	public void test4_findByUserName(){
		String username = userInfo.getUserName();
		UserInfo userInfo = userInfoServices.findByUserName(username); 
		assertThat(userInfo, instanceOf(UserInfo.class));
	}
	
	@Test
	public void test5_findUserAuthByUserInfoId(){
		Long userInfoId = userInfo.getId();
		UserAuth userAuth = userInfoServices.findUserAuthByUserInfoId(userInfoId);
		assertNotNull(userAuth);
	}

	@Test
	public void test6_findUserAddDetailByUserInfoId(){
		Long userInfoId = userInfo.getId();
		UserAddDetail userAddDetail = userInfoServices.findUserAddDetailByUserInfoId(userInfoId);
		assertNotNull(userAddDetail);
	}
	
	@Test
	public void test7_delete(){
		Long id = userInfo.getId();
		userInfoServices.delete(userInfo);
		assertNull(userInfoServices.findById(id));
	}
	
	@Test
	public void test8_checkUserAddDetailsDeleted(){
		Long userInfoId = userInfo.getId();
		assertNull(userInfoServices.findUserAddDetailByUserInfoId(userInfoId));
	}
	
	@Test
	public void test9_checkUserAuthIsDeleted(){
		Long userInfoId = userInfo.getId();
		assertNull(userInfoServices.findUserAuthByUserInfoId(userInfoId));
	}
}
