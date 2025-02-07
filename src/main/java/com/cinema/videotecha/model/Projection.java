package com.cinema.videotecha.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Projection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "ticket_price", nullable = false)
    private Double ticketPrice;

    @Column(name = "end_time", nullable = false)
    private LocalDateTime endTime;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Theater theater;

    @Column(name = "available_seats", nullable = false)
    private Integer availableSeats;

    private boolean deleted;

    @OneToMany(mappedBy = "projection")
    private List<Reservation> reservations;

    public Projection() {
    }

    public Projection(LocalDateTime startTime, Double ticketPrice, LocalDateTime endTime, Movie movie, Theater theater, int availableSeats) {
        this.startTime = startTime;
        this.ticketPrice = ticketPrice;
        this.endTime = endTime;
        this.movie = movie;
        this.theater = theater;
        this.availableSeats = availableSeats;
        reservations = new ArrayList<>();

    }

    public Projection(Long id, LocalDateTime startTime, Double ticketPrice, LocalDateTime endTime, Movie movie, Theater theater, Integer availableSeats) {
        this.id = id;
        this.startTime = startTime;
        this.ticketPrice = ticketPrice;
        this.endTime = endTime;
        this.movie = movie;
        this.theater = theater;
        this.availableSeats = availableSeats;
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

    public Double getTicketPrice() {
        return ticketPrice;
    }


    public Movie getMovie() {
        return movie;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {

        this.theater = theater;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

}
