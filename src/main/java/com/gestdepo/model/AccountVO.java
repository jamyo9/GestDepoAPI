package com.gestdepo.model;

public abstract class AccountVO {
	
	private String userName;
	private String password;
	private String newPassword;
	private String email;
	
	private Long expires;
	
	public AccountVO() {
		this.setUserName("userName");
		this.setEmail("Email");
		this.setPassword("pwd");
		this.setNewPassword("newPwd");
		this.setExpires(0L);
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public Long getExpires() {
		return expires;
	}

	public void setExpires(Long expires) {
		this.expires = expires;
	}
}
