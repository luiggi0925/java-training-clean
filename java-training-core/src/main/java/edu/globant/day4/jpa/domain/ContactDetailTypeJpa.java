package edu.globant.day4.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="contactDetailType")
@Table(name = "contactDetailType")
public class ContactDetailTypeJpa extends BaseEntity {
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ContactDetailType [id=" + getId() + ", description=" + description + "]";
	}
}
