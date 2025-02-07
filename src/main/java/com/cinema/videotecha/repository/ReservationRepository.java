package com.cinema.videotecha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cinema.videotecha.model.Reservation;

import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Optional<Reservation> findByIdAndCanceledFalse(Long id);

    @Query("""
            SELECT coalesce(sum(r.numberOfTickets), 0)
            FROM Reservation r
            WHERE r.user.id = :userId AND r.projection.id = :projectionId AND r.canceled = false
            """)
    int findReservedSeatsByUserAndProjection(@Param("userId") Long userId, @Param("projectionId") Long projectionId);


}
