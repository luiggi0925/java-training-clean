package edu.globant.day10.dto;

import java.util.Date;
import java.util.List;

public class ContactDto extends BaseEntityDto {

	private String firstName;
	private String lastName;
	private Date birthday;
	private List<ContactDetailDto> contactDetailList;

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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public List<ContactDetailDto> getContactDetailList() {
		return contactDetailList;
	}

	public void setContactDetailList(List<ContactDetailDto> contactDetailList) {
		this.contactDetailList = contactDetailList;
	}
}
