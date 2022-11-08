package com.gussoft.demoneo4j.service.impl;

import com.gussoft.demoneo4j.exception.UserException;
import com.gussoft.demoneo4j.models.Person;
import com.gussoft.demoneo4j.models.dto.PersonRequest;
import com.gussoft.demoneo4j.repository.PersonRepository;
import com.gussoft.demoneo4j.service.PersonService;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository repo;

    @Override
    public List<Person> getAll() {
        return repo.findAll();
    }

    @Override
    public Person findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new UserException("Id no encontrado!"));
    }

    @Override
    public Person save(PersonRequest obj) {
        Person data = Person.of(obj.getFirstname(), obj.getLastname(), obj.getBirthday());
        return repo.save(data);
    }

    @Override
    public Person update(PersonRequest obj, Long id) {
        Person data = findById(id);
        if (data != null) {
            data = Person.of(obj.getFirstname(), obj.getLastname(), obj.getBirthday());
            data.setId(id);
            return repo.save(data);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
