package com.cinema.videotecha.dto;

public class TheaterResponseDTO {
    private Long id;
    private String name;
    private Integer capacity;

    public TheaterResponseDTO(Long id, String name, Integer capacity) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

}
