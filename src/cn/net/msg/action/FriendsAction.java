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

import cn.net.msg.model.Messages;
import cn.net.msg.model.User_Phone;
import cn.net.msg.service.FirendsMessagesService;
import cn.net.msg.service.UserPhoneService;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;

@Component(value = "friendsAction")
@Scope(value = "prototype")
public class FriendsAction extends ActionSupport implements
		ServletResponseAware {
	private String myphone;
	private String friendphone;
	private UserPhoneService userService;
	HttpServletResponse response;
	PrintWriter printWriter;

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private FirendsMessagesService friendsService;

	public FirendsMessagesService getFriendsService() {
		return friendsService;
	}

	@Resource(name = "friendsMessagesService")
	public void setFriendsService(FirendsMessagesService friendsService) {
		this.friendsService = friendsService;
	}

	private User_Phone myself = new User_Phone();
	private User_Phone friend = new User_Phone();

	@Override
	public void validate() {
		// TODO Auto-generated method stub

		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");

		try {
			printWriter = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		myself = userService.findUserByPhone(myphone);
		friend = userService.findUserByPhone(friendphone);
		super.validate();
	}


	public UserPhoneService getUserService() {
		return userService;
	}

	@Resource(name = "userservice")
	public void setUserService(UserPhoneService userService) {
		this.userService = userService;
	}

	public String getMyphone() {
		return myphone;
	}

	public void setMyphone(String myphone) {
		this.myphone = myphone;
	}

	public String getFriendphone() {
		return friendphone;
	}

	public void setFriendphone(String friendphone) {
		this.friendphone = friendphone;
	}

	public String addFriends() {
		if (friendsService.isFriend(myself, friend)) {
			friendsService.saveFriends(myself, friend);
			// String info = "{ \"info\": \"你没有储存有历史地址！\" }";
			String info = "{ \"info\": \"添加好友成功！\" }";

			printWriter.write(info);
			// printWriter.write(myself.toString());
			// printWriter.write(friend.toString());
		} else {
			String info = "{ \"info\": \"添加失败|可能已是好友 ！\" }";
			printWriter.write(info);
		}
		printWriter.flush();
		// System.out.println(myself);
		// System.out.println(friend);
		return SUCCESS;

	}

	public String listFriends() {

		List<User_Phone> friendslist = friendsService.listFriends(myphone);
		if (friendslist.size() < 1) {
			String info = "{ \"info\": \"暂时没有好友信息！\" }";
			printWriter.write(info);
		} else {
			for (User_Phone u : friendslist) {
				// System.out.println(u.toString());
				String json = JSON.toJSONString(u);
				printWriter.write(json);
			}
		}

		printWriter.flush();

		return SUCCESS;

	}

	public String deleteFriends() {
		friendsService.deleteFriends(myself, friend);
		// printWriter.write("deleteFriends ok");
		String info = "{ \"info\": \"刪去好友成功！\" }";
		printWriter.write(info);
		// printWriter.write(myself.toString());
		// printWriter.write(friend.toString());
		printWriter.flush();
		// System.out.print("OK");
		return SUCCESS;

	}

	// 添加留言
	public String leaveMessages() {
		Date time = new Date();
		friendsService.saveMessages(myself, friend, message, time);
		String info = "{ \"info\": \"留言成功\" }";
		printWriter.write(info);
		/*
		 * printWriter.write(myself.toString());
		 * printWriter.write(friend.toString()); printWriter.write(message);
		 * printWriter.write(time.toString());
		 */
		// System.out.println(message);
		printWriter.flush();
		return SUCCESS;
	}

	public String messagesWithSomeBody() {

		List<Messages> list = friendsService.listMessagesWithSomeBody(myself,
				friend);
		if (list.size() < 1) {
			String info = "{ \"info\": \"没有留言信息！\" }";
			printWriter.write(info);
		} else {
			for (Messages m : list) {
				String info = JSON.toJSONString(m);
				printWriter.write(info);
				// printWriter.write(m.toString());
			}
		}

		printWriter.flush();
		return SUCCESS;

	}

	// 检查是否有未读的留言
	public String checkMessages() {
		List<Messages> list = friendsService.checkUnreadMessages(myself);
		if (list.size() < 1) {
			String info = "{ \"info\": \"沒有未读的留言！\" }";
			printWriter.write(info);
		} else {
			for (Messages m : list) {
				String json = JSON.toJSONString(m);
				printWriter.write(json);
				// System.out.println(m.toString());
			}
		}

		printWriter.flush();
		return SUCCESS;
	}

	// 列出所有留言
	public String listMessages() {

		List<Messages> list = friendsService.listAllMessagesByUser(myself);
		// printWriter.write(list.size());
		if (list.size() < 1) {
			String info = "{ \"info\": \"沒有留言！\" }";
			printWriter.write(info);
		} else {
			for (Messages m : list) {
				String json = JSON.toJSONString(m);
				printWriter.write(json);
			}
		}

		printWriter.flush();

		return SUCCESS;
	}

	public String listMessagesByPhone() {
		return SUCCESS;

	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response = arg0;
	}

}
