package net.zhoubian.app.model;

import java.util.Date;

/**
 * InfoNew generated by MyEclipse Persistence Tools
 */

public class InfoNew implements java.io.Serializable {

	// Fields

	private Integer id;

	private Long infoId;

	private String cityId;

	private Integer sort;

	private Date createTime;

	// Constructors

	/** default constructor */
	public InfoNew() {
	}

	/** minimal constructor */
	public InfoNew(Long infoId) {
		this.infoId = infoId;
	}

	/** full constructor */
	public InfoNew(Long infoId, String cityId, Integer sort, Date createTime) {
		this.infoId = infoId;
		this.cityId = cityId;
		this.sort = sort;
		this.createTime = createTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getInfoId() {
		return this.infoId;
	}

	public void setInfoId(Long infoId) {
		this.infoId = infoId;
	}

	public String getCityId() {
		return this.cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public Integer getSort() {
		return this.sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}