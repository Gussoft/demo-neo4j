package com.gussoft.demoneo4j.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;

//@Node("Person")
@Setter
@Getter
@NoArgsConstructor
public class Actor {

    @Id
    @GeneratedValue
    private Long id;

    private String fullName;

    private int dateNac;

}
