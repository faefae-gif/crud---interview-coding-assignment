package com.example.crud.service;

import com.example.crud.Entity.Person;
import java.util.List;

public interface PersonService {

    Person createPerson(Person person);
    Person getPersonById(Long personId);
    List<Person> getAllPerson();
    Person updatePerson(Person person);
    void deletePerson(Long personId);

}
