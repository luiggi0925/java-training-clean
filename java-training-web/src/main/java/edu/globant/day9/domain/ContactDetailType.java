package edu.globant.day9.domain;

import javax.persistence.Entity;

@Entity
public class ContactDetailType extends BaseEntity {
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
