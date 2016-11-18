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

import com.gestdepo.dao.IExerciseDAO;
import com.gestdepo.model.ExerciseVO;

@RestController
@RequestMapping("/exercise")
//@Secured("ROLE_USER")
public class ExerciseController {
	
	@Autowired
	private IExerciseDAO exerciseDAO;
	
	// TODO create a customized general ResponseEntity
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<List<ExerciseVO>> getExercises() {
		return new ResponseEntity<List<ExerciseVO>>(exerciseDAO.list(), HttpStatus.OK);
		//return exerciseDAO.list();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<ExerciseVO> getExercise(@PathVariable("id") Integer id) {
		
		ExerciseVO exercise = exerciseDAO.readById(id);
		if (exercise == null) {
			return new ResponseEntity<ExerciseVO>(new ExerciseVO(), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<ExerciseVO>(exercise, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<ExerciseVO> createExercise(@RequestBody ExerciseVO exercise) {
		exerciseDAO.create(exercise);
		
		return new ResponseEntity<ExerciseVO>(exercise, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteExercise(@PathVariable Integer id) {
		
		if (0L == exerciseDAO.deleteById(id)) {
			return new ResponseEntity<String>("No Exercise found for ID " + id, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<String>(id + "", HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<ExerciseVO> updateExercise(@RequestBody ExerciseVO exercise) {
		
		exerciseDAO.update(exercise);
		
		if (null == exercise) {
			return new ResponseEntity<ExerciseVO>(new ExerciseVO(), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<ExerciseVO>(exercise, HttpStatus.OK);
	}
}