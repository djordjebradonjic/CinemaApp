package com.cinema.videotecha.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ProjectionRequestDTO implements Serializable {

    @Future(message = "Projection start time can't be in the past")
    @NotNull(message = "Projection start time is mandatory")
    private LocalDateTime startTime;
    @NotNull(message = "Ticket price is mandatory")
    @Positive(message = "Ticket price must be greater than 0")
    private Double ticketPrice;
    @NotNull
    private Long movieId;
    @NotNull
    private Long theaterId;

    public ProjectionRequestDTO(LocalDateTime startTime, Double ticketPrice, Long movieId, Long theaterId) {
        this.startTime = startTime;
        this.ticketPrice = ticketPrice;
        this.movieId = movieId;
        this.theaterId = theaterId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public Long getMovieId() {
        return movieId;
    }

    public Long getTheaterId() {
        return theaterId;
    }

}
