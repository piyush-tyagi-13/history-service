package com.piyushtyagi.historyservice.controller;

import com.piyushtyagi.historyservice.service.ElevatorHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Objects;

@RestController
@RequestMapping("/history-service")
public class ElevatorHistoryController {

    @Autowired
    ElevatorHistoryService elevatorHistoryService;

    @GetMapping("/hotel/{hotelId}/elevator/{elevatorId}/travelled/{floorsTravelled}")
    public String saveTraversalData(
            @PathVariable("floorsTravelled") Integer floorsTravelled,
            @PathVariable("elevatorId") Long elevatorId,
            @PathVariable("hotelId") Long hotelId) {
        return elevatorHistoryService.saveElevatorHistory(hotelId, elevatorId, floorsTravelled);
    }

    @GetMapping("/hotel/{hotelId}/elevator/{elevatorId}/{startDate}/{endDate}")
    public int getTravelHistory(@PathVariable("hotelId") Long hotelId,
                                @PathVariable("elevatorId") Long elevatorId,
                                @PathVariable("startDate") String startDate,
                                @PathVariable("endDate") String endDate) {
        return Objects.isNull(elevatorHistoryService.getTravelHistory(hotelId, elevatorId, Date.valueOf(startDate), Date.valueOf(endDate))) ?
                0 : elevatorHistoryService.getTravelHistory(hotelId, elevatorId, Date.valueOf(startDate), Date.valueOf(endDate));
    }
}
