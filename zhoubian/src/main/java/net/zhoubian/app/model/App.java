package net.zhoubian.app.model;

/**
 * App generated by MyEclipse Persistence Tools
 */

public class App implements java.io.Serializable {

	// Fields

	private Integer appId;

	private String apiKey;

	private String secret;

	// Constructors

	/** default constructor */
	public App() {
	}

	/** full constructor */
	public App(String apiKey, String secret) {
		this.apiKey = apiKey;
		this.secret = secret;
	}

	// Property accessors

	public Integer getAppId() {
		return this.appId;
	}

	public void setAppId(Integer appId) {
		this.appId = appId;
	}

	public String getApiKey() {
		return this.apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getSecret() {
		return this.secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

}