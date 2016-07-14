package edu.globant.day9.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Contact extends BaseEntity {

	private String firstName;
	private String lastName;
	@Temporal(TemporalType.DATE)
	private Date birthday;
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

	@OneToMany(mappedBy = "contact", cascade=CascadeType.ALL)
	private List<ContactDetail> contactDetailList;

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

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public List<ContactDetail> getContactDetailList() {
		return contactDetailList;
	}

	public void setContactDetailList(List<ContactDetail> contactDetailList) {
		this.contactDetailList = contactDetailList;
	}

	@Override
	public String toString() {
		return "Contact [id=" + getId() + ", firstName=" + firstName + ", lastName=" + lastName + ", birthday=" + birthday
				+ ", creationDate=" + creationDate + ", contactDetailList=" + contactDetailList + "]";
	}
}
