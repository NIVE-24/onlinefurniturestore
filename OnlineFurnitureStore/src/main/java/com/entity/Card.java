package com.entity;

public class Card {
	private String cardNum;
	private String cvv;
	private ExpiryDate expiryDate;
	
	public Card() {
		super();
	}
	
	public Card(String cardNum, String cvv, ExpiryDate expiryDate) {
		super();
		this.cardNum = cardNum;
		this.cvv = cvv;
		this.expiryDate = expiryDate;
	}

	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public ExpiryDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(ExpiryDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	
	public class ExpiryDate {
		private String month;
		private String year;
		
		public ExpiryDate() {
			super();
		}

		public ExpiryDate(String month, String year) {
			super();
			this.month = month;
			this.year = year;
		}
		
		public String getMonth() {
			return month;
		}
		public void setMonth(String month) {
			this.month = month;
		}
		public String getYear() {
			return year;
		}
		public void setYear(String year) {
			this.year = year;
		}
		
		
	}

}
