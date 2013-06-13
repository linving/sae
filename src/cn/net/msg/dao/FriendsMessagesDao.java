package cn.net.msg.dao;

import java.util.List;

import cn.net.msg.model.Messages;
import cn.net.msg.model.User_Phone;

public interface FriendsMessagesDao {

	public boolean saveFriends(User_Phone myself, User_Phone friend);

	public List<User_Phone> findFrindByPhone(String phone);

	public boolean deleteFriendsByPhone(User_Phone myself, User_Phone friend);
//添加留言
	public boolean saveMessages(Messages messages);
	// 查看所有留言
	public List<Messages> listAllMessagesByUser(User_Phone myself);
	//查看和某人的 留言对话
	public List<Messages> MessagesWithSomeBody(User_Phone myself, User_Phone friend);
	//查看沒有讀過的留言
	public List<Messages> checkUnreadMessages(User_Phone myself);
	//
	public boolean updateMesssagesState( Messages message);
	//查看他们是否为好友
	public boolean isFriends(User_Phone myself, User_Phone friend);
}
