package com.gussoft.demoneo4j.service;

import com.gussoft.demoneo4j.models.Person;
import com.gussoft.demoneo4j.models.dto.PersonRequest;

import java.util.List;

public interface PersonService {

    List<Person> getAll();

    Person findById(Long id);

    Person save(PersonRequest obj);

    Person update(PersonRequest obj, Long id);

    void delete(Long id);

}
