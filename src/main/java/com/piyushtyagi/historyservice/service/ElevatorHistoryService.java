package com.piyushtyagi.historyservice.service;

import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;

@Service
public interface ElevatorHistoryService {

    public String saveElevatorHistory(Long hotelId, Long elevatorId, int floorsTravelled);

    public int getTravelHistory(Long hotelId, Long elevatorId, Date startDate, Date endDate);



}
