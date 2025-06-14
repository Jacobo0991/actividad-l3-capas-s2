package com.labo03.labo03.services;

import com.labo03.labo03.entities.Club;
import com.labo03.labo03.entities.dto.CreateClub;
import lombok.NoArgsConstructor;
import com.labo03.labo03.repositories.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
  
    public List<Club> getClubsByTitlesGreaterThanEqual(int titles) {
        List<Club> clubs = clubRepository.getClubsByTitlesGreaterThanEqual(titles);
        return clubs;
    }

    public Club deleteClub(Long id) {
        Optional<Club> club = clubRepository.findById(id);
        if (club.isEmpty()) {
            return null;
        }
        clubRepository.deleteById(id);
        return club.get();

    }
}
