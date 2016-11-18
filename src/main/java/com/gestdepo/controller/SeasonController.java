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

import com.gestdepo.dao.ISeasonDAO;
import com.gestdepo.model.SeasonVO;

@RestController
@RequestMapping("/season")
//@Secured("ROLE_USER")
public class SeasonController {
	
	@Autowired
	private ISeasonDAO seasonDAO;
	
	// TODO create a customized general ResponseEntity
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<List<SeasonVO>> getSeasons() {
		return new ResponseEntity<List<SeasonVO>>(seasonDAO.list(), HttpStatus.OK);
		//return seasonDAO.list();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<SeasonVO> getSeason(@PathVariable("id") Integer id) {
		
		SeasonVO season = seasonDAO.get(id);
		if (season == null) {
			return new ResponseEntity<SeasonVO>(new SeasonVO(), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<SeasonVO>(season, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/lastSeason", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<SeasonVO> getCurrentSeason() {
		
		SeasonVO season = seasonDAO.getLastSeason();
		if (season == null) {
			return new ResponseEntity<SeasonVO>(new SeasonVO(), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<SeasonVO>(season, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<SeasonVO> createSeason(@RequestBody SeasonVO season) {
		
		seasonDAO.create(season);
		
		return new ResponseEntity<SeasonVO>(season, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteSeason(@PathVariable Integer id) {
		
		if (0L == seasonDAO.delete(id)) {
			return new ResponseEntity<String>("No Season found for ID " + id, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<String>(id + "", HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<SeasonVO> updateSeason(@RequestBody SeasonVO season) {
		
		season = seasonDAO.update(season);
		
		if (null == season) {
			return new ResponseEntity<SeasonVO>(new SeasonVO(), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<SeasonVO>(season, HttpStatus.OK);
	}
}