package com.valcon.videotechaivana.dto;

public class ReservationResponseDTO {
    private Long id;
    private UserResponseDTO userResponseDTO;

    private ProjectionResponseDTO projectionResponseDTO;
    private int numberOfTickets;

    public ReservationResponseDTO(Long id, UserResponseDTO userResponseDTO, ProjectionResponseDTO projectionResponseDTO, int numberOfTickets) {
        this.id = id;
        this.userResponseDTO = userResponseDTO;
        this.projectionResponseDTO = projectionResponseDTO;
        this.numberOfTickets = numberOfTickets;
    }

    public Long getId() {
        return id;
    }

    public UserResponseDTO getUserResponseDTO() {
        return userResponseDTO;
    }

    public ProjectionResponseDTO getProjectionResponseDTO() {
        return projectionResponseDTO;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }
}
