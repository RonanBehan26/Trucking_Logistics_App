package com.trucking.logistics.controllers;


import com.trucking.logistics.entites.Contact;
import com.trucking.logistics.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PutMapping("/contact/{id}")//
    public void updateContact(@RequestBody Contact contact, @PathVariable Long id) {
        contactService.updateContact(contact, id);
    }

    @GetMapping("/contact")//
    public List<Contact> getAllContacts(@PathVariable("id") Long id) {
        return contactService.findAllContacts(id);
    }

    @PostMapping("/contact")// to be used once
    public Long createContact(@Validated @RequestBody Contact contact) {
        return contactService.createContact(contact);
    }

}
