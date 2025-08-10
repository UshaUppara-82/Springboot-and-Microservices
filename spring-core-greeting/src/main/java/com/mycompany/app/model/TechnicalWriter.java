package com.mycompany.app.model;

public class TechnicalWriter  implements Writer{
	
	private Award award;
	
	public TechnicalWriter() {
		this.award = new Award();
	}

	@Override
	public void write() {
		// TODO Auto-generated method stub
		System.out.println(" Write technical stuffs ...");
	}

	
	//Method based injection -> 
	@Override
	public void getAward() {
		// TODO Auto-generated method stub
		
		award.award();
		
	}

}
