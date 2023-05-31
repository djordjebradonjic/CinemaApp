package com.valcon.videotechaivana.repository;

import com.valcon.videotechaivana.model.Projection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProjectionRepository extends JpaRepository<Projection, Long> {
    @Query("SELECT p FROM Projection p WHERE p.availableSeats > 0 AND p.deleted = false")
    List<Projection> findAllAvailable();

    Optional<Projection> findByIdAndDeletedFalse(Long id);

    List<Projection> findByDeletedFalseAndStartTimeAfter(LocalDateTime now);

    @Query("""
            SELECT COUNT(p.id) 
            FROM Projection p
            WHERE p.deleted=false
                AND p.theater.id = :id
                AND (( p.startTime >= :startTime AND p.startTime <= :endTime)
                       OR (p.endTime >= :startTime AND p.endTime <= :endTime))
            """)
    int findOverlappingProjections(@Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime, @Param("id") Long theaterId);

}
