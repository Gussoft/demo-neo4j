package com.gussoft.demoneo4j.service;

import com.gussoft.demoneo4j.models.Movie;
import java.util.List;

public interface MovieService {

    List<Movie> getAll();

    Movie findById(Long id);

    List<Movie> findOneByTitle(String title);

    Movie save(Movie obj);

    Movie update(Movie obj, Long id);

    void createRelation(Long id, String actorName, String role);

    List<String> findActorsOfMovie(String title);

    void delete(Long id);

}
