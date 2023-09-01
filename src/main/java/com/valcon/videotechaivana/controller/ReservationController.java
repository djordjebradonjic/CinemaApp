package com.valcon.videotechaivana.controller;

import com.valcon.videotechaivana.dto.ReservationRequestDTO;
import com.valcon.videotechaivana.dto.ReservationResponseDTO;
import com.valcon.videotechaivana.service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PreAuthorize("hasAuthority('ROLE_REGISTERED')")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ReservationResponseDTO create(@Valid @RequestBody ReservationRequestDTO reservationRequestDTO) {
        return reservationService.create(reservationRequestDTO);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_REGISTERED')")
    @GetMapping
    public List<ReservationResponseDTO> getAll() {
        return reservationService.getAll();
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_REGISTERED')")
    @GetMapping("/{id}")
    public ReservationResponseDTO getActiveById(@PathVariable Long id) {
        return reservationService.getActiveById(id);
    }

    @PreAuthorize("hasAuthority('ROLE_REGISTERED')")
    @PatchMapping("/{id}")
    public void cancelById(@PathVariable Long id) {
        reservationService.cancelById(id);
    }

}
