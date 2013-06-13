package cn.net.msg.dao;

import java.util.List;

import cn.net.msg.model.User_Phone;

public interface UserPhoneDao {

	public void saveUser_P(User_Phone user);

	public void deleteById(int id);

	public void deleteByUser_p(User_Phone user);

	public void update_User_P(User_Phone user);

	public List<User_Phone> listAllUser_P();

	public User_Phone list_User_P_ById(int id);

	public User_Phone list_User_P_ByPhone(String phone);

	//
	public List<User_Phone> liset_User(User_Phone user);
	

}
