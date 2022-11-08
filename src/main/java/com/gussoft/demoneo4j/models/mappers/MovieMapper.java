package com.gussoft.demoneo4j.models.mappers;

import com.gussoft.demoneo4j.models.Movie;
import com.gussoft.demoneo4j.models.dto.MovieResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieMapper {

    @Autowired
    private ModelMapper mapper;

    public MovieResponse toMovieResponse(Movie movie) {
        return mapper.map(movie, MovieResponse.class);
    }

    public List<MovieResponse> toMovieListResponse(List<Movie> movies) {
        return movies.stream()
                .map(movie -> mapper.map(movie, MovieResponse.class))
                .collect(Collectors.toList());
    }

}
