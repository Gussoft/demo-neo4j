package com.gussoft.demoneo4j.controller;

import com.gussoft.demoneo4j.models.Person;
import com.gussoft.demoneo4j.models.dto.GenericResponse;
import com.gussoft.demoneo4j.models.dto.PersonCreateResponse;
import com.gussoft.demoneo4j.models.dto.PersonRequest;
import com.gussoft.demoneo4j.models.dto.PersonResponse;
import com.gussoft.demoneo4j.models.mappers.PersonMapper;
import com.gussoft.demoneo4j.service.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/v1")
@CrossOrigin("*")
public class PersonController {

    @Autowired
    private PersonService service;

    @Autowired
    private PersonMapper mapper;

    @GetMapping("/persons/")
    public ResponseEntity<List<PersonResponse>> listAll() {
        return ResponseEntity.ok(mapper.toPersonListResponse(service.getAll()));
    }

    @GetMapping("/persons/{id}")
    public ResponseEntity<PersonResponse> listById(
            @PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(mapper.toPersonResponse(service.findById(id)));
    }

    @PostMapping("/persons/")
    public ResponseEntity<PersonCreateResponse> saved(@RequestBody PersonRequest person) {
        return ResponseEntity.ok(mapper.toPersonCreateResponse(service.save(person)));
    }

    @PutMapping("/persons/{id}")
    public ResponseEntity<PersonCreateResponse> updated(
            @RequestBody PersonRequest person, @PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(mapper.toPersonCreateResponse(service.update(person, id)));
    }

    @DeleteMapping("/persons/{id}")
    public ResponseEntity<GenericResponse> delete(
            @PathVariable(name = "id") Long id) {
        service.delete(id);
        return ResponseEntity.ok(new GenericResponse(HttpStatus.OK.value(), "OK"));
    }

}
