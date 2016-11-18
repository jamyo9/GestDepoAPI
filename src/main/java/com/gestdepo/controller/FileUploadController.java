package com.gestdepo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gestdepo.dao.FileDAO;
import com.gestdepo.model.ExerciseVO;

@RestController
@RequestMapping("/videoUrl")
//@Secured("ROLE_USER")
public class FileUploadController {
	
	@Autowired
	private FileDAO fileDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Long> uploadVideo(@RequestBody MultipartFile video) {
		
		//String videoUrl = StorageService.store(video);
		//return new ResponseEntity<String>(videoUrl, HttpStatus.OK);
		long videoId = fileDAO.saveFile(video, video.getName(), "video/mp4", ExerciseVO.class, 0l, 0l);
		
		return new ResponseEntity<Long>(videoId, HttpStatus.OK);
	}
}