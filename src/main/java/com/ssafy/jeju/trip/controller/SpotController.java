package com.ssafy.jeju.trip.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.jeju.trip.model.dto.Spot;
import com.ssafy.jeju.trip.model.service.SpotService;

@RestController
@RequestMapping("/spots")
public class SpotController {
	private final SpotService spotService;

	public SpotController(SpotService spotService) {
		this.spotService = spotService;
	}


	@GetMapping("/title/{title}")
	public ResponseEntity<List<Spot>> getSpotBySpotTitle(@PathVariable String title) {
		List<Spot> spots = spotService.getSpotBySpotTitle(title);
		return ResponseEntity.ok(spots);
	}
	@GetMapping("/tag/{tag}")
	public ResponseEntity<List<Spot>> getSpotBySpotTag(@PathVariable String tag) {
		List<Spot> spots = spotService.getSpotBySpotTag(tag);
		return ResponseEntity.ok(spots);
	}

	@GetMapping
	public ResponseEntity<List<Spot>> getAllSpots() {
		List<Spot> spots = spotService.getAllSpots();
		return ResponseEntity.ok(spots);
	}

}
