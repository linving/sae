package cn.net.msg.service;

import java.util.List;

import cn.net.msg.model.Current_location;
import cn.net.msg.model.Old_location;
import cn.net.msg.model.User_Phone;

public interface LocationService {
	// ���� ��ַ��Ϣ
	public boolean saveLocation(Old_location location);

	// �����Ñ��Į�ǰ ��ַ��Ϣ
	public boolean saveCurrentLocation(Current_location location);

	// ͨ�� �û���ѯ���洢�ĵ�ַ
	public List<Old_location> listAllLocation(User_Phone user);

	// ͨ���绰�����ȡ��ǰ������Ϣ
	public Current_location getCurrentLocationByPhone(String phone);
}
