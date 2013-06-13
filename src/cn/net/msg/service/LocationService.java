package cn.net.msg.service;

import java.util.List;

import cn.net.msg.model.Current_location;
import cn.net.msg.model.Old_location;
import cn.net.msg.model.User_Phone;

public interface LocationService {
	// 保存 地址信息
	public boolean saveLocation(Old_location location);

	// 保存用戶的當前 地址信息
	public boolean saveCurrentLocation(Current_location location);

	// 通过 用户查询他存储的地址
	public List<Old_location> listAllLocation(User_Phone user);

	// 通过电话号码获取当前地理信息
	public Current_location getCurrentLocationByPhone(String phone);
}
