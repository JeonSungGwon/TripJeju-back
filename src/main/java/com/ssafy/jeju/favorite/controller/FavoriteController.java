package com.ssafy.jeju.favorite.controller;

import com.ssafy.jeju.favorite.model.dto.Favorite;
import com.ssafy.jeju.favorite.model.service.FavoriteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favorite")
public class FavoriteController {
    private final FavoriteService favoriteService;

    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @GetMapping
    public ResponseEntity<List<Favorite>> getAllFavorites() {
        return ResponseEntity.ok(favoriteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Favorite> getFavoriteById(@PathVariable long id) {
        Favorite favorite = favoriteService.findById(id);
        return favorite != null ? ResponseEntity.ok(favorite) : ResponseEntity.notFound().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Favorite>> getFavoritesByUserId(@PathVariable long userId) {
        List<Favorite> favorites = favoriteService.findByUserId(userId);
        return !favorites.isEmpty() ? ResponseEntity.ok(favorites) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Favorite> createFavorite(@RequestBody Favorite favorite) {
        if (favoriteService.save(favorite)) {
            return ResponseEntity.ok(favorite);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFavorite(@PathVariable long id) {
        if (favoriteService.delete(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/user/{userId}/spot/{placeId}")
    public ResponseEntity<Boolean> checkFavorite(@PathVariable long userId, @PathVariable long placeId) {
        boolean isFavorite = favoriteService.isFavorite(userId, placeId);
        return ResponseEntity.ok(isFavorite);
    }

}
