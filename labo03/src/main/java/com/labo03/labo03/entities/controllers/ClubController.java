package com.labo03.labo03.entities.controllers;

import com.labo03.labo03.entities.dto.CreateClub;
import com.labo03.labo03.services.ClubService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/api/clubs")
public class ClubController {

    @Autowired
    private ClubService clubService;

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
