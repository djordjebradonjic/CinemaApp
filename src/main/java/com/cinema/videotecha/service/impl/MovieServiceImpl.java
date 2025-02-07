package com.cinema.videotecha.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.videotecha.dto.MovieRequestDTO;
import com.cinema.videotecha.dto.MovieResponseDTO;
import com.cinema.videotecha.exception.BusinessLogicException;
import com.cinema.videotecha.exception.ResourceAlreadyExistsException;
import com.cinema.videotecha.exception.ResourceNotFoundException;
import com.cinema.videotecha.mapper.MovieMapper;
import com.cinema.videotecha.model.Movie;
import com.cinema.videotecha.model.Projection;
import com.cinema.videotecha.repository.MovieRepository;
import com.cinema.videotecha.service.MovieService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Transactional
    @Override
    public MovieResponseDTO create(MovieRequestDTO movieRequestDTO) {
        Movie movie = MovieMapper.mapToEntity(movieRequestDTO);
        Optional<Movie> existingMovie = movieRepository.findByNameAndDeletedFalse(movie.getName());
        if (existingMovie.isPresent()) {
            throw new ResourceAlreadyExistsException("Movie", "id", existingMovie.get().getId());
        }
        Movie createdMovie = movieRepository.save(movie);
        return MovieMapper.mapToDTO(createdMovie);
    }


    @Override
    @Transactional(readOnly = true)
    public MovieResponseDTO getById(Long id) {
        Movie existingMovie = getOne(id);
        return MovieMapper.mapToDTO(existingMovie);

    }

    @Override
    @Transactional(readOnly = true)
    public List<MovieResponseDTO> getAll() {
        return movieRepository.findByDeletedFalse()
                .stream()
                .map(MovieMapper::mapToDTO)
                .toList();
    }

    public Movie getOne(Long id) {
        return movieRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> new ResourceNotFoundException("Movie", "id", id));
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        Movie movie = movieRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> new ResourceNotFoundException("Movie", "id", id));

        if (!getActiveProjections(movie.getProjections()).isEmpty()) {
            throw new BusinessLogicException("This movie cannot be deleted because there are active projections for that movie.");
        }
        movie.setDeleted(true);

        movieRepository.save(movie);

    }

    @Transactional
    @Override
    public MovieResponseDTO update(MovieRequestDTO movieRequestDTO, Long id) {
        Movie updateMovie = MovieMapper.mapToEntity(movieRequestDTO);
        if (!movieRepository.existsByIdAndDeletedFalse(id)) {
            throw new ResourceNotFoundException("Movie", "id", id);
        }
        if (!getActiveProjections(updateMovie.getProjections()).isEmpty()) {
            throw new BusinessLogicException("This movie cannot be updated because there are active projections for that movie.");
        }

        updateMovie.setId(id);
        Movie movie = movieRepository.save(updateMovie);
        return MovieMapper.mapToDTO(movie);

    }

    private boolean isActiveProjection(Projection projection) {
        return !projection.getStartTime().isBefore(LocalDateTime.now());
    }

    public List<Projection> getActiveProjections(List<Projection> projections) {
        return projections.stream()
                .filter(p -> !p.isDeleted() && isActiveProjection(p))
                .toList();
    }


}
