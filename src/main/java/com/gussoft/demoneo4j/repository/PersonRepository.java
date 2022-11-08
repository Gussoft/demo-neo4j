package com.gussoft.demoneo4j.repository;

import com.gussoft.demoneo4j.models.Person;
import java.util.List;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends Neo4jRepository<Person, Long> {

    List<Person> findByFirstname(String name);

}
