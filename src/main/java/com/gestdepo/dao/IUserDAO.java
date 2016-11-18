package com.gestdepo.dao;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.gestdepo.model.UserVO;

public interface IUserDAO {

	UserVO get(String username, String password);
	List<UserVO> list();
	
	UserDetails getByUserName(String username);

}
