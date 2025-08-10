package com.mycompany.app.model;

public class State {
	
	private String stateName;
	private String region;
	
	public State() {
		System.out.println(" Inside State empty construtor");
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	@Override
	public String toString() {
		return "State [stateName=" + stateName + ", region=" + region + "]";
	}
	
	

}
