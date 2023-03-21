package com.piyushtyagi.historyservice.service;

import com.piyushtyagi.historyservice.entity.ElevatorHistory;
import com.piyushtyagi.historyservice.repository.ElevatorHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;

@Service
public class ElevatorHistoryServiceImpl implements ElevatorHistoryService {

    @Autowired
    ElevatorHistoryRepository elevatorHistoryRepository;

    @Override
    public String saveElevatorHistory(Long hotelId, Long elevatorId, int floorsTravelled) {
        ElevatorHistory elevatorHistory = new ElevatorHistory();
        elevatorHistory.setHotelId(hotelId);
        elevatorHistory.setElevatorId(elevatorId);
        elevatorHistory.setFloorTravelled(floorsTravelled);
        elevatorHistory.setTimestamp(new Date(System.currentTimeMillis()));
        elevatorHistoryRepository.save(elevatorHistory);
        return "History stored successfully!";
    }

    @Override
    public int getTravelHistory(Long hotelId, Long elevatorId, Date startDate, Date endDate) {
        return elevatorHistoryRepository.findTotalFloorsTraveledByElevatorInPeriod(hotelId, elevatorId,
                startDate, endDate);
    }
}
