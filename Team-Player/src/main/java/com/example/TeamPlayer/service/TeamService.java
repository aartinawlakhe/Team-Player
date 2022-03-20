package com.example.TeamPlayer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.TeamPlayer.model.Player;
import com.example.TeamPlayer.model.Team;
import com.example.TeamPlayer.repository.PlayerRepository;
import com.example.TeamPlayer.repository.TeamRepository;

@Service
public class TeamService {
	
	//INSTANTIATING CLASS OBJECT
	
	@Autowired
	TeamRepository teamRepository;
	@Autowired
	PlayerRepository playerRepository;
		
	//CONSTRUCTOR WITH FIELDS
	public TeamService(TeamRepository teamRepository, PlayerRepository playerRepository) {
		super();
		this.teamRepository = teamRepository;
		this.playerRepository = playerRepository;
	}
		
	// CREATE 
	public Team createTeam(Team team) {
	    return teamRepository.save(team);
	}

	// READ
	public Team getTeamById(Long id) {
		return teamRepository.findById(id).get();
	}
		
	// UPDATE
	public Team updateTeam(Long teamId, @RequestBody Team teamDetails) {
		Team team = teamRepository.findById(teamId).get();
		team.setName(teamDetails.getName());
	    team.setLocation(teamDetails.getLocation());
			        
		return teamRepository.save(team);                                
	}

	// DELETE
	public void deleteTeam(Long teamId) {
		//Team teamToBeDeleted = teamRepository.findById(teamId).get();
		//teamToBeDeleted.getPlayer();
	    teamRepository.deleteById(teamId);
	}
		
	//READ TEAM BY PLAYER ID
	public Team findTeamByPlayerId(Long playerid) {
		Player player = playerRepository.findById(playerid).get();
		return teamRepository.findById(player.getTid()).get();
	}
}
