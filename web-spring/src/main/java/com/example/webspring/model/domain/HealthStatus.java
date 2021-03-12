package com.example.webspring.model.domain;

public class HealthStatus {
	
	private boolean tomcatStatus;
	private boolean springStatus;
	
	public boolean isTomcatStatus() {
		return tomcatStatus;
	}
	public void setTomcatStatus(boolean tomcatStatus) {
		this.tomcatStatus = tomcatStatus;
	}
	public boolean isSpringStatus() {
		return springStatus;
	}
	public void setSpringStatus(boolean springStatus) {
		this.springStatus = springStatus;
	}

}
