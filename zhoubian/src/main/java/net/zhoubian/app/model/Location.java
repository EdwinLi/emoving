package net.zhoubian.app.model;

import java.util.Date;

/**
 * LocationNamed generated by MyEclipse Persistence Tools
 */

public class Location implements java.io.Serializable {

	// Fields
	public static final int USER_LOCATION = 1;
	public static final int ENTITY_LOCATION = 2;
	public static final String status_valid = "1";
	public static final String status_invalid = "0";
	private Long id;

	private String locationName;

	private Integer locationType;
	
	private Integer subLocType;

	private String provinceId;

	private String cityId;

	private String countyId;

	private String streetId;

	private Float longitude;

	private Float latitude;

	private Long uid;

	private Date createTime;

	private String status;
	
	private String locationDesc;

	private String indexStatus; // 索引状态，默认为0,0:未索引 ，1:已索引
	public static String UNINDEXED = "0";
	public static String INDEXED = "1";
	// Constructors

	/** default constructor */
	public Location() {
	}

	

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocationName() {
		return this.locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public Integer getLocationType() {
		return this.locationType;
	}

	public void setLocationType(Integer locationType) {
		this.locationType = locationType;
	}

	public String getProvinceId() {
		return this.provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public String getCityId() {
		return this.cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCountyId() {
		return this.countyId;
	}

	public void setCountyId(String countyId) {
		this.countyId = countyId;
	}

	public String getStreetId() {
		return this.streetId;
	}

	public void setStreetId(String streetId) {
		this.streetId = streetId;
	}

	public Float getLongitude() {
		return this.longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public Float getLatitude() {
		return this.latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Long getUid() {
		return this.uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



	public Integer getSubLocType() {
		return subLocType;
	}



	public void setSubLocType(Integer subLocType) {
		this.subLocType = subLocType;
	}



	public String getLocationDesc() {
		return locationDesc;
	}



	public void setLocationDesc(String locationDesc) {
		this.locationDesc = locationDesc;
	}
	public void setIndexStatus(String indexStatus) {
		this.indexStatus = indexStatus;
	}
	public String getIndexStatus() {
		return indexStatus;
	}
	

}