package com.gussoft.demoneo4j.controller;

import com.gussoft.demoneo4j.models.Movie;
import com.gussoft.demoneo4j.models.dto.GenericResponse;
import com.gussoft.demoneo4j.models.dto.MovieResponse;
import com.gussoft.demoneo4j.models.dto.RelationRequest;
import com.gussoft.demoneo4j.models.mappers.MovieMapper;
import com.gussoft.demoneo4j.service.MovieService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/v1")
@CrossOrigin("*")
public class MovieController {

    @Autowired
    private MovieService service;

    @Autowired
    private MovieMapper mapper;

    @GetMapping("/movies/")
    public ResponseEntity<List<MovieResponse>> listAll(
            @RequestParam(name = "title", required = false) Optional<String> title) {
        if (title.isPresent()) {
            return ResponseEntity.ok(mapper.toMovieListResponse(service.findOneByTitle(title.get())));
        }
        return ResponseEntity.ok(mapper.toMovieListResponse(service.getAll()));
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<MovieResponse> listById(
            @PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(mapper.toMovieResponse(service.findById(id)));
    }

    @GetMapping("/movies/actors")
    public ResponseEntity<List<String>> listByTitulo(
            @RequestParam(name = "title") Optional<String> title) {
        return ResponseEntity.ok(service.findActorsOfMovie(title.get()));
    }

    @PostMapping("/movies/")
    public ResponseEntity<MovieResponse> saved(@RequestBody Movie movie) {
        return ResponseEntity.ok(mapper.toMovieResponse(service.save(movie)));
    }

    @PutMapping("/movies/{id}")
    public ResponseEntity<MovieResponse> updated(
            @RequestBody Movie movie, @PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(mapper.toMovieResponse(service.update(movie, id)));
    }

    @PutMapping("/movies/relation/{id}")
    public ResponseEntity<GenericResponse> updated(
            @RequestBody RelationRequest relation, @PathVariable(name = "id") Long id) {
        service.createRelation(id, relation.getActorName(), relation.getRole());
        return ResponseEntity.ok(new GenericResponse(HttpStatus.OK.value(), "OK"));
    }


    @DeleteMapping("/movies/{id}")
    public ResponseEntity<GenericResponse> delete(
            @PathVariable(name = "id") Long id) {
        service.delete(id);
        return ResponseEntity.ok(new GenericResponse(HttpStatus.OK.value(), "OK"));
    }

}
