package com.trucking.logistics.services;

import com.trucking.logistics.entites.Contact;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContactService {

    void updateContact(Contact contact, Long id);

    Long createContact(Contact contact);

    List<Contact> findAllContacts(Long id);
}
