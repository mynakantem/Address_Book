package com.addressbook.service;

import com.addressbook.dto.AddressBookDTO;
import com.addressbook.model.AddressBook;
import com.addressbook.repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AddressBookService implements IAddressBookService {

    @Autowired
    private AddressBookRepository repository;

    @Override
    public AddressBook addAddress(AddressBookDTO dto) {
        log.info("Adding new address: {}", dto);
        AddressBook ab = new AddressBook();
        ab.setName(dto.getName());
        ab.setAddress(dto.getAddress());
        return repository.save(ab);
    }

    @Override
    public List<AddressBook> getAll() {
        log.info("Fetching all addresses");
        return repository.findAll();
    }

    @Override
    public AddressBook getById(int id) {
        log.info("Fetching address with id: {}", id);
        return repository.findById(id).orElseThrow(() -> {
            log.error("Address not found for id: {}", id);
            return new RuntimeException("Address not found");
        });
    }

    @Override
    public AddressBook update(int id, AddressBookDTO dto) {
        log.info("Updating address id: {} with data: {}", id, dto);
        AddressBook ab = getById(id);
        ab.setName(dto.getName());
        ab.setAddress(dto.getAddress());
        return repository.save(ab);
    }

    @Override
    public void delete(int id) {
        log.info("Deleting address with id: {}", id);
        repository.deleteById(id);
    }
}
