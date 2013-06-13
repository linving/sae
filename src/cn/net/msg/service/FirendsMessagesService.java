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

	// �鿴��������
	public List<Messages> listAllMessagesByUser(User_Phone myself);

	// �鿴��ĳ�˵Č�Ԓ
	public List<Messages> listMessagesWithSomeBody(User_Phone myself,
			User_Phone firend);

	// �鿴δ������
	public List<Messages> checkUnreadMessages(User_Phone myself);
	
	// ��������ǲ��� friend 
	
	public boolean isFriend(User_Phone myself, User_Phone firend);
	

}
