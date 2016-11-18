package com.gestdepo.model;

import java.util.List;
import java.util.Locale;

public class PlayerVO extends UserVO {

	public PlayerVO(long userId, long clubId, String email, String userName, String password, String name, String lastName, String passwordRepeated, Locale locale, List<Rol> rols) {
		// TODO Auto-generated constructor stub
		super(userId, clubId, email, userName, password, name, lastName, passwordRepeated, locale, rols);
		
	}

	public PlayerVO() {
		// TODO Auto-generated constructor stub
		super();
		
	}

}
