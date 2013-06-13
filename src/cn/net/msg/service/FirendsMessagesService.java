package cn.net.msg.service;

import java.util.Date;
import java.util.List;

import cn.net.msg.model.Messages;
import cn.net.msg.model.User_Phone;

public interface FirendsMessagesService {
	public boolean saveFriends(User_Phone myself, User_Phone firend);

	public List<User_Phone> listFriends(String phone);

	public boolean deleteFriends(User_Phone myself, User_Phone firend);

	public boolean saveMessages(User_Phone from_user, User_Phone to_user,
			String messages, Date time);

	// 查看所有留言
	public List<Messages> listAllMessagesByUser(User_Phone myself);

	// 查看和某人的對話
	public List<Messages> listMessagesWithSomeBody(User_Phone myself,
			User_Phone firend);

	// 查看未读留言
	public List<Messages> checkUnreadMessages(User_Phone myself);
	
	// 检查他们是不是 friend 
	
	public boolean isFriend(User_Phone myself, User_Phone firend);
	

}
