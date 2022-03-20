package com.example.TeamPlayer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.TeamPlayer.model.Player;
import com.example.TeamPlayer.repository.TeamRepository;
import com.example.TeamPlayer.service.PlayerService;

@RestController

//URL FOR APIs
@RequestMapping("/api")

public class PlayerController {

	//INSTANTIATING CLASS OBJECT
	
		@Autowired
		PlayerService playerService;
		@Autowired
		TeamRepository teamRepository;
		
		//CONSTRUCTOR WITH FIELDS
		public PlayerController(PlayerService playerService, TeamRepository teamRepository) {
			super();
			this.playerService = playerService;
			this.teamRepository = teamRepository;
		}
		
		//CREATE PLAYER ENDPOINT
		@RequestMapping(value="/team/{teamid}/player", method=RequestMethod.POST)
		public Player createPlayer(@PathVariable(value = "teamid") Long teamid, @RequestBody Player player) {
		    return playerService.createPlayer(teamid,player);
		}
		
		//READ PLAYER BY ID ENDPOINT
		@RequestMapping(value="/team/{teamid}/player/{playerid}", method=RequestMethod.GET)
		public Player getPlayerById(@PathVariable(value = "teamid") Long teamid, @PathVariable(value = "playerid") Long playerid) {
			
			return playerService.getPlayerById(playerid);
		}

		//UPDATE PLAYER ENDPOINT
		@RequestMapping(value="/team/{teamid}/player/{playerid}", method=RequestMethod.PUT)
		public Player readPlayer(@PathVariable(value = "teamid") Long teamid, @PathVariable(value = "playerid") Long playerid, @RequestBody Player playerDetails) {
		    return playerService.updatePlayer(teamid, playerid, playerDetails);
		}

		//DELETE PLAYER ENDPOINT
		@RequestMapping(value="/team/{teamId}/player/{playerId}", method=RequestMethod.DELETE)
		public void deletePlayer(@PathVariable(value = "playerId") Long playerid, @PathVariable(value = "teamId") Long teamid) {
			playerService.deletePlayer(playerid);
		}
		
		//READ PLAYER BY TEAM ID ENDPOINT
		@RequestMapping(value="/team/{teamid}/player", method=RequestMethod.GET)
		public List<Player> getPlayerByTeamId(@PathVariable(value = "teamid") Long id) {
			return playerService.getPlayerByTeamId(id);
		}
		
}
