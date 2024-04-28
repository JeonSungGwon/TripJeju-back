package com.ssafy.jeju.favorite.controller;

import com.ssafy.jeju.favorite.model.dto.Favorite;
import com.ssafy.jeju.favorite.model.service.FavoriteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favorites")
public class FavoriteController {
    private final FavoriteService favoriteService;

    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @PostMapping
    public ResponseEntity<String> createFavorite(@RequestBody Favorite favorite) {
        favoriteService.createFavorite(favorite);
        return ResponseEntity.ok("Favorite created successfully");
    }

    @GetMapping("/{favoriteId}")
    public ResponseEntity<Favorite> getFavoriteById(@PathVariable int favoriteId) {
        Favorite favorite = favoriteService.getFavoriteById(favoriteId);
        return ResponseEntity.ok(favorite);
    }

    @GetMapping
    public ResponseEntity<List<Favorite>> getAllFavorites() {
        List<Favorite> favorites = favoriteService.getAllFavorites();
        return ResponseEntity.ok(favorites);
    }

    @PutMapping
    public ResponseEntity<String> updateFavorite(@RequestBody Favorite favorite) {
        favoriteService.updateFavorite(favorite);
        return ResponseEntity.ok("Favorite updated successfully");
    }

    @DeleteMapping("/{favoriteId}")
    public ResponseEntity<String> deleteFavorite(@PathVariable int favoriteId) {
        favoriteService.deleteFavorite(favoriteId);
        return ResponseEntity.ok("Favorite deleted successfully");
    }
}

