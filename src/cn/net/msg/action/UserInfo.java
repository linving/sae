package cn.net.msg.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.stereotype.Component;

import cn.net.msg.model.User;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;

@Component(value = "userInfoAction")
public class UserInfo extends ActionSupport implements ServletResponseAware {
	HttpServletResponse response;
	PrintWriter printWriter;
	private List<User> list;

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response = arg0;

	}

	public HttpServletResponse getResponse() {
		return response;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		 prepareData();
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		printWriter = response.getWriter();
		StringBuffer sb = new StringBuffer();
		for (User bean : list) {
			// 单个用户JSON对象
			String jsonString = JSON.toJSONString(bean);
			sb.append(jsonString);
		}

		printWriter.write(sb.toString());
		printWriter.flush();
		return super.execute();

	}

	private void prepareData() {
		list = new ArrayList<User>();
		User bean1 = new User();
		bean1.setId(1001);
		bean1.setName("Tony");
		// bean1.("tony@toeach.net");
		bean1.setSex("male");
		list.add(bean1);

		User bean2 = new User();
		bean2.setId(1002);
		bean2.setName("Jack");
		// bean2.setEmail("jack@hotmail.com");
		bean2.setSex("male");
		list.add(bean2);

		User bean3 = new User();
		bean3.setId(1003);
		bean3.setName("Marry");
		// bean3.setEmail("marry@163.com");
		bean3.setSex("female");
		list.add(bean3);

		User bean4 = new User();
		bean4.setId(1004);
		bean4.setName("Linda");
		// bean4.setEmail("linda@21cn.com");
		bean4.setSex("female");
		list.add(bean4);
	}

}
