package com.labo03.labo03.controllers;

import com.labo03.labo03.entities.Club;
import com.labo03.labo03.services.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/clubs")
public class ClubController {

    @Autowired
    private ClubService clubService;

    @GetMapping
    public ResponseEntity<List<Club>> getClubsByTitles(@RequestParam int titles) {
        return ResponseEntity.ok(clubService.getClubsByTitlesGreaterThanEqual(titles));
    }

}
