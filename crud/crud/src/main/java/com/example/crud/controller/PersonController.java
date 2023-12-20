package com.example.crud.controller;

import com.example.crud.service.PersonService;
import lombok.AllArgsConstructor;
import com.example.crud.Entity.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("persons")

public class PersonController {

    private PersonService personService;
    // build create Person REST API

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
        Person savedPerson =  personService.createPerson(person);
        return new ResponseEntity<>(savedPerson, HttpStatus.CREATED);
    }

    // build get person by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("id") Long personId){
        Person person = userService.getPersonById(personId);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    // Build Get All Person REST API
    @GetMapping
    public ResponseEntity<List<Person>> getAllPerson(){
        List<Person> person = personService.getAllPerson();
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    // Build Update Person REST API
    @PutMapping("{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable("id") Long personId,
                                             @RequestBody Person person){
        person.setId(personId);
        Person updatedPerson = personService.updatePerson(person);
        return new ResponseEntity<>(updatedPerson, HttpStatus.OK);
    }

    // Build Delete User REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePerson(@PathVariable("id") Long personId){
        personService.deletePerson(personId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }
}
