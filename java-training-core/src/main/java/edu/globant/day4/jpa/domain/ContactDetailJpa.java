package edu.globant.day4.jpa.domain;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "contactdetails")
public class ContactDetailJpa extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "contactId")
	private ContactJpa contact;
	private String details;
	@Temporal(TIMESTAMP)
	private Date creationDate;
	@ManyToOne(optional=false)
	@JoinColumn(name = "contactDetailType", insertable=true, updatable=false)
	private ContactDetailTypeJpa contactDetailType;

	public ContactJpa getContact() {
		return contact;
	}

	public void setContact(ContactJpa contact) {
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

	public ContactDetailTypeJpa getContactDetailType() {
		return contactDetailType;
	}

	public void setContactDetailType(ContactDetailTypeJpa contactDetailType) {
		this.contactDetailType = contactDetailType;
	}

	@Override
	public String toString() {
		return "ContactDetail [id=" + getId() + ", contactId=" + contact.getId() + ", details=" + details + ", creationDate="
				+ creationDate + ", contactDetailType=" + contactDetailType + "]";
	}
}
