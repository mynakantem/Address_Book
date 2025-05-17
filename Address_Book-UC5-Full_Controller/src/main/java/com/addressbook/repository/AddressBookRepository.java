package com.addressbook.repository;

import com.addressbook.model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressBookRepository extends JpaRepository<AddressBook, Integer> {
}
