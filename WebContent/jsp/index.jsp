<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<br>注册：
	<form action="phone/save" method="post">
		name<input type="text" name="name"><br> phone<input
			type="text" name="phone"><br> password<input type="text"
			name="password"><br> <input type="submit"
			value="submit"><br>
	</form>
	saveLocation:
	<br>
	<form action="phone/savelocation" method="post">
		Phone: <input type="text" name="userphone"><br> 经度：<input
			type="text" name="latitude"><br> 纬度：<input type="text"
			name="longitude"><br> 精确度:<input type="text"
			name="accuracy"><br> 角度：<input type="text"
			name="direction"><br> <input type="submit"
			value="submit"><br>
	</form>

	<br> 通過手機號查看當前 用戶所在位置：
	<form action="phone/currentlocation" method="post">
		Phone: <input type="text" name="userphone"><br> <input
			type="submit" value="submit"><br>
	</form>


	通過手機號查看當前 用戶所有位置：
	<form action="phone/oldlocation" method="post">
		Phone: <input type="text" name="userid"><br> <input
			type="submit" value="submit"><br>
	</form>



	<br> 添加好友：
	<form action="friends/addfriends" method="post">
		我的电话号码：<input type="text" name="myphone"> <br> 他人号码：<input
			type="text" name="friendphone"> <br> <input
			type="submit" value="submit">
	</form>

	<br> 查找所有好友 通过电话号码：
	<form action="friends/listfriends" method="post">
		我的电话号码：<input type="text" name="myphone"> <br> <input
			type="submit" value="submit">
	</form>

	<br> 删除好友：
	<form action="friends/deletefriend" method="post">
		我的电话号码：<input type="text" name="myphone"> <br> 
		他人号码：<input	type="text" name="friendphone"> <br> <input
			type="submit" value="submit">
	</form>
<br>
留言：
<form action="friends/leavemessages" method="post">

                      我的电话号码：<input type="text" name="myphone"> <br> 
		他人号码：<input	type="text" name="friendphone"> <br> 
		内容：<input	type="text" name="message"><br> 
		<input type="submit" value="submit">
</form>



<br>
查看所有留言：
<form action="friends/listmessages" method="post">
                      我的电话号码：<input type="text" name="myphone"> <br> 
		<input type="submit" value="submit">
</form>

<br>

查看和某人的留言：
<form action="friends/messageswithsomebody" method="post">

                      我的电话号码：<input type="text" name="myphone"> <br> 
		他人号码：<input	type="text" name="friendphone"> <br> 
		<input type="submit" value="submit">
</form>


查看未读留言：
<form action="friends/checkmessages" method="post">
                      我的电话号码：<input type="text" name="myphone"> <br> 
		<input type="submit" value="submit">
</form>

</body>
</html>