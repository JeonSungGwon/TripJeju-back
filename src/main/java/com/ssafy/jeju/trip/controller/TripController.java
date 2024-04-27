package com.ssafy.jeju.trip.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.jeju.trip.model.TripDto;
import com.ssafy.jeju.trip.model.service.TripService;

@RestController
@RequestMapping("/trip")
public class TripController {
	
	private final TripService tripService;
	
	public TripController(TripService tripService) {
		this.tripService = tripService;
	}
	
	@GetMapping("list/spot")
	public ResponseEntity<List<TripDto>> getTripList() {
		List<TripDto> trips = tripService.selectTripSpot();
		return new ResponseEntity<>(trips, HttpStatus.OK);
	}
}

