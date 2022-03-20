package com.example.TeamPlayer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TeamPlayer.model.Team;

//DATA REPOSITORY FOR CRUD OPERATION
@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

}
