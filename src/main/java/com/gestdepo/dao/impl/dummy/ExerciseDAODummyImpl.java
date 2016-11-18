/*package com.gestdepo.dao.impl.dummy;

import java.util.List;

import org.springframework.stereotype.Component;

import com.gestdepo.dao.IExerciseDAO;
import com.gestdepo.model.ExerciseVO;
import com.gestdepo.utils.StorageService;

@Component
public class ExerciseDAODummyImpl implements IExerciseDAO{

	// Dummy database. Initialize with some dummy values.
	
	private StorageService storageService = new StorageService();;

	public List<ExerciseVO> list() {
		return ExerciseList.exercises;
	}

	public ExerciseVO readById(long id) {

		for (ExerciseVO c : ExerciseList.exercises) {
			if (c.getExerciseId() == id) {
				return c;
			}
		}
		return null;
	}

	public ExerciseVO create(ExerciseVO exercise) {
		exercise.setExerciseId(ExerciseList.exercises.size()+1);
		
		exercise.setDesignUrl(StorageService.saveDesignImg(exercise.getDesign(), exercise.getName().trim() + ".jpg"));
		
		// TODO store the video
		//exercise.setVideoUrl(storageService.store(exercise.getVideo()));
		
		ExerciseList.exercises.add(exercise);
		return exercise;
	}

	public long deleteById(long id) {

		for (ExerciseVO e : ExerciseList.exercises) {
			if (e.getExerciseId() == id) {
				ExerciseList.exercises.remove(e);
				return id;
			}
		}

		return 0L;
	}
	
	public void update(ExerciseVO exercise) {

		exercise.setDesignUrl(StorageService.saveDesignImg(exercise.getDesign(), exercise.getName().replaceAll(" ", "_") + ".jpg"));
		
		// TODO store the video
		//exercise.setVideoUrl(storageService.store(exercise.getVideo()));
		
		for (ExerciseVO e : ExerciseList.exercises) {
			if (e.getExerciseId() == exercise.getExerciseId()) {
				exercise.setExerciseId(e.getExerciseId());
				ExerciseList.exercises.remove(e);
				ExerciseList.exercises.add(exercise);
			}
		}
	}

}
*/