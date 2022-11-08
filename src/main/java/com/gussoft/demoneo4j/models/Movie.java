package com.gussoft.demoneo4j.models;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.Relationship.Direction;

@Node
@Setter
@Getter
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue //String id -> @GeneratedValue(UUIDStringGenerator.class)
    private Long id;

    private String title;

    @Property("tagline")
    private String description;

    private Integer released;

    private Long votes;

    @Relationship(type = "ACTED_IN", direction = Direction.INCOMING)
    private List<Roles> actors;

//    @Relationship(type = "DIRECTED", direction = Direction.INCOMING)
//    private List<Person> directors = new ArrayList<>();

    public Movie(String title, String description) {
        this.id = null;
        this.title = title;
        this.description = description;
    }

    public Movie withId(Long id) {
        if (this.id.equals(id)) {
            return this;
        } else {
            Movie data = new Movie(this.title, this.description);
            data.setId(id);
            return data;
        }
    }
}
