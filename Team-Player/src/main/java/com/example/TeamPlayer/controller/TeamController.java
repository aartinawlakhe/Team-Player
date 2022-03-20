package com.example.TeamPlayer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.TeamPlayer.model.Team;
import com.example.TeamPlayer.repository.PlayerRepository;
import com.example.TeamPlayer.service.TeamService;

@RestController

//URL FOR APIs
@RequestMapping("/api")

public class TeamController {

	//INSTANTIATING CLASS OBJECT 
	
	@Autowired
	TeamService teamService;
		
	@Autowired
	PlayerRepository playerRepository;

	//CONSTRUCTOR WITH FIELDS
	public TeamController(TeamService teamService, PlayerRepository playerRepository) {
		super();
		this.teamService = teamService;
		this.playerRepository = playerRepository;
	}
		
	//CREATE TEAM ENDPOINT
	@RequestMapping(value="/team", method=RequestMethod.POST)
	public Team createTeam(@RequestBody Team team) {
	    return teamService.createTeam(team);
	}

	//READ TEAM BY ID ENDPOINT
	@RequestMapping(value="/team/{teamid}", method=RequestMethod.GET)
	public Team getTeamById(@PathVariable(value = "teamid") Long id) {
		return teamService.getTeamById(id);
	}
		
	//UPDATE TEAM ENDPOINT
	@RequestMapping(value="/team/{teamId}", method=RequestMethod.PUT)
	public Team readTeam(@PathVariable(value = "teamId") Long id, @RequestBody Team teamDetails) {
	    return teamService.updateTeam(id, teamDetails);
	}

	//DELETE TEAM ENDPOINT
	@RequestMapping(value="/team/{teamId}", method=RequestMethod.DELETE)
	public void deleteTeam(@PathVariable(value = "teamId") Long id) {
	    teamService.deleteTeam(id);
	}
		
	//READ TEAM BY PLAYER ID ENDPOINT
	@RequestMapping(value="/{playerid}", method=RequestMethod.GET)
	public Team getTeamByPlayerId(@PathVariable(value = "playerid") Long playerid) {
		return teamService.findTeamByPlayerId(playerid);
	}
		
}
