package edu.globant.day10.dto;

public class ContactDetailDto extends BaseEntityDto {

	private String details;
	private ContactDetailTypeDto contactDetailType;

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public ContactDetailTypeDto getContactDetailType() {
		return contactDetailType;
	}

	public void setContactDetailType(ContactDetailTypeDto contactDetailType) {
		this.contactDetailType = contactDetailType;
	}
}
