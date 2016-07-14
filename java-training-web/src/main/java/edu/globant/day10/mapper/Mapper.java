package edu.globant.day10.mapper;

import java.util.ArrayList;
import java.util.List;

import edu.globant.day10.dto.ContactDetailDto;
import edu.globant.day10.dto.ContactDetailTypeDto;
import edu.globant.day10.dto.ContactDto;
import edu.globant.day9.domain.Contact;
import edu.globant.day9.domain.ContactDetail;
import edu.globant.day9.domain.ContactDetailType;

public class Mapper {

	public ContactDto getContactDto(Contact contact) {
		ContactDto dto = new ContactDto();
		dto.setId(contact.getId());
		dto.setFirstName(contact.getFirstName());
		dto.setLastName(contact.getLastName());
		dto.setBirthday(contact.getBirthday());
		List<ContactDetailDto> contactDetailList = new ArrayList<>(contact.getContactDetailList().size());
		for (ContactDetail contactDetail : contact.getContactDetailList()) {
			contactDetailList.add(getContactDetailDto(contactDetail));
		}
		dto.setContactDetailList(contactDetailList);
		return dto;
	}

	public ContactDetailDto getContactDetailDto(ContactDetail contactDetail) {
		ContactDetailDto dto = new ContactDetailDto();
		dto.setId(contactDetail.getId());
		dto.setContactDetailType(getContactDetailTypeDto(contactDetail.getContactDetailType()));
		dto.setDetails(contactDetail.getDetails());
		return dto;
	}

	public ContactDetailTypeDto getContactDetailTypeDto(ContactDetailType contactDetailType) {
		ContactDetailTypeDto dto = new ContactDetailTypeDto();
		dto.setId(contactDetailType.getId());
		dto.setDescription(contactDetailType.getDescription());
		return dto;
	}
}
