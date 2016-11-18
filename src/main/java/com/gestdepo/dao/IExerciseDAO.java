package com.gestdepo.dao;

import java.util.List;

import com.gestdepo.model.ExerciseVO;


public interface IExerciseDAO {

	// Dummy database. Initialize with some dummy values.
	

	/**
	 * Returns list of exercises from dummy database.
	 * 
	 * @return list of exercises
	 */
	public List<ExerciseVO> list();

	/**
	 * Return exercise object for given id from dummy database. If exercise is
	 * not found for id, returns null.
	 * 
	 * @param id
	 *            exercise id
	 * @return exercise object for given id
	 */
	public ExerciseVO readById(long id);
	
	/**
	 * Create new exercise in dummy database. Updates the id and insert new
	 * exercise in list.
	 * 
	 * @param exercise
	 *            Exercise object
	 * @return exercise object with updated id
	 */
	public ExerciseVO create(ExerciseVO exercise);

	/**
	 * Delete the exercise object from dummy database. If exercise not found for
	 * given id, returns null.
	 * 
	 * @param id
	 *            the exercise id
	 * @return id of deleted exercise object
	 */
	public long deleteById(long id);

	/**
	 * Update the exercise object for given id in dummy database. If exercise
	 * not exists, returns null
	 * 
	 * @param id
	 * @param exercise
	 * @return exercise object with id
	 */
	public void update(ExerciseVO exercise);
}