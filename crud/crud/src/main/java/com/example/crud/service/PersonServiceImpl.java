package com.example.crud.service;

import com.example.crud.Entity.Person;
import com.example.crud.repository.PersonRepository;
import com.example.crud.service.PersonService;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor

public class PersonServiceImpl implements PersonService{

    private PersonRepository personRepository;
    @Override

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person getPersonById(Long personId) {
        Optional<Person> optionalPerson = personRepository.findById(personId);
        return optionalPerson.get();
    }
    @Override
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }
    
    @Override
    public Person updatePerson(Person person) {
        Person existingPerson = personRepository.findById(person.getId()).get();
        existingPerson.setFirstName(person.getFirstName());
        existingPerson.setLastName(person.getLastName());
        existingPerson.setGender(person.getGender());
        Person updatedPerson = personRepository.save(existingPerson);
        return updatedPerson;
    }

    @Override
    public void deletePerson(Long userId) {
        personRepository.deleteById(userId);
    }
}

}
}
