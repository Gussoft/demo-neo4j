package com.gussoft.demoneo4j.models;

import com.gussoft.demoneo4j.exception.UserException;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.TargetNode;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@RelationshipProperties
public class Personaje {

    @Id
    @GeneratedValue
    private Long id;

    private List<String> roles;

    @TargetNode
    private Actor actor;

    public void validate() throws UserException {
        if (roles.isEmpty()) {
            throw new UserException("Debe ingresar al menos un rol para el personaje");
        }

        if (actor == null) {
            throw new UserException("Debe ingresar que actor cumple ese personaje");
        }
    }
}
