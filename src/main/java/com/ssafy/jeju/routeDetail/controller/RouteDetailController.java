package com.ssafy.jeju.routeDetail.controller;

import com.ssafy.jeju.routeDetail.model.dto.RouteDetail;
import com.ssafy.jeju.routeDetail.model.service.RouteDetailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/route-detail")
public class RouteDetailController {
    private final RouteDetailService routeDetailService;

    public RouteDetailController(RouteDetailService routeDetailService) {
        this.routeDetailService = routeDetailService;
    }

    @GetMapping
    public ResponseEntity<List<RouteDetail>> getAllRouteDetails() {
        return ResponseEntity.ok(routeDetailService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RouteDetail> getRouteDetailById(@PathVariable long id) {
        RouteDetail routeDetail = routeDetailService.findById(id);
        return routeDetail != null ? ResponseEntity.ok(routeDetail) : ResponseEntity.notFound().build();
    }

    @GetMapping("/route/{routeId}")
    public ResponseEntity<List<RouteDetail>> getRouteDetailsByRouteId(@PathVariable long routeId) {
        List<RouteDetail> routeDetails = routeDetailService.findByRouteId(routeId);
        return !routeDetails.isEmpty() ? ResponseEntity.ok(routeDetails) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<RouteDetail> createRouteDetail(@RequestBody RouteDetail routeDetail) {
        if (routeDetailService.save(routeDetail)) {
            return ResponseEntity.ok(routeDetail);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<RouteDetail> updateRouteDetail(@PathVariable long id, @RequestBody RouteDetail routeDetail) {
        routeDetail.setId(id);
        if (routeDetailService.update(routeDetail)) {
            return ResponseEntity.ok(routeDetail);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRouteDetail(@PathVariable long id) {
        if (routeDetailService.delete(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
