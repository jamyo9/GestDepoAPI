package com.gestdepo.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.web.multipart.MultipartFile;

public class ExerciseVO  {
	
	@Id
    private long exerciseId;
	private String name;
	private String description;
	
	private int numberOfPlayers;
	
	private String objective;
	private List<MaterialVO> materials;
	
	private long designId;
	private String design;
	private String designUrl;
	private long videoId;
	private MultipartFile video;
	private String videoUrl;
	
	private long coachId;
	
	private long subCategoryId;
	
	

	// CONSTRUCTORS
	public ExerciseVO() {
		this.setExerciseId(0l);
		this.setName("");
		this.setDescription("");
		this.setNumberOfPlayers(0);
		this.setObjective("");
		this.setMaterials(new ArrayList<MaterialVO>());
		this.setDescription("");
		this.setDesignId(0l);
		this.setDesign("");
		this.setDesignUrl("");
		this.setVideoId(0l);
		this.setVideo(null);
		this.setVideoUrl("");
		this.setCoachId(0l);
		this.setSubCategoryId(0l);
	}
	
	public ExerciseVO(long exerciseId, String name, String description,
			int numberOfPlayers, String objective,
			List<MaterialVO> materials, long designId, String design, String designUrl,
			long videoId, MultipartFile video, String videoUrl, long coachId, long subCategoryId) {
		this.setExerciseId(exerciseId);
		this.setName(name);
		this.setDescription(description);
		this.setNumberOfPlayers(numberOfPlayers);
		
		this.setObjective(objective);
		this.setMaterials(materials);
		
		this.setDesignId(designId);
		this.setDesign(design);
		this.setDesignUrl(designUrl);
		this.setVideoId(videoId);
		this.setVideo(video);
		this.setVideoUrl(videoUrl);
		
		this.setCoachId(coachId);
		this.setSubCategoryId(subCategoryId);
	}
	
	public ExerciseVO(ExerciseVO exercise) {
		this.setExerciseId(exercise.getExerciseId());
		this.setName(exercise.getName());
		this.setDescription(exercise.getDescription());
		this.setNumberOfPlayers(exercise.getNumberOfPlayers());
		this.setObjective(exercise.getObjective());
		this.setMaterials(exercise.getMaterials());
		this.setDesignId(exercise.getDesignId());
		this.setDesign(exercise.getDesign());
		this.setDesignUrl(exercise.getDesignUrl());
		this.setVideoId(exercise.getVideoId());
		this.setVideo(exercise.getVideo());
		this.setVideoUrl(exercise.getVideoUrl());
		this.setCoachId(exercise.getCoachId());
		this.setSubCategoryId(exercise.getSubCategoryId());
	}
	

	// GETTERS & SETTERS
	public long getExerciseId() {
		return exerciseId;
	}
	public void setExerciseId(long exerciseId) {
		this.exerciseId = exerciseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}
	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}
	public String getObjective() {
		return objective;
	}
	public void setObjective(String objective) {
		this.objective = objective;
	}
	public List<MaterialVO> getMaterials() {
		return materials;
	}
	public void setMaterials(List<MaterialVO> materials) {
		this.materials = materials;
	}
	public long getCoachId() {
		return coachId;
	}
	public void setCoachId(long coachId) {
		this.coachId = coachId;
	}
	public long getSubCategoryId() {
		return subCategoryId;
	}
	public void setSubCategoryId(long subCategoryId) {
		this.subCategoryId = subCategoryId;
	}
	public String getDesign() {
		return design;
	}
	public void setDesign(String design) {
		this.design = design;
	}
	public MultipartFile getVideo() {
		return video;
	}
	public void setVideo(MultipartFile video) {
		this.video = video;
	}
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	public String getDesignUrl() {
		return designUrl;
	}
	public void setDesignUrl(String designUrl) {
		this.designUrl = designUrl;
	}
	public long getDesignId() {
		return designId;
	}
	public void setDesignId(long designId) {
		this.designId = designId;
	}
	public long getVideoId() {
		return videoId;
	}
	public void setVideoId(long videoId) {
		this.videoId = videoId;
	}
}
