package org.jht.domain;

public class RestSampleDTO {
	private int mno;
	private String firstName;
	private String lastName;
	
	public RestSampleDTO(int mno, String firstname, String lastname) {// 매개변수 생성자
		this.mno=mno;
		this.firstName=firstname;
		this.lastName=lastname;
	}
	
	public RestSampleDTO() {
		
	}
	
	
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return "RestSampleDTO [mno=" + mno + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
}
