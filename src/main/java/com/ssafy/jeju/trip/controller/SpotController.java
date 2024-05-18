package com.ssafy.jeju.trip.controller;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ssafy.jeju.trip.model.dto.Spot;
import com.ssafy.jeju.trip.model.service.SpotService;

@RestController
@RequestMapping("/spots")
public class SpotController {
	private final SpotService spotService;

	public SpotController(SpotService spotService) {
		this.spotService = spotService;
	}


	@GetMapping("/title/{title}/{type}")
	public ResponseEntity<List<Spot>> getSpotBySpotTitle(@PathVariable String title, @PathVariable String type) {
		List<Spot> spots = spotService.getSpotBySpotTitle(title, type);
		return ResponseEntity.ok(spots);
	}
	@GetMapping("/tag/{tag}/{type}")
	public ResponseEntity<List<Spot>> getSpotBySpotTag(@PathVariable String tag, @PathVariable String type) {
		List<Spot> spots = spotService.getSpotBySpotTag(tag, type);
		return ResponseEntity.ok(spots);
	}

	@GetMapping("/search")
	public ResponseEntity<Map<String, Object>> getSpots(
			@RequestParam(required = false) String title,
			@RequestParam(required = false) String tag,
			@RequestParam(required = false) String type,
			@RequestParam(required = false) String reg1,
			@RequestParam(required = false) String reg2,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {

		Map<String, Object> result = spotService.getSpots(title, tag, type, reg1, reg2, page, size);
		return ResponseEntity.ok(result);
	}
	@GetMapping("/month/{type}/{month}")
	public ResponseEntity<List<Spot>> getSpotBySpotMonth(@PathVariable String month, @PathVariable String type) {
		List<Spot> spots = spotService.getSpotBySpotMonth(month, type);
		return ResponseEntity.ok(spots);
	}

	@GetMapping
	public ResponseEntity<List<Spot>> getAllSpots(@RequestParam(defaultValue = "0") int page,
												  @RequestParam(defaultValue = "1000") int size) {
		List<Spot> spots = spotService.getAllSpots(page, size);
		return ResponseEntity.ok(spots);
	}
	@GetMapping("/count")
	public int getAllCount() {
		return spotService.getAllCount();
	}


}

