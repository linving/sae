package cn.net.msg.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.net.msg.model.User_Phone;
import cn.net.msg.service.UserPhoneService;

import com.opensymphony.xwork2.ActionSupport;

@Component(value = "userPhoneAction")
@Scope(value = "prototype")
public class UserPhoneAction extends ActionSupport implements
		ServletResponseAware {
	private UserPhoneService userservice;
	HttpServletResponse response;
	PrintWriter printWriter;

	private String name;
	private String phone;
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	private User_Phone user = new User_Phone();// must new you Model

	public User_Phone getUser() {
		return user;
	}

	public void setUser(User_Phone user) {
		this.user = user;
	}

	public UserPhoneService getUserservice() {
		return userservice;
	}

	@Resource(name = "userservice")
	public void setUserservice(UserPhoneService userservice) {
		this.userservice = userservice;
	}

	public String saveUser() throws IOException {
		boolean flag = false;
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		printWriter = response.getWriter();
		user.setName(name);
		user.setPassword(password);
		user.setPhone(phone);
		flag = existThisUserOrNot(user);
		if (flag) {
			userservice.saveUser_p(user);
			String info = "{ \"info\": \"注册成功\" }";
			printWriter.write(info);
			printWriter.flush();
			return SUCCESS;

		} else {
			String info = "{ \"info\": \"你的手机已注册\" }";
			printWriter.write(info);
			printWriter.flush();
			return ERROR;
		}
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub
		super.validate();
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response = arg0;
	}

	public boolean existThisUserOrNot(User_Phone user) {
		List<User_Phone> users = userservice.listAUser(user);
		System.out.println("size " + users.size());
		if (users.size() >= 1) {
			return false;
		} else {
			return true;
		}

	}

	public boolean validateInseart() throws IOException {
		printWriter = response.getWriter();

		if (null == user.getName() || "".equals(user.getName().trim())) {
			printWriter.write("名稱不能為空");
			printWriter.flush();
			return false;
		}

		if (null == user.getPassword() || "".equals(user.getPassword().trim())) {
			printWriter.write("密碼不能為空");
			printWriter.flush();
			return false;
		}

		if (null == user.getPhone() + ""
				|| "".equals(user.getPhone() + "".trim())) {
			printWriter.write("電話號碼不能為空");
			printWriter.flush();
			return false;
		}

		return true;
	}

}
