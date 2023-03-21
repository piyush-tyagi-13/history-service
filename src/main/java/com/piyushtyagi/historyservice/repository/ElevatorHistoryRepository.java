package com.piyushtyagi.historyservice.repository;

import com.piyushtyagi.historyservice.entity.ElevatorHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;

public interface ElevatorHistoryRepository extends JpaRepository<ElevatorHistory, Long> {

    @Query("SELECT SUM(h.floorTravelled) FROM ElevatorHistory h WHERE h.hotelId = :hotelId " +
            "AND h.elevatorId = :elevatorId AND h.timestamp BETWEEN :startDate AND :endDate")
    Integer findTotalFloorsTraveledByElevatorInPeriod(@Param("hotelId") Long hotelId, @Param("elevatorId") Long elevatorId, @Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
