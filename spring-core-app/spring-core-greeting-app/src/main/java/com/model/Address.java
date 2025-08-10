package com.model;

import org.springframework.stereotype.Component;

@Component
public class Address {
		
		int doorno;
		String streetAddr;
		String cityName;
		String pincode;
		public int getDoorno() {
			return doorno;
		}
		public void setDoorno(int doorno) {
			this.doorno = doorno;
		}
		public String getStreetAddr() {
			return streetAddr;
		}
		public void setStreetAddr(String streetAddr) {
			this.streetAddr = streetAddr;
		}
		public String getCityName() {
			return cityName;
		}
		public void setCityName(String cityName) {
			this.cityName = cityName;
		}
		public String getPincode() {
			return pincode;
		}
		public void setPincode(String pincode) {
			this.pincode = pincode;
		}
		
		public Address() {
			super();
		}
		public Address(int doorno, String streetAddr, String cityName, String pincode) {
			super();
			this.doorno = doorno;
			this.streetAddr = streetAddr;
			this.cityName = cityName;
			this.pincode = pincode;
		}
		@Override
		public String toString() {
			return "Address [doorno=" + doorno + ", streetAddr=" + streetAddr + ", cityName=" + cityName + ", pincode="
					+ pincode + "]";
		}
		
}
