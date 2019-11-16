package project2.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Permissions {
	
	@Id
	private int permissions_id;
	@Column(nullable = false, length = 25)
	private String permissions_description;
	public int getPermissions_id() {
		return permissions_id;
	}
	public void setPermissions_id(int permissions_id) {
		this.permissions_id = permissions_id;
	}
	public String getPermissions_description() {
		return permissions_description;
	}
	public void setPermissions_description(String permissions_description) {
		this.permissions_description = permissions_description;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((permissions_description == null) ? 0 : permissions_description.hashCode());
		result = prime * result + permissions_id;
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
		Permissions other = (Permissions) obj;
		if (permissions_description == null) {
			if (other.permissions_description != null)
				return false;
		} else if (!permissions_description.equals(other.permissions_description))
			return false;
		if (permissions_id != other.permissions_id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Permissions [permissions_id=" + permissions_id + ", permissions_description=" + permissions_description
				+ "]";
	}
	public Permissions(int permissions_id, String permissions_description) {
		super();
		this.permissions_id = permissions_id;
		this.permissions_description = permissions_description;
	}
	public Permissions() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	

}
