package cn.net.msg.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Friends implements Serializable {

	

	private User_Phone user;

	private User_Phone friend;

	@Id
	@ManyToOne
	public User_Phone getFriend() {
		return friend;
	}

	public void setFriend(User_Phone friend) {
		this.friend = friend;
	}

	@Id
	@ManyToOne
	public User_Phone getUser() {
		return user;
	}

	public void setUser(User_Phone user) {
		this.user = user;
	}
}
