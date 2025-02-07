package com.cinema.videotecha.model;

import jakarta.persistence.*;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="number_seats", nullable = false)
    private int numberOfTickets;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Projection projection;
    private boolean canceled;

    public Reservation() {
    }

    public Reservation(int numberOfTickets, User user, Projection projection) {
        this.numberOfTickets = numberOfTickets;
        this.user = user;
        this.projection = projection;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Projection getProjection() {
        return projection;
    }

    public void setProjection(Projection projection) {
        this.projection = projection;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }
}
