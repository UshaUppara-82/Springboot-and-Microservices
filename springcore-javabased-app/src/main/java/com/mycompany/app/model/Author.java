package com.mycompany.app.model;

public class Author {

	
		private String authorName;
		private String authorAddress;
		public String getAuthorName() {
			return authorName;
		}
		public void setAuthorName(String authorName) {
			this.authorName = authorName;
		}
		public String getAuthorAddress() {
			return authorAddress;
		}
		public void setAuthorAddress(String authorAddress) {
			this.authorAddress = authorAddress;
		}
		@Override
		public String toString() {
			return "Author [authorName=" + authorName + ", authorAddress=" + authorAddress + "]";
		}
		
		
}
