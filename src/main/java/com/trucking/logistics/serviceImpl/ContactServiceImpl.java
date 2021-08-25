package com.trucking.logistics.serviceImpl;

import com.trucking.logistics.entites.Contact;
import com.trucking.logistics.repositories.ContactRepository;
import com.trucking.logistics.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactRepository contactRepository;

    @Override
    public void updateContact(Contact contact, Long id) {
        Contact contactFromDb = contactRepository.findById(id).get();
        //System.out.println(userFromDb.toString());
        contactFromDb.setPhoneNumber(contact.getPhoneNumber());
        contactFromDb.setEmail(contact.getEmail());
        contactRepository.save(contactFromDb);
    }

    @Override
    public List<Contact> findAllContacts(Long id) {
        return contactRepository.findAll();
    }

    @Override
    public Long createContact(Contact contact) {
        return contactRepository.save(contact).getId();
    }

}
