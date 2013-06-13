package cn.net.msg.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.net.msg.dao.FriendsMessagesDao;
import cn.net.msg.model.Messages;
import cn.net.msg.model.User_Phone;
import cn.net.msg.service.FirendsMessagesService;
import cn.net.msg.service.UserPhoneService;

@Service(value = "friendsMessagesService")
@Transactional
public class FriendsMessagesServiceImpl implements FirendsMessagesService {
	private FriendsMessagesDao friendsDao;

	private UserPhoneService userService;

	public UserPhoneService getUserService() {
		return userService;
	}

	@Resource(name = "userservice")
	public void setUserService(UserPhoneService userService) {
		this.userService = userService;
	}

	public FriendsMessagesDao getFriendsDao() {
		return friendsDao;
	}

	@Resource(name = "friendsMessagesDao")
	public void setFriendsDao(FriendsMessagesDao friendsDao) {
		this.friendsDao = friendsDao;
	}

	@Override
	public boolean saveFriends(User_Phone myself, User_Phone firend) {
		// TODO Auto-generated method stub
		friendsDao.saveFriends(myself, firend);
		return true;
	}

	@Override
	public List<User_Phone> listFriends(String phone) {
		// TODO Auto-generated method stub
		return friendsDao.findFrindByPhone(phone);
	}

	@Override
	public boolean deleteFriends(User_Phone myself, User_Phone firend) {
		// TODO Auto-generated method stub
		friendsDao.deleteFriendsByPhone(myself, firend);
		return true;
	}

	@Override
	public boolean saveMessages(User_Phone from_user, User_Phone to_user,
			String messages, Date time) {
		// TODO Auto-generated method stub
		Messages message = new Messages();
		message.setFrom_user(from_user);
		message.setTo_user(to_user);
		message.setMessages(messages);
		message.setTime(time);
		message.setIsRead("false");
		friendsDao.saveMessages(message);
		return true;
	}

	@Override
	public List<Messages> listAllMessagesByUser(User_Phone myself) {
		// TODO Auto-generated method stub
		return friendsDao.listAllMessagesByUser(myself);
	}

	@Override
	public List<Messages> listMessagesWithSomeBody(User_Phone myself,
			User_Phone firend) {
		// TODO Auto-generated method stub
		return friendsDao.MessagesWithSomeBody(myself, firend);
	}

	@Override
	public List<Messages> checkUnreadMessages(User_Phone myself) {
		// TODO Auto-generated method stub
		
		List<Messages> list = friendsDao.checkUnreadMessages(myself);
		for(Messages m:list){
			m.setIsRead("true");
			friendsDao.updateMesssagesState(m);
		}
		
		return list;
	}

	@Override
	public boolean isFriend(User_Phone myself, User_Phone firend) {
		// TODO Auto-generated method stub
		return friendsDao.isFriends(myself, firend);
	}

}
