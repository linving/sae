package cn.net.msg.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.net.msg.dao.UserPhoneDao;
import cn.net.msg.model.User_Phone;
import cn.net.msg.service.UserPhoneService;
@Transactional
@Service(value = "userservice")
public class UserPhoneServiceImpl implements UserPhoneService {

	private UserPhoneDao userPhoneDao;

	public UserPhoneDao getUserPhoneDao() {
		return userPhoneDao;
	}

	@Resource(name = "userPhoneDao")
	public void setUserPhoneDao(UserPhoneDao userPhoneDao) {
		this.userPhoneDao = userPhoneDao;
	}

	@Override
	
	public void saveUser_p(User_Phone user) {
		// TODO Auto-generated method stub
		userPhoneDao.saveUser_P(user);
	}

	@Override
	
	public List<User_Phone> listAUser(User_Phone user) {
		// TODO Auto-generated method stub
		return userPhoneDao.liset_User(user);
	}

	@Override
	public User_Phone findUserById(int id) {
		// TODO Auto-generated method stub
		return userPhoneDao.list_User_P_ById(id);
	}

	@Override
	public boolean saveCurrentLocation(User_Phone user) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public User_Phone findUserByPhone(String phone) {
		// TODO Auto-generated method stub
		return userPhoneDao.list_User_P_ByPhone(phone);
	}
}
