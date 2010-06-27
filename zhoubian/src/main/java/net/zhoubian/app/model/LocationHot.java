package net.zhoubian.app.model;

/**
 * LocationHot generated by MyEclipse Persistence Tools
 */

public class LocationHot implements java.io.Serializable {

	// Fields

	private Long locationId;

	private String streetId;

	private String locationName;

	private String provinceId;

	private String cityId;

	private String countyId;

	private Integer sort;

	// Constructors

	/** default constructor */
	public LocationHot() {
	}

	/** minimal constructor */
	public LocationHot(String locationName) {
		this.locationName = locationName;
	}

	/** full constructor */
	public LocationHot(String streetId, String locationName, String provinceId,
			String cityId, String countyId, Integer sort) {
		this.streetId = streetId;
		this.locationName = locationName;
		this.provinceId = provinceId;
		this.cityId = cityId;
		this.countyId = countyId;
		this.sort = sort;
	}

	// Property accessors

	public Long getLocationId() {
		return this.locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public String getStreetId() {
		return this.streetId;
	}

	public void setStreetId(String streetId) {
		this.streetId = streetId;
	}

	public String getLocationName() {
		return this.locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
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

	public Integer getSort() {
		return this.sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

}