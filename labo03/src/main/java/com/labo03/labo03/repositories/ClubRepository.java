package com.labo03.labo03.repositories;

import com.labo03.labo03.entities.Club;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {
    List<Club> getClubsByTitlesGreaterThanEqual(@NotNull int titlesIsGreaterThan);
}
