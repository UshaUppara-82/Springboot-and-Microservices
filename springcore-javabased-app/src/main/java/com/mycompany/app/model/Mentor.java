package com.mycompany.app.model;

import java.util.Iterator;
import java.util.List;

public class Mentor {
	
	private int mid;
	private String nm;
	private List<String> modules;
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getNm() {
		return nm;
	}
	public void setNm(String nm) {
		this.nm = nm;
	}
	public List<String> getModules() {
		return modules;
	}
	public void setModules(List<String> modules) {
		this.modules = modules;
	}
	
	public void display() {
		System.out.println("Mentor Id: " + mid);
		System.out.println("Mentor Name: " + nm);
		
		Iterator i = modules.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
	}

}

