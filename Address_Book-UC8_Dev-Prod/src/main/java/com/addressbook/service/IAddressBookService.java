package com.addressbook.service;

import com.addressbook.dto.AddressBookDTO;
import com.addressbook.model.AddressBook;

import java.util.List;

public interface IAddressBookService {
    AddressBook addAddress(AddressBookDTO dto);
    List<AddressBook> getAll();
    AddressBook getById(int id);
    AddressBook update(int id, AddressBookDTO dto);
    void delete(int id);
}
