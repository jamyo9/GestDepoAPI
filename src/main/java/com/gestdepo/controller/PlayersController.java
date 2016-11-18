package com.gestdepo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gestdepo.dao.IPlayerDAO;
import com.gestdepo.model.PlayerVO;

@RestController
@RequestMapping("/player")
//@Secured("ROLE_USER")
public class PlayersController {
	
	@Autowired
	private IPlayerDAO playerDAO;
	
	// TODO create a customized general ResponseEntity
	@RequestMapping(value = "/list/{seasonId}/{teamId}", method = RequestMethod.GET)
	public ResponseEntity<List<PlayerVO>> getPlayers(@PathVariable("seasonId") Long seasonId, @PathVariable("teamId") Long teamId) {
		return new ResponseEntity<List<PlayerVO>>(playerDAO.list(seasonId, teamId), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<PlayerVO> getPlayer(@PathVariable("id") Integer id) {
		
		PlayerVO player = playerDAO.get(id);
		if (player == null) {
			return new ResponseEntity<PlayerVO>(new PlayerVO(), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<PlayerVO>(player, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<PlayerVO> createPlayer(@RequestBody PlayerVO player) {
		
		playerDAO.create(player);
		
		return new ResponseEntity<PlayerVO>(player, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deletePlayer(@PathVariable Integer id) {
		
		if (0L == playerDAO.delete(id)) {
			return new ResponseEntity<String>("No Player found for ID " + id, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<String>(id + "", HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<PlayerVO> updatePlayer(@RequestBody PlayerVO player) {
		
		player = playerDAO.update(player);
		
		if (null == player) {
			return new ResponseEntity<PlayerVO>(new PlayerVO(), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<PlayerVO>(player, HttpStatus.OK);
	}
}