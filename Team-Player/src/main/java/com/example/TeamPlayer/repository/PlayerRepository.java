package com.example.TeamPlayer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TeamPlayer.model.Player;

//DATA REPOSITORY FOR CRUD OPERATION
@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

}
