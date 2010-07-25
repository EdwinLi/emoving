package net.zhoubian.app.web.action;

import java.util.Calendar;
import java.util.Date;

import net.zhoubian.app.model.Location;
import net.zhoubian.app.service.MapService;
import net.zhoubian.app.util.GridUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MapAction extends AbstractAction{
	private static Log logger = LogFactory.getLog(MapAction.class);
	private MapService mapService;
	
	public void setMapService(MapService mapService) {
		this.mapService = mapService;
	}

	public String addUserLocation(){
		String locationName = request.getParameter("locationName");
		String subLocType = request.getParameter("subLocType");
		String locationDesc = request.getParameter("locationDesc");
		String longitude = request.getParameter("lngX");
		String latitude = request.getParameter("latY");
		Location location = new Location();
		location.setLocationName(locationName);
		location.setSubLocType(Integer.parseInt(subLocType));
		location.setLocationDesc(locationDesc);
		location.setLocationType(location.USER_LOCATION);
		Date d = Calendar.getInstance().getTime();
		location.setCreateTime(d);
		location.setLongitude(Float.parseFloat(longitude));
		location.setLatitude(Float.parseFloat(latitude));
		location.setId(GridUtil.getOwnGridCode(location.getLatitude(),location.getLongitude()));
		logger.info("location.getId() == "+location.getId());
		mapService.saveLocation(location);
		return "myposition";
	}
}