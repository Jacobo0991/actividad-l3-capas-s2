package com.labo03.labo03.services;

import com.labo03.labo03.entities.Club;
import com.labo03.labo03.entities.dto.CreateClub;
import com.labo03.labo03.repositories.ClubRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class ClubService {

    @Autowired
    private ClubRepository clubRepository;

    public void createClub(CreateClub clubInfo) {
    Club club = new Club();
    club.setName(clubInfo.getName());
    club.setCountry(clubInfo.getCountry());
    club.setCoach(clubInfo.getCoach());
    club.setTitles(clubInfo.getTitles());
    clubRepository.save(club);
    }
}
