package com.valcon.videotechaivana.service.impl;

import com.valcon.videotechaivana.dto.TheaterResponseDTO;
import com.valcon.videotechaivana.exception.ResourceNotFoundException;
import com.valcon.videotechaivana.mapper.TheaterMapper;
import com.valcon.videotechaivana.model.Theater;
import com.valcon.videotechaivana.repository.TheaterRepository;
import com.valcon.videotechaivana.service.TheaterService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
