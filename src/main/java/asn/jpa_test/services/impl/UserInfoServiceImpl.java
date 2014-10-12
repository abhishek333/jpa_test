package asn.jpa_test.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asn.jpa_test.entity.UserAddDetail;
import asn.jpa_test.entity.UserAuth;
import asn.jpa_test.entity.UserInfo;
import asn.jpa_test.repository.UserInfoRepository;
import asn.jpa_test.services.IUserInfoServices;

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

}
