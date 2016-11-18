package com.gestdepo.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.gestdepo.dao.FileDAO;
import com.gestdepo.dao.IExerciseDAO;
import com.gestdepo.model.ExerciseVO;
import com.mongodb.WriteResult;

@Component
public class ExerciseDAOImpl implements IExerciseDAO {
	
	@Autowired
	private FileDAO fileDAO;
	
	private MongoOperations mongoOps;
	private static final String EXERCISES_COLLECTION = "Exercises";
	
	public ExerciseDAOImpl(MongoOperations mongoOps) {
		this.mongoOps=mongoOps;
	}
	
	/**
	 * Returns list of exercises from dummy database.
	 * 
	 * @return list of exercises
	 */
	// TODO add filters to the search
	public List<ExerciseVO> list() {
		return this.mongoOps.findAll(ExerciseVO.class, EXERCISES_COLLECTION);
	}

	/**
	 * Return exercise object for given id from dummy database. If exercise is
	 * not found for id, returns null.
	 * 
	 * @param id
	 *            exercise id
	 * @return exercise object for given id
	 */
	public ExerciseVO readById(long id) {
		Query query = new Query(Criteria.where("_id").is(id));
		return this.mongoOps.findOne(query, ExerciseVO.class, EXERCISES_COLLECTION);
	}

	/**
	 * Create new exercise in dummy database. Updates the id and insert new
	 * exercise in list.
	 * 
	 * @param exercise
	 *            Exercise object
	 * @return exercise object with updated id
	 */
	public ExerciseVO create(ExerciseVO e) {
		// TODO uncomment when it works
		/*
		String name = e.getName().replace(" ", "_");
		Class<?> parentClass = ExerciseVO.class;
		
		// save image
		String design = e.getDesign();
		if (null != design && !design.isEmpty()) {
			e.setDesignId(fileDAO.saveFile(design, name, "image/jpg", parentClass, 0, 0));
		}
		
		// save video
		MultipartFile video = e.getVideo();
		if (null != video) {
			e.setVideoId(fileDAO.saveFile(video, name, "video/mp4", parentClass, 0, 0));
		}
		*/
		this.mongoOps.insert(e, EXERCISES_COLLECTION);
		return e;
	}

	/**
	 * Delete the exercise object from dummy database. If exercise not found for
	 * given id, returns null.
	 * 
	 * @param id
	 *            the exercise id
	 * @return id of deleted exercise object
	 */
	public long deleteById(long id) {
		// TODO uncomment when it works
		/*
		boolean filesDeleted = fileDAO.deleteFileByParentId(id);
		*/
		WriteResult result = null;
		//if (filesDeleted) {
			Query query = new Query(Criteria.where("_id").is(id));
			result = this.mongoOps.remove(query, ExerciseVO.class, EXERCISES_COLLECTION);
		//}
		return result.getN();
	}
	
	/**
	 * Update the exercise object for given id in dummy database. If exercise
	 * not exists, returns null
	 * 
	 * @param id
	 * @param exercise
	 */
	public void update(ExerciseVO e) {
		
		// TODO uncomment when it works
		/*
		// save image
		e.setDesignId(fileDAO.saveFile(e.getDesign(), e.getName().replace(" ", "_"), "image/jpg", ExerciseVO.class, e.getExerciseId(), 0));
		
		// save video
		e.setVideoId(fileDAO.saveFile(e.getVideo(), e.getName().replace(" ", "_"), "video/mp4", ExerciseVO.class, e.getExerciseId(), 0));
		*/
		this.mongoOps.save(e, EXERCISES_COLLECTION);
	}
}
