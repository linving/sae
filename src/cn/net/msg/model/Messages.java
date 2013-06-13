package cn.net.msg.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Messages implements Serializable {
	private User_Phone from_user;
	private User_Phone to_user;
	private String messages;
	private Date time;
	private String isRead;

	public String getIsRead() {
		return isRead;
	}

	public void setIsRead(String isRead) {
		this.isRead = isRead;
	}

	@ManyToOne
	public User_Phone getFrom_user() {
		return from_user;
	}

	public void setFrom_user(User_Phone from_user) {
		this.from_user = from_user;
	}

	@Override
	public String toString() {
		return "Messages [from_user=" + from_user + ", to_user=" + to_user
				+ ", messages=" + messages + ", time=" + time + ", isRead="
				+ isRead + "]";
	}

	@ManyToOne
	public User_Phone getTo_user() {
		return to_user;
	}

	public void setTo_user(User_Phone to_user) {
		this.to_user = to_user;
	}

	public String getMessages() {
		return messages;
	}

	public void setMessages(String messages) {
		this.messages = messages;
	}

	@Id
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
