package asn.jpa_test.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import asn.jpa_test.core.entity.UserAddDetail;
import asn.jpa_test.core.entity.UserAuth;
import asn.jpa_test.core.entity.UserInfo;
import asn.jpa_test.core.repository.UserInfoRepository;
import asn.jpa_test.core.services.IUserInfoServices;

@Service
public class UserInfoServiceImpl implements IUserInfoServices {

	@Autowired private UserInfoRepository userInfoRepository;
	
	@Override
	public UserInfo save(UserInfo userInfo) {
		return userInfoRepository.save(userInfo);
	}

	@Override
	public void delete(UserInfo userInfo) {
		userInfoRepository.delete(userInfo);		
	}

	@Override
	public UserInfo findById(Long id) {
		return userInfoRepository.findOne(id);
	}

	@Override
	public UserInfo findByUserName(String userName) {
		return userInfoRepository.findByUserName(userName);
	}

	@Override
	public List<UserInfo> findAll() {
		return userInfoRepository.findAll();
	}

	@Override
	public UserAuth findUserAuthByUserInfoId(Long id) {
		return userInfoRepository.findUserAuthByUserInfoId(id);
	}

	@Override
	public UserAddDetail findUserAddDetailByUserInfoId(Long id) {
		return userInfoRepository.findUserAddDetailByUserInfoId(id);
	}

	@Override
	public void delete(Long userId) {
		userInfoRepository.delete(userId);
	}

	@Transactional
	@Override
	public void update(UserInfo userInfo) {
		UserInfo updatedUserInfo = userInfoRepository.findOne(userInfo.getId());
		updatedUserInfo.setFullName(userInfo.getFullName());
		updatedUserInfo.updateUserAddDetail(userInfo.getUserAddDetail());
		updatedUserInfo.updateUserAuth(userInfo.getUserAuth());
		updatedUserInfo.setUserName(userInfo.getUserName());
	}

}
