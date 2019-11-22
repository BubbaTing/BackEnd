package project2.models;

import project2.entities.Users;

public class UserResponse {
	private int userid;	
	private String firstname;
	private String email;
	private String avatar;
	private String jwt;
	
	public String getJwt() {
		return jwt;
	}
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	@Override
	public String toString() {
		return "UserResponse [userid=" + userid + ", firstname=" + firstname + ", email=" + email + ", avatar=" + avatar
				+ ", jwt=" + jwt + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((avatar == null) ? 0 : avatar.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((jwt == null) ? 0 : jwt.hashCode());
		result = prime * result + userid;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserResponse other = (UserResponse) obj;
		if (avatar == null) {
			if (other.avatar != null)
				return false;
		} else if (!avatar.equals(other.avatar))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (jwt == null) {
			if (other.jwt != null)
				return false;
		} else if (!jwt.equals(other.jwt))
			return false;
		if (userid != other.userid)
			return false;
		return true;
	}
	public UserResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserResponse(int userid, String firstname, String email, String avatar, String jwt) {
		super();
		this.userid = userid;
		this.firstname = firstname;
		this.email = email;
		this.avatar = avatar;
		this.jwt = jwt;
	}
	public UserResponse(Users user) {
		this.userid = user.getUser_id();
		this.firstname = user.getFirstname();
		this.email = user.getEmail();
		this.avatar = user.getAvatarURL();
	}
	
	
}
