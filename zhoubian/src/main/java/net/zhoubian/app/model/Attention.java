package net.zhoubian.app.model;

/**
 * Attention generated by MyEclipse Persistence Tools
 */

public class Attention implements java.io.Serializable {

	// Fields

	private Long attentionId;

	private Long uid;

	// Constructors

	/** default constructor */
	public Attention() {
	}

	/** full constructor */
	public Attention(Long uid) {
		this.uid = uid;
	}

	// Property accessors

	public Long getAttentionId() {
		return this.attentionId;
	}

	public void setAttentionId(Long attentionId) {
		this.attentionId = attentionId;
	}

	public Long getUid() {
		return this.uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

}