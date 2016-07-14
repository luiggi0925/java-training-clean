package edu.globant.day4.hibernate.domain;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

//@Entity
@Table(name = "contactdetails")
public class ContactDetail extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "contactId")
	private Contact contact;
	private String details;
	@Temporal(TIMESTAMP)
	private Date creationDate;
	@ManyToOne(optional=false)
	@JoinColumn(name = "contactDetailType", insertable=true, updatable=false)
	private ContactDetailType contactDetailType;

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public ContactDetailType getContactDetailType() {
		return contactDetailType;
	}

	public void setContactDetailType(ContactDetailType contactDetailType) {
		this.contactDetailType = contactDetailType;
	}

	@Override
	public String toString() {
		return "ContactDetail [id=" + getId() + ", contactId=" + contact.getId() + ", details=" + details + ", creationDate="
				+ creationDate + ", contactDetailType=" + contactDetailType + "]";
	}
}
