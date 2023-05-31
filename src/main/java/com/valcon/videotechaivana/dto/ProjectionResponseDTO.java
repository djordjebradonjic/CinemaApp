package com.valcon.videotechaivana.dto;

import java.time.LocalDateTime;

public class ProjectionResponseDTO {

    private Long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Double ticketPrice;
    private Integer availableSeats;

    private MovieResponseDTO movieResponseDTO;
    private TheaterResponseDTO theaterResponseDTO;

    public ProjectionResponseDTO(Long id, LocalDateTime startTime, LocalDateTime endTime, Double ticketPrice, Integer availableSeats, MovieResponseDTO movieResponseDTO, TheaterResponseDTO theaterResponseDTO) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.ticketPrice = ticketPrice;
        this.availableSeats = availableSeats;
        this.movieResponseDTO = movieResponseDTO;
        this.theaterResponseDTO = theaterResponseDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public MovieResponseDTO getMovieResponseDTO() {
        return movieResponseDTO;
    }

    public TheaterResponseDTO getTheaterResponseDTO() {
        return theaterResponseDTO;
    }
}
