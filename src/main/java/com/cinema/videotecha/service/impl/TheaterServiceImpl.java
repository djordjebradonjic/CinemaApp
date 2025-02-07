package com.cinema.videotecha.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.videotecha.dto.TheaterResponseDTO;
import com.cinema.videotecha.exception.ResourceNotFoundException;
import com.cinema.videotecha.mapper.TheaterMapper;
import com.cinema.videotecha.model.Theater;
import com.cinema.videotecha.repository.TheaterRepository;
import com.cinema.videotecha.service.TheaterService;

import java.util.List;

@Service
public class TheaterServiceImpl implements TheaterService {

    private final TheaterRepository theaterRepository;

    public TheaterServiceImpl(TheaterRepository theaterRepository) {
        this.theaterRepository = theaterRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<TheaterResponseDTO> getAll() {

        return theaterRepository.findAll()
                .stream()
                .map(TheaterMapper::mapToDTO)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public TheaterResponseDTO getById(Long id) {
        return theaterRepository.findById(id)
                .map(TheaterMapper::mapToDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Theater", "id", id));
    }

    public Theater getOne(Long id) {
        return theaterRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Theater", "id", id));
    }

}
