package net.zhoubian.app.service.impl;

import java.util.List;

import net.zhoubian.app.dao.LocationDao;
import net.zhoubian.app.model.Location;
import net.zhoubian.app.service.MapService;

public class MapServiceImpl implements MapService{
	private LocationDao locationDao;
	
	public void setLocationDao(LocationDao locationDao) {
		this.locationDao = locationDao;
	}

	public void saveLocation(Location location){
		locationDao.addObject(location);
	}
	public List<Location> findLocationsByUid(long uid){
		return locationDao.findLocationsByUid(uid);
	}

	public Location findLocationsById(long id) {
		return locationDao.getObjectByID(id);
	}
}
