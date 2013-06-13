package cn.net.msg.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Current_location implements Serializable {

	private User_Phone user;
	// jing du
	private double latitude;

	@Id
	@ManyToOne
	public User_Phone getUser() {
		return user;
	}

	public void setUser(User_Phone user) {
		this.user = user;
	}

	

	// wei du
	private double longitude;

	// jing que du
	private float accuracy;
	// jiao du
	private double direction;
	// shi jian
	private Date time;

	public float getAccuracy() {
		return accuracy;
	}

	public double getDirection() {
		return direction;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	
	public void setAccuracy(float accuracy) {
		this.accuracy = accuracy;
	}

	public void setDirection(double direction) {
		this.direction = direction;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	

}
