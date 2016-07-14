package edu.globant.day4.jpa.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="contact")
public class ContactJpa extends BaseEntity {

	private String firstName;
	private String lastName;
	@Temporal(TemporalType.DATE)
	private Date birthday;
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

	@OneToMany(mappedBy = "contact", cascade=CascadeType.ALL)
	private List<ContactDetailJpa> contactDetailList;

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

	public List<ContactDetailJpa> getContactDetailList() {
		return contactDetailList;
	}

	public void setContactDetailList(List<ContactDetailJpa> contactDetailList) {
		this.contactDetailList = contactDetailList;
	}

	@Override
	public String toString() {
		return "Contact [id=" + getId() + ", firstName=" + firstName + ", lastName=" + lastName + ", birthday=" + birthday
				+ ", creationDate=" + creationDate + ", contactDetailList=" + contactDetailList + "]";
	}
}
