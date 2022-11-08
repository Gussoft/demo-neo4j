package com.gussoft.demoneo4j.service.impl;

import com.gussoft.demoneo4j.exception.UserException;
import com.gussoft.demoneo4j.models.Movie;
import com.gussoft.demoneo4j.repository.MovieRepository;
import com.gussoft.demoneo4j.service.MovieService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository repo;

    @Override
    @Transactional(readOnly = true)
    public List<Movie> getAll() {
        return repo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Movie findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new UserException("Id no encontrado!"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Movie> findOneByTitle(String title) {
        return repo.findSearchResults(title);
    }

    @Override
    @Transactional
    public Movie save(Movie obj) {
        Movie movie = new Movie();
        movie.setTitle(obj.getTitle());
        movie.setDescription(obj.getDescription());
        movie.setReleased(obj.getReleased());
        movie.setVotes(obj.getVotes());
//        movie.setActors();
        return repo.save(obj);
    }

    @Override
    @Transactional
    public Movie update(Movie obj, Long id) {
        Movie data = findById(id);
        if (data != null) {
            obj.setId(id);
            return repo.save(obj);
        }
        return null;
    }

    @Override
    @Transactional
    public void createRelation(Long id, String actorName, String role) {
        Movie data = findById(id);
        String title = data.getTitle();
        repo.createRelationship(title, actorName, role);
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> findActorsOfMovie(String title) {
        return repo.findActorsOfAMovie(title);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
