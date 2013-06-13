package cn.net.msg.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.net.msg.dao.LocationDao;
import cn.net.msg.model.Current_location;
import cn.net.msg.model.Old_location;
import cn.net.msg.model.User_Phone;
import cn.net.msg.tools.HibernateTools;

@Service(value = "locatonDao")
public class LocationDaoImpl implements LocationDao {

	private HibernateTools hibernatetools;
	private HibernateTemplate template;

	public HibernateTools getHibernatetools() {
		return hibernatetools;
	}

	@Resource(name = "hibernateTools")
	public void setHibernatetools(HibernateTools hibernatetools) {
		this.hibernatetools = hibernatetools;
	}

	@Override
	public boolean saveLocation(Old_location location) {
		// TODO Auto-generated method stub
		hibernatetools.getCurrentSession().save(location);
		return true;
	}

	@Override
	public boolean saveCurrentLocation(Current_location location) {
		// TODO Auto-generated method stub
		hibernatetools.getCurrentSession().saveOrUpdate(location);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Old_location> listAllLocation(User_Phone user) {
		// TODO Auto-generated method stub
		Criteria criteria = hibernatetools.getCurrentSession().createCriteria(
				Old_location.class);
		criteria.add(Restrictions.like("user", user));
		return criteria.list();
	}

	@Override
	public Current_location getCurrentLocationByPhone(String phone) {
		// TODO Auto-generated method stub
		Current_location location = new Current_location();
		template = hibernatetools.getTemplate();
		// List<User> list=template.find("from User u where u.name=?", name);
	
		@SuppressWarnings("unchecked") List<Current_location> list =
		 template.find( "from Current_location c where c.user.phone=?",
		 phone);
		 
		/*Criteria criteria = hibernatetools.getCurrentSession().createCriteria(
				Current_location.class);
		criteria.add(Restrictions.like("phone", phone));
		@SuppressWarnings("unchecked")
		List<Current_location> list = criteria.list();*/
		for (Current_location c : list) {
			location = c;
		}
		return location;
	}

}
