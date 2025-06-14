package com.labo03.labo03.controllers;

import com.labo03.labo03.entities.Club;
import com.labo03.labo03.entities.dto.CreateClub;
import com.labo03.labo03.services.ClubService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clubs")
public class ClubController {

    @Autowired
    private ClubService clubService;

    @GetMapping
    public ResponseEntity<List<Club>> getClubsByTitles(@RequestParam int titles) {
        return ResponseEntity.ok(clubService.getClubsByTitlesGreaterThanEqual(titles));
    }

    @DeleteMapping("/search/{id}")
    public ResponseEntity<Club> deleteClub(@PathVariable Long id) {
        Club club = clubService.deleteClub(id);
        if (club != null) {
            return ResponseEntity.ok(club);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Void> createClub(@RequestBody @Valid CreateClub info) {
        try{
            clubService.createClub(info);
            return ResponseEntity.ok().build();
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
