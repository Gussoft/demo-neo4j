package com.gussoft.demoneo4j.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.AccessType.Type;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node("person")
@Setter
@Getter
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue //String id -> @GeneratedValue(UUIDStringGenerator.class)
    private Long id;

    private String firstname;

    private String lastname;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private LocalDate birthday;

    private Integer age;

    private String comment;
    private @AccessType(Type.PROPERTY) String remarks;

    @Relationship(type = "ACTED_IN")
    private List<Movie> movies;


    public static Person of(String firstname, String lastname, LocalDate birthday) {
        return new Person(null, firstname, lastname, birthday,
                Period.between(birthday, LocalDate.now()).getYears());
    }

    public Person(Long id, String firstname, String lastname, LocalDate birthday, Integer age) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.age = age;
    }

    public Person(Long id, String firstname, String lastname, LocalDate birthday) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
    }

    public Person withId(Long id) {
        return new Person(id, this.firstname, this.lastname, this.birthday);
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
