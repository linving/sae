package cn.net.msg.dao;

import java.util.List;

import cn.net.msg.model.Messages;
import cn.net.msg.model.User_Phone;

public interface FriendsMessagesDao {

	public boolean saveFriends(User_Phone myself, User_Phone friend);

	public List<User_Phone> findFrindByPhone(String phone);

	public boolean deleteFriendsByPhone(User_Phone myself, User_Phone friend);
//�������
	public boolean saveMessages(Messages messages);
	// �鿴��������
	public List<Messages> listAllMessagesByUser(User_Phone myself);
	//�鿴��ĳ�˵� ���ԶԻ�
	public List<Messages> MessagesWithSomeBody(User_Phone myself, User_Phone friend);
	//�鿴�]���x�^������
	public List<Messages> checkUnreadMessages(User_Phone myself);
	//
	public boolean updateMesssagesState( Messages message);
	//�鿴�����Ƿ�Ϊ����
	public boolean isFriends(User_Phone myself, User_Phone friend);
}
