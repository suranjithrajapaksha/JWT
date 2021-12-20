package com.example.myapp;

public class Register {
	 private String user;
	 private String password;
	 private String token;

	 public String getuser() {
	  return user;
	 }

	 public void setuser(String user) {
	  this.user = user;
	 }

	 public String getPassword() {
	  return password;
	 }

	 public void setPassword(String password) {
	  this.password = password;
	 }
	 @Override
	 public String toString() {
		 
		 return ""+ user +","+password+"";
	 }
		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}
}
