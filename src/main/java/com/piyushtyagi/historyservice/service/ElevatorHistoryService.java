package com.piyushtyagi.historyservice.service;

import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public interface ElevatorHistoryService {

    public String saveElevatorHistory(Long hotelId, Long elevatorId, int floorsTravelled);

    public Integer getTravelHistory(Long hotelId, Long elevatorId, Date startDate, Date endDate);



}
