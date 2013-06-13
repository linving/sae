package cn.net.msg.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.net.msg.model.Current_location;
import cn.net.msg.model.Old_location;
import cn.net.msg.model.User_Phone;
import cn.net.msg.service.LocationService;
import cn.net.msg.service.UserPhoneService;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Component(value = "locationAction")
@Scope(value = "prototype")
public class LocationAction extends ActionSupport implements
		ModelDriven<Old_location>, ServletResponseAware {
	// private String info =
	// "{ \"firstName\": \"Brett\", \"lastName\":\"McLaughlin\", \"email\": \"aaaa\" }";
	private PrintWriter printWriter;
	private LocationService locationService;
	private UserPhoneService userService;
	private String userphone;
	private HttpServletResponse response;
	private User_Phone user = new User_Phone();

	public HttpServletResponse getResponse() {
		return response;
	}

	

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public UserPhoneService getUserService() {
		return userService;
	}

	@Resource(name = "userservice")
	public void setUserService(UserPhoneService userService) {
		this.userService = userService;
	}

	private Old_location location = new Old_location();

	public Old_location getLocation() {
		return location;
	}

	public void setLocation(Old_location location) {
		this.location = location;
	}

	public LocationService getLocationService() {
		return locationService;
	}

	@Resource(name = "locationService")
	public void setLocationService(LocationService locationService) {
		this.locationService = locationService;
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub
		user = userService.findUserByPhone(userphone);
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		try {
			printWriter = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.validate();
	}

	public String getUserphone() {
		return userphone;
	}

	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}

	/*
	 * { "people": [ { "firstName": "Jason", "lastName":"Hunter", "email":
	 * "bbbb"}, ]}
	 */
	public String searcholdlocation() {
		if (!user.getName().isEmpty()) {
			List<Old_location> old = locationService.listAllLocation(user);
			if (old.size() >= 1) {
				for (Old_location o : old) {
					String json = JSON.toJSONString(o);
					printWriter.write(json);
				}
			} else {
				String info = "{ \"info\": \"你没有储存有历史地址！\" }";
				printWriter.write(info);
			}
		}

		printWriter.flush();

		return SUCCESS;

	}

	public String searchcurrentlocation() {
		Current_location c_location = locationService
				.getCurrentLocationByPhone(userphone);
		String json = JSON.toJSONString(c_location);
		printWriter.write(json);
		printWriter.flush();
		return SUCCESS;

	}

	public String saveLocation() {
		Date time = new Date();
		location.setTime(time);
		// location.setId(0);
		// user = userService.findUserById(userid);
		location.setUser(user);
		location.setId(0);
		Current_location current_location = new Current_location();
		current_location.setAccuracy(location.getAccuracy());
		current_location.setDirection(location.getDirection());
		current_location.setLatitude(location.getLatitude());
		current_location.setLongitude(location.getLongitude());
		current_location.setTime(time);
		current_location.setUser(user);

		if (locationService.saveCurrentLocation(current_location)) {
	              locationService.saveLocation(location);
			String info = "{ \"info\": \"存储并更新成功！\" }";
			printWriter.write(info);
		} else {
			String info = "{ \"info\": \"存储更新失败！\" }";
			printWriter.write(info);
		}
		printWriter.flush();
		// System.out.println(location.toString());
		return SUCCESS;
	}

	@Override
	public Old_location getModel() {
		// TODO Auto-generated method stub
		return this.location;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response = arg0;
	}

}
