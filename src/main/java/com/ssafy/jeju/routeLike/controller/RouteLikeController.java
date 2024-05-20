package com.ssafy.jeju.routeLike.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ssafy.jeju.routeLike.model.dto.RouteLike;
import com.ssafy.jeju.routeLike.model.service.RouteLikeService;

@RestController
@RequestMapping("/routeLikes")
public class RouteLikeController {

    @Autowired
    private RouteLikeService routeLikeService;

    @PostMapping
    public ResponseEntity<Void> insertRouteLike(@RequestBody RouteLike routeLike) {
        routeLikeService.insertRouteLike(routeLike);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRouteLike(@PathVariable Long id) {
        routeLikeService.deleteRouteLike(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/count")
    public ResponseEntity<Integer> getCountByRouteId(@RequestParam Long routeId) {
        int count = routeLikeService.getCountByRouteId(routeId);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<RouteLike>> getLikesByUserId(@PathVariable Long userId) {
        List<RouteLike> likes = routeLikeService.getLikesByUserId(userId);
        return new ResponseEntity<>(likes, HttpStatus.OK);
    }
}
