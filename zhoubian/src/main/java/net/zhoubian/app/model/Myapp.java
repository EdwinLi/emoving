package net.zhoubian.app.model;

/**
 * Myapp generated by MyEclipse Persistence Tools
 */

public class Myapp implements java.io.Serializable {

	// Fields

	private Integer id;

	private Integer appId;

	private Long uid;

	// Constructors

	/** default constructor */
	public Myapp() {
	}

	/** minimal constructor */
	public Myapp(Integer appId) {
		this.appId = appId;
	}

	/** full constructor */
	public Myapp(Integer appId, Long uid) {
		this.appId = appId;
		this.uid = uid;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAppId() {
		return this.appId;
	}

	public void setAppId(Integer appId) {
		this.appId = appId;
	}

	public Long getUid() {
		return this.uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

}