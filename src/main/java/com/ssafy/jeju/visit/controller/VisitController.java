package com.ssafy.jeju.visit.controller;

import com.ssafy.jeju.trip.model.dto.Spot;
import com.ssafy.jeju.trip.model.service.SpotService;
import com.ssafy.jeju.trip.model.service.SpotServiceImpl;
import com.ssafy.jeju.visit.model.dto.Visit;
import com.ssafy.jeju.visit.model.service.VisitService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/visit")
public class VisitController {
    private final VisitService visitService;
    private final SpotService spotService;

    public VisitController(VisitService visitService, SpotService spotService) {
        this.visitService = visitService;
        this.spotService = spotService;
    }

    @GetMapping
    public ResponseEntity<List<Visit>> getAllVisited() {
        return ResponseEntity.ok(visitService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Visit> getVisitById(@PathVariable long id) {
        Visit visit = visitService.findById(id);
        return visit != null ? ResponseEntity.ok(visit) : ResponseEntity.notFound().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Spot>> getVisitByUserId(@PathVariable long userId,
                                                       @RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "1000") int size) {
        List<Visit> visits = visitService.findByUserId(userId, page, size);
        if (visits.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // Extract placeIds from visits
        List<Long> placeIds = visits.stream()
                .map(Visit::getPlaceId)
                .collect(Collectors.toList());

        // Fetch spots for each placeId
        List<Spot> spots = spotService.findByIds(placeIds);

        // Create a map of placeId to visitDate
        Map<Long, Date> visitDateMap = visits.stream()
                .collect(Collectors.toMap(Visit::getPlaceId, Visit::getVisitDate));

        // Set visitDate in each spot
        spots.forEach(spot -> {
            Long placeId = spot.getId();
            Date visitDate = visitDateMap.get(placeId);
            if (visitDate != null) {
                spot.setVisitDate(visitDate);
            }
        });

        return ResponseEntity.ok(spots);

    }

    @PostMapping
    public ResponseEntity<Visit> createVisit(@RequestBody Visit visit) {
        if (visitService.save(visit)) {
            return ResponseEntity.ok(visit);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVisit(@PathVariable long id) {
        if (visitService.delete(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/user/{userId}/spot/{placeId}")
    public ResponseEntity<Boolean> checkVisit(@PathVariable long userId, @PathVariable long placeId) {
        boolean isVisit = visitService.isVisit(userId, placeId);
        return ResponseEntity.ok(isVisit);
    }

    @GetMapping("/user/count/{userId}")
    public int countVisit(@PathVariable long userId){
        return visitService.countVisitByUser(userId);
    }
}
