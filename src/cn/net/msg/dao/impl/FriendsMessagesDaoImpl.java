package cn.net.msg.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.net.msg.dao.FriendsMessagesDao;
import cn.net.msg.model.Friends;
import cn.net.msg.model.Messages;
import cn.net.msg.model.Old_location;
import cn.net.msg.model.User_Phone;
import cn.net.msg.service.UserPhoneService;
import cn.net.msg.tools.HibernateTools;

@Service(value = "friendsMessagesDao")
public class FriendsMessagesDaoImpl implements FriendsMessagesDao {
	private HibernateTools hibernatetools;
	private UserPhoneService userService;

	public UserPhoneService getUserService() {
		return userService;
	}

	@Resource(name = "userservice")
	public void setUserService(UserPhoneService userService) {
		this.userService = userService;
	}

	public HibernateTools getHibernatetools() {
		return hibernatetools;
	}

	@Resource(name = "hibernateTools")
	public void setHibernatetools(HibernateTools hibernatetools) {
		this.hibernatetools = hibernatetools;
	}

	@Override
	public boolean saveFriends(User_Phone myself, User_Phone friend) {
		// TODO Auto-generated method stub
		Friends friends = new Friends();
		friends.setUser(myself);
		friends.setFriend(friend);
		hibernatetools.getCurrentSession().save(friends);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User_Phone> findFrindByPhone(String phone) {
		// TODO Auto-generated method stub

		/*
		 * Criteria criteria =
		 * hibernatetools.getCurrentSession().createCriteria(
		 * Old_location.class); criteria.add(Restrictions.like("user", user));
		 */
		User_Phone myself = userService.findUserByPhone(phone);

		Criteria criteria = hibernatetools.getCurrentSession().createCriteria(
				Friends.class);

		criteria.add(Restrictions.like("user", myself));

		List<Friends> list = criteria.list();
		List<User_Phone> friends = new ArrayList<User_Phone>();
		// Friends friend = new Friends();
		for (Friends ls : list) {
			friends.add(ls.getFriend());
		}
		return friends;
	}

	@Override
	public boolean deleteFriendsByPhone(User_Phone myself, User_Phone friend) {
		// TODO Auto-generated method stub
		Friends friends = new Friends();
		friends.setUser(myself);
		friends.setFriend(friend);
		hibernatetools.getCurrentSession().delete(friends);
		return true;
	}

	@Override
	public boolean saveMessages(Messages messages) {
		// TODO Auto-generated method stub
		hibernatetools.getCurrentSession().save(messages);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Messages> listAllMessagesByUser(User_Phone myself) {
		// TODO Auto-generated method stub

		Criteria criteria = hibernatetools.getCurrentSession().createCriteria(
				Messages.class);
		criteria.add(Restrictions.like("to_user", myself));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Messages> MessagesWithSomeBody(User_Phone myself,
			User_Phone friend) {
		// TODO Auto-generated method stub
		Criteria criteria = hibernatetools.getCurrentSession().createCriteria(
				Messages.class);
		criteria.add(Restrictions.like("to_user", myself));
		criteria.add(Restrictions.like("from_user", friend));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Messages> checkUnreadMessages(User_Phone myself) {
		// TODO Auto-generated method stub
		Criteria criteria = hibernatetools.getCurrentSession().createCriteria(
				Messages.class);
		criteria.add(Restrictions.like("to_user", myself));
		criteria.add(Restrictions.like("isRead", "false"));
		return criteria.list();
	}

	@Override
	public boolean updateMesssagesState(Messages message) {
		// TODO Auto-generated method stub
		hibernatetools.getCurrentSession().saveOrUpdate(message);
		return true;
	}

	@Override
	public boolean isFriends(User_Phone myself, User_Phone friend) {
		// TODO Auto-generated method stub
		Criteria criteria = hibernatetools.getCurrentSession().createCriteria(
				Friends.class);
		criteria.add(Restrictions.like("user", myself));
		criteria.add(Restrictions.like("friend", friend));
		if(criteria.list().size()>0){
			return false;
		}else {
			return true;
		}	
	}

}
