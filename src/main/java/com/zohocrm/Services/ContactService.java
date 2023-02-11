package com.zohocrm.Services;

import java.util.List;

import com.zohocrm.Entities.Contact;

public interface ContactService {
	public void saveContact(Contact contact);

	public List<Contact> getAllContact();

	public Contact getContactById(long id);

}
