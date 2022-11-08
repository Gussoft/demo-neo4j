package com.gussoft.demoneo4j.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.List;

//@Node("Movie")
@Setter
@Getter
@NoArgsConstructor
public class Pelicula {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String tagline;

    private Integer released;

    private Long votes;

    public Pelicula(String title, String tagline) {
        this.title = title;
        this.tagline = tagline;
    }

    //private List<Personaje> personajes;

}
