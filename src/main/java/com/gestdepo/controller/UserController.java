package com.gestdepo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gestdepo.dao.IUserDAO;
import com.gestdepo.model.UserVO;

//@Controller
//@RequestMapping("/user")
public class UserController {
	/*
	@Autowired
	private IUserDAO userDAO;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
    public ResponseEntity<UserVO> login(
    		@RequestParam("username") String username,
    		@RequestParam("password") String password,
    		@RequestHeader("Accept") String acceptHeader
    		//HttpSession session
    		) {

    	UserVO user = userDAO.get(username, password);
		if (user == null) {
			return new ResponseEntity<UserVO>(new UserVO(), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<UserVO>(user, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/users/{id}", produces = "application/json")
	@ResponseBody
	public ResponseEntity<List<UserVO>> getUser(
			@PathVariable Long id,
			@RequestHeader("Accept") String acceptHeader
			) {
    	return new ResponseEntity<List<UserVO>>(userDAO.list(), HttpStatus.OK);
	}
	*/
}
