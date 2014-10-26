/**
 * 
 */
package asn.jpa_test.core.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import asn.jpa_test.core.entity.UserAddDetail;
import asn.jpa_test.core.entity.UserAuth;
import asn.jpa_test.core.entity.UserInfo;
import asn.jpa_test.core.services.IUserInfoServices;

/**
 * @author Abhishek
 *
 */
public class UserMain {

	private IUserInfoServices userInfoServices;
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		userInfoServices = ctx.getBean(IUserInfoServices.class);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UserMain um = new UserMain();
		UserAuth userAuth = new UserAuth("123");
		UserAddDetail userAddDetail = new UserAddDetail("pune");
		/*UserInfo userInfo = new UserInfo("Abhishek nayak", "abhishek", userAuth, userAddDetail);
		userInfo = um.save(userInfo);*/
		Long userId = 1L;//userInfo.getId();
		um.printUserById(userId);
		
		UserAuth userAuth2 = new UserAuth("321");
		UserAddDetail userAddDetail2 = new UserAddDetail("Odisha");
		UserInfo userInfo2 = um.getUser(userId);
		userInfo2.setUserAuth(userAuth2);
		userInfo2.setUserAddDetail(userAddDetail2);
		
		um.update(userInfo2);
		//um.delete(userInfo.getId());
	}
	
	private UserInfo getUser(Long userId) {
		return userInfoServices.findById(userId);
	}

	private void update(UserInfo userInfo) {
		userInfoServices.update(userInfo);
	}

	private void delete(Long id) {
		userInfoServices.delete(id);
	}

	private void printUserById(Long userId) {
		System.out.println(userInfoServices.findById(userId));
	}

	private UserInfo save(UserInfo userInfo) {
		return userInfoServices.save(userInfo);
	}

}
