package cn.net.msg.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.net.msg.dao.UserPhoneDao;
import cn.net.msg.model.User_Phone;
import cn.net.msg.tools.HibernateTools;

@Service(value = "userPhoneDao")
public class UserPhoneDaoImpl implements UserPhoneDao {

	// private Session session;

	private HibernateTools hibernatetools;

	public HibernateTools getHibernatetools() {
		return hibernatetools;
	}

	@Resource(name = "hibernateTools")
	public void setHibernatetools(HibernateTools hibernatetools) {
		this.hibernatetools = hibernatetools;
	}

	@Override
	public void saveUser_P(User_Phone user) {
		// TODO Auto-generated method stub
		hibernatetools.getCurrentSession().save(user);
	}

	@Override
	public void deleteByUser_p(User_Phone user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update_User_P(User_Phone user) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User_Phone> listAllUser_P() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User_Phone> liset_User(User_Phone user) {
		// TODO Auto-generated method stub
		Criteria criteria = hibernatetools.getCurrentSession().createCriteria(
				User_Phone.class);
		criteria.add(Restrictions.like("phone", user.getPhone()));
		return criteria.list();
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	public User_Phone list_User_P_ById(int id) {
		// TODO Auto-generated method stub
		// List<User> list=template.find("from User u where u.name=?", name);
		// List<User_Phone> list =
		// hibernatetools.getTemplate().find("from User_Phone u where u.id=?",
		// id);
		Criteria criteria = hibernatetools.getCurrentSession().createCriteria(
				User_Phone.class);
		User_Phone user = new User_Phone();
		criteria.add(Restrictions.like("id", id));
		List<User_Phone> list = criteria.list();
		for (User_Phone u : list) {
			user = u;

		}
		return user;
	}

	@Override
	public User_Phone list_User_P_ByPhone(String phone) {
		// TODO Auto-generated method stub

		Criteria criteria = hibernatetools.getCurrentSession().createCriteria(
				User_Phone.class);
		criteria.add(Restrictions.like("phone", phone));

		@SuppressWarnings("unchecked")
		List<User_Phone> list = criteria.list();
		User_Phone user = new User_Phone();
		for (User_Phone u : list) {
			user = u;

		}
		return user;
	}

}
