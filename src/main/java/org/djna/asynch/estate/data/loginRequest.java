package org.djna.asynch.estate.data;

public class loginRequest {
	private String username;
	private String password;

	public loginRequest() {}

	public loginRequest(String newusername, String newpassword) {
		username = newusername;
		password = newpassword;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
