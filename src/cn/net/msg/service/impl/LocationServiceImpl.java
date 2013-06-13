package cn.net.msg.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.net.msg.dao.LocationDao;
import cn.net.msg.model.Current_location;
import cn.net.msg.model.Old_location;
import cn.net.msg.model.User_Phone;
import cn.net.msg.service.LocationService;

@Transactional
@Service(value = "locationService")
public class LocationServiceImpl implements LocationService {
	private LocationDao locatonDao;

	public LocationDao getLocatonDao() {
		return locatonDao;
	}

	@Resource(name = "locatonDao")
	public void setLocatonDao(LocationDao locatonDao) {
		this.locatonDao = locatonDao;
	}

	@Override
	public boolean saveLocation(Old_location location) {
		// TODO Auto-generated method stub
		locatonDao.saveLocation(location);
		return true;
	}

	@Override
	public boolean saveCurrentLocation(Current_location location) {
		// TODO Auto-generated method stub
		locatonDao.saveCurrentLocation(location);
		return true;
	}

	@Override
	public List<Old_location> listAllLocation(User_Phone user) {
		// TODO Auto-generated method stub

		return locatonDao.listAllLocation(user);
	}

	@Override
	public Current_location getCurrentLocationByPhone(String phone) {
		// TODO Auto-generated method stub
		return locatonDao.getCurrentLocationByPhone(phone);
	}

}
