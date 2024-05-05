package com.ssafy.jeju.trip.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@PostMapping
	public ResponseEntity<String> createSpot(@RequestBody Spot spot) {
		spotService.createSpot(spot);
		return ResponseEntity.ok("Spot created successfully");
	}

	@GetMapping("/{spotId}")
	public ResponseEntity<Spot> getSpotBySpotId(@PathVariable int spotId) {
		Spot spot = spotService.getSpotBySpotId(spotId);
		return ResponseEntity.ok(spot);
	}

	@GetMapping
	public ResponseEntity<List<Spot>> getAllSpots() {
		List<Spot> spots = spotService.getAllSpots();
		return ResponseEntity.ok(spots);
	}

	@PutMapping("/{spotId}")
	public ResponseEntity<String> updateSpot(@PathVariable int spotId) {
		spotService.updateSpot(spotId);
		return ResponseEntity.ok("Spot updated successfully");
	}

	@DeleteMapping("/{spotId}")
	public ResponseEntity<String> deleteSpot(@PathVariable int spotId) {
		spotService.deleteSpot(spotId);
		return ResponseEntity.ok("Spot deleted successfully");
	}
}
