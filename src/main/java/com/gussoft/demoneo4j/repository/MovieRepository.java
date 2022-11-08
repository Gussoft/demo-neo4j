package com.gussoft.demoneo4j.repository;

import com.gussoft.demoneo4j.models.Movie;
import java.util.List;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends Neo4jRepository<Movie, Long> {

    Movie findOneByTitle(String title);

    @Query("MATCH (movie:Movie) WHERE movie.title CONTAINS $title RETURN movie")
    List<Movie> findSearchResults(@Param("title") String title);

    @Query("MATCH (m:Movie {title: $title}) MATCH (p:Person {name: $actorName}) "
            + "CREATE (p)-[r:ACTED_IN {roles:[$role]}]->(m) return p")
    void createRelationship(
            @Param("title") String title,
            @Param("actorName") String actorName,
            @Param("role") String role);

    @Query("MATCH (m:Movie)<-[:ACTED_IN]-(a:Person) WHERE m.title =~ ('(?i).*'+$title+'.*') RETURN a.firstname")
    List<String> findActorsOfAMovie(@Param("title") String title);

}
