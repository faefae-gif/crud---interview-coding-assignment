package com.example.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.crud.Entity.Person;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findById(Long personId);
    Person save(Person person);
    List<Person> findAll();
    void deleteById(Long userId);
}
