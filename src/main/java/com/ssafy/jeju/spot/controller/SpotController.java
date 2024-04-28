package com.ssafy.jeju.spot.controller;

import com.ssafy.jeju.spot.model.dto.Spot;
import com.ssafy.jeju.spot.model.service.SpotService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

	@PutMapping
	public ResponseEntity<String> updateSpot(@RequestBody Spot spot) {
		spotService.updateSpot(spot);
		return ResponseEntity.ok("Spot updated successfully");
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteSpot(@PathVariable int spotId) {
		spotService.deleteSpot(spotId);
		return ResponseEntity.ok("Spot deleted successfully");
	}
}
