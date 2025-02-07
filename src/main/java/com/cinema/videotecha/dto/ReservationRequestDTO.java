package com.cinema.videotecha.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class ReservationRequestDTO {
    @NotNull(message = "User ID is mandatory")
    private Long userId;
    @NotNull(message = "Projection ID is mandatory")
    private Long projectionId;
    @Min(value = 1, message = "Invalid number of tickets")
    private int numberOfTickets;

    public ReservationRequestDTO(Long userId, Long projectionId, int numberOfTickets) {
        this.userId = userId;
        this.projectionId = projectionId;
        this.numberOfTickets = numberOfTickets;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getProjectionId() {
        return projectionId;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }
}
