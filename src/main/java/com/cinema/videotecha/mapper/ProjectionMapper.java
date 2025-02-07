package com.cinema.videotecha.mapper;


import com.cinema.videotecha.dto.ProjectionResponseDTO;
import com.cinema.videotecha.model.Projection;

public final class ProjectionMapper {

    private ProjectionMapper() {
    }

    public static ProjectionResponseDTO mapToDTO(Projection projection) {
        return new ProjectionResponseDTO(
                projection.getId(),
                projection.getStartTime(),
                projection.getEndTime(),
                projection.getTicketPrice(),
                projection.getAvailableSeats(),
                MovieMapper.mapToDTO(projection.getMovie()),
                TheaterMapper.mapToDTO(projection.getTheater())
        );
    }


}
