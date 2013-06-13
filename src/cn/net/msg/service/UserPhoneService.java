package cn.net.msg.service;

import java.util.List;

import cn.net.msg.model.User_Phone;

public interface UserPhoneService {
	public void saveUser_p(User_Phone user);

	public List<User_Phone> listAUser(User_Phone user);

	public User_Phone findUserById(int id);

	public boolean saveCurrentLocation(User_Phone user);

	public User_Phone findUserByPhone(String phone);

}
