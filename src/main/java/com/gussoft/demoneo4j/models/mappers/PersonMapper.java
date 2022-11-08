package com.gussoft.demoneo4j.models.mappers;

import com.gussoft.demoneo4j.models.Person;
import com.gussoft.demoneo4j.models.dto.PersonCreateResponse;
import com.gussoft.demoneo4j.models.dto.PersonResponse;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {

    @Autowired
    private ModelMapper mapper;

    public PersonResponse toPersonResponse(Person person) {
        return mapper.map(person, PersonResponse.class);
    }

    public PersonCreateResponse toPersonCreateResponse(Person person) {
        return mapper.map(person, PersonCreateResponse.class);
    }

    public List<PersonResponse> toPersonListResponse(List<Person> persons) {
        return persons.stream()
                .map(pe -> mapper.map(pe, PersonResponse.class))
                .collect(Collectors.toList());
    }

}
