package com.mycompany.app;

public class Engine {
	
	int engineNo;
	String engineModelName;
	public int getEngineNo() {
		return engineNo;
	}
	public void setEngineNo(int engineNo) {
		this.engineNo = engineNo;
	}
	public String getEngineModelName() {
		return engineModelName;
	}
	public void setEngineModelName(String engineModelName) {
		this.engineModelName = engineModelName;
	}
	@Override
	public String toString() {
		return "Engine [engineNo=" + engineNo + ", engineModelName=" + engineModelName + "]";
	}
	
	

}
