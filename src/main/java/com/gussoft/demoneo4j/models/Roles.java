package com.gussoft.demoneo4j.models;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@RelationshipProperties
@Getter
@Setter
public class Roles {

    @RelationshipId
    private Long id;

    private final List<String> roles;

    @TargetNode
    private final Person person;

    @TargetNode
    private final Movie movie;

    public Roles(Person person, List<String> roles, Movie movie) {
        this.person = person;
        this.roles = roles;
        this.movie = movie;
    }

    public List<String> getRoles() {
        return roles;
    }
}
