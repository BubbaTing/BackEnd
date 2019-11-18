package project2.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class User_roles {
	
	@Id
	//@OneToMany(fetch=FetchType.LAZY)
	//@JoinTable(name = "attendants")
	//@JoinColumn(name = "user_role_id")
	private int user_role_id;
		
	@Column(nullable = false, length = 25)
	private String user_role_description;

	public int getUser_role_id() {
		return user_role_id;
	}

	public void setUser_role_id(int user_role_id) {
		this.user_role_id = user_role_id;
	}

	public String getUser_role_description() {
		return user_role_description;
	}

	public void setUser_role_description(String user_role_description) {
		this.user_role_description = user_role_description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user_role_description == null) ? 0 : user_role_description.hashCode());
		result = prime * result + user_role_id;
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
		User_roles other = (User_roles) obj;
		if (user_role_description == null) {
			if (other.user_role_description != null)
				return false;
		} else if (!user_role_description.equals(other.user_role_description))
			return false;
		if (user_role_id != other.user_role_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User_roles [user_role_id=" + user_role_id + ", user_role_description=" + user_role_description + "]";
	}

	public User_roles(int user_role_id, String user_role_description) {
		super();
		this.user_role_id = user_role_id;
		this.user_role_description = user_role_description;
	}

	public User_roles() {
		super();
		// TODO Auto-generated constructor stub
	}

}
