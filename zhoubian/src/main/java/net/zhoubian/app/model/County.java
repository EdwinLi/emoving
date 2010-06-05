package net.zhoubian.app.model;

/**
 * County generated by MyEclipse Persistence Tools
 */

public class County implements java.io.Serializable {

	// Fields

	private String countyId;

	private String countyName;

	private String cityId;

	private String provinceId;

	// Constructors

	/** default constructor */
	public County() {
	}

	/** full constructor */
	public County(String countyName, String cityId, String provinceId) {
		this.countyName = countyName;
		this.cityId = cityId;
		this.provinceId = provinceId;
	}

	// Property accessors

	public String getCountyId() {
		return this.countyId;
	}

	public void setCountyId(String countyId) {
		this.countyId = countyId;
	}

	public String getCountyName() {
		return this.countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

	public String getCityId() {
		return this.cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getProvinceId() {
		return this.provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

}