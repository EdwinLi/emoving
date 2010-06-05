package net.zhoubian.app.model;

/**
 * Friend generated by MyEclipse Persistence Tools
 */

public class Friend implements java.io.Serializable {

	// Fields

	private Integer id;

	private Long uid;

	private Long fuid;

	// Constructors

	/** default constructor */
	public Friend() {
	}

	/** minimal constructor */
	public Friend(Long fuid) {
		this.fuid = fuid;
	}

	/** full constructor */
	public Friend(Long uid, Long fuid) {
		this.uid = uid;
		this.fuid = fuid;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getUid() {
		return this.uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Long getFuid() {
		return this.fuid;
	}

	public void setFuid(Long fuid) {
		this.fuid = fuid;
	}

}