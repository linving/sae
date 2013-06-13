package cn.net.msg.tools;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

@Component(value = "hibernateTools")
public class HibernateTools {
	static private SessionFactory sessionfactory;
	static	private HibernateTemplate template;

	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}

	@Resource(name = "sessionFactory")
	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	public HibernateTemplate getTemplate() {
		return template;
	}

	@Resource(name = "hibernateTemplate")
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	public Session getCurrentSession() {
		return sessionfactory.getCurrentSession();

	}

}
