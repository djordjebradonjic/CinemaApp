package com.cinema.videotecha.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.videotecha.dto.ProjectionRequestDTO;
import com.cinema.videotecha.dto.ProjectionResponseDTO;
import com.cinema.videotecha.exception.BusinessLogicException;
import com.cinema.videotecha.exception.ResourceNotFoundException;
import com.cinema.videotecha.mapper.ProjectionMapper;
import com.cinema.videotecha.model.Movie;
import com.cinema.videotecha.model.Projection;
import com.cinema.videotecha.model.Theater;
import com.cinema.videotecha.repository.ProjectionRepository;
import com.cinema.videotecha.service.MovieService;
import com.cinema.videotecha.service.ProjectionService;
import com.cinema.videotecha.service.TheaterService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProjectionServiceImpl implements ProjectionService {


    private final ProjectionRepository projectionRepository;
    private final MovieService movieService;
    private final TheaterService theaterService;


    public ProjectionServiceImpl(ProjectionRepository projectionRepository, MovieService movieService, TheaterService theaterService) {
        this.projectionRepository = projectionRepository;
        this.movieService = movieService;
        this.theaterService = theaterService;
    }

    @Override
    @Transactional
    public ProjectionResponseDTO create(ProjectionRequestDTO projectionRequestDTO) {

        final Movie movie = movieService.getOne(projectionRequestDTO.getMovieId());
        final Theater theater = theaterService.getOne(projectionRequestDTO.getTheaterId());

        LocalDateTime startTime = projectionRequestDTO.getStartTime();
        checkStartTime(startTime);
        LocalDateTime endTime = getEndTime(startTime, movie);

        checkOverlappingProjections(startTime, endTime, theater.getId());

        Projection newProjection = new Projection(startTime, projectionRequestDTO.getTicketPrice(), endTime, movie, theater, theater.getCapacity());

        final Projection savedProjection = projectionRepository.save(newProjection);
        return ProjectionMapper.mapToDTO(savedProjection);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProjectionResponseDTO> getAllAvailable() {
        return projectionRepository.findAllAvailable()
                .stream()
                .map(ProjectionMapper::mapToDTO)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ProjectionResponseDTO getById(Long id) {
        Projection existingProjection = getOne(id);
        return ProjectionMapper.mapToDTO(existingProjection);

    }

    @Override
    public Projection getOne(Long id) {
        return projectionRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> new ResourceNotFoundException("Projection", "id", id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProjectionResponseDTO> getAllActive() {
        return projectionRepository.findByDeletedFalseAndStartTimeAfter(LocalDateTime.now())
                .stream()
                .map(ProjectionMapper::mapToDTO)
                .toList();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Projection existingProjection = projectionRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Projection", "id", id));
        existingProjection.setDeleted(true);
        projectionRepository.save(existingProjection);

    }

    private void checkOverlappingProjections(LocalDateTime startTime, LocalDateTime endTime, Long theaterId) {
        int numberOverlappingProjections = projectionRepository.findOverlappingProjections(startTime, endTime, theaterId);
        if (numberOverlappingProjections > 0) {
            throw new BusinessLogicException("Projections overlap");
        }
    }

    private LocalDateTime getEndTime(LocalDateTime startTime, Movie movie) {
        return startTime.plusMinutes(movie.getDuration());
    }

    private void checkStartTime(LocalDateTime startTime) {
        if (startTime.isBefore(LocalDateTime.now())) {
            throw new BusinessLogicException("Projection start time is in past");
        }
    }


}
