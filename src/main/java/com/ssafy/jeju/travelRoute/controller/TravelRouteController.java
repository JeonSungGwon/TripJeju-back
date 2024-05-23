package com.ssafy.jeju.travelRoute.controller;

import com.ssafy.jeju.travelRoute.model.dto.TravelRoute;
import com.ssafy.jeju.travelRoute.model.service.TravelRouteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/travel-route")
public class TravelRouteController {
    private final TravelRouteService travelRouteService;

    public TravelRouteController(TravelRouteService travelRouteService) {
        this.travelRouteService = travelRouteService;
    }

    @GetMapping
    public ResponseEntity<List<TravelRoute>> getAllTravelRoutes(
            @RequestParam(required = false) String search,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "12") int size) {
        List<TravelRoute> travelRoutes = travelRouteService.findAll(search, page, size);
        return ResponseEntity.ok(travelRoutes);
    }

    @GetMapping("user/count/{userId}")
    public int getAllByUser(@PathVariable long userId){
        return travelRouteService.countByUserId(userId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TravelRoute> getTravelRouteById(@PathVariable long id) {
        TravelRoute travelRoute = travelRouteService.findById(id);
        return travelRoute != null ? ResponseEntity.ok(travelRoute) : ResponseEntity.notFound().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TravelRoute>> getTravelRoutesByUserId(@PathVariable long userId) {
        List<TravelRoute> travelRoutes = travelRouteService.findByUserId(userId);
        return !travelRoutes.isEmpty() ? ResponseEntity.ok(travelRoutes) : ResponseEntity.notFound().build();
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countTravelRoutes(@RequestParam(required = false) String search) {
        long count = travelRouteService.count(search);
        return ResponseEntity.ok(count);
    }

    @PostMapping
    public ResponseEntity<TravelRoute> createTravelRoute(@RequestBody TravelRoute travelRoute) {
        if (travelRouteService.save(travelRoute)) {
            return ResponseEntity.ok(travelRoute);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTravelRoute(@PathVariable long id) {
        if (travelRouteService.delete(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
