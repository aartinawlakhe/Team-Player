package com.example.TeamPlayer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.TeamPlayer.model.Player;
import com.example.TeamPlayer.model.Team;
import com.example.TeamPlayer.repository.PlayerRepository;
import com.example.TeamPlayer.repository.TeamRepository;

@Service
public class PlayerService {
	
	//INSTANTIATING CLASS OBJECT
	
	@Autowired
	PlayerRepository playerRepository;
	@Autowired
	TeamRepository teamRepository;
		
	//CONSTRUCTOR WITH FIELDS
	public PlayerService(PlayerRepository playerRepository, TeamRepository teamRepository) {
		super();
		this.playerRepository = playerRepository;
		this.teamRepository = teamRepository;
	}
	
	// CREATE 
	public Player createPlayer(Long id, Player player) {
		Team team = teamRepository.findById(id).get();
		player.setTid(team.getId());
	    return playerRepository.save(player);
	}

	// READ
	public List<Player> getPlayerByTeamId(Long id) {
		Team team = teamRepository.findById(id).get();
		return team.getPlayer();
	}
			
	// UPDATE
	public Player updatePlayer(Long teamid, Long playerid, @RequestBody Player playerDetails) {
		Player player = playerRepository.getById(playerid);
		player.setName(playerDetails.getName());
		player.setAge(playerDetails.getAge());
				        
		return playerRepository.save(player);                                
	}

	// DELETE
	public void deletePlayer(Long playerId) {
		 playerRepository.deleteById(playerId);
	}
		
	//READ PLAYER BY TEAM ID
	public Player getPlayerById(Long teamid) {
		return playerRepository.findById(teamid).get();
	}
		
}
