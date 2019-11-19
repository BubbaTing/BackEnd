package project2.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Attendants {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int attendat_id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(
			name="user_id",
			referencedColumnName = "user_id")
	private Users user_id;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(
			name="event_id",
			referencedColumnName = "event_id")
	private Event event_id;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(
			name="user_role_id",
			referencedColumnName = "user_role_id")
	private UserRoles user_role_id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(
			name="permissions_id",
			referencedColumnName = "permissions_id")
	private Permissions permissions_id;

	public int getAttendat_id() {
		return attendat_id;
	}

	public void setAttendat_id(int attendat_id) {
		this.attendat_id = attendat_id;
	}

	public Users getUser_id() {
		return user_id;
	}

	public void setUser_id(Users user_id) {
		this.user_id = user_id;
	}

	public Event getEvent_id() {
		return event_id;
	}

	public void setEvent_id(Event event_id) {
		this.event_id = event_id;
	}

	public UserRoles getUser_role_id() {
		return user_role_id;
	}

	public void setUser_role_id(UserRoles user_role_id) {
		this.user_role_id = user_role_id;
	}

	public Permissions getPermissions_id() {
		return permissions_id;
	}

	public void setPermissions_id(Permissions permissions_id) {
		this.permissions_id = permissions_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + attendat_id;
		result = prime * result + ((event_id == null) ? 0 : event_id.hashCode());
		result = prime * result + ((permissions_id == null) ? 0 : permissions_id.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
		result = prime * result + ((user_role_id == null) ? 0 : user_role_id.hashCode());
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
		Attendants other = (Attendants) obj;
		if (attendat_id != other.attendat_id)
			return false;
		if (event_id == null) {
			if (other.event_id != null)
				return false;
		} else if (!event_id.equals(other.event_id))
			return false;
		if (permissions_id == null) {
			if (other.permissions_id != null)
				return false;
		} else if (!permissions_id.equals(other.permissions_id))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		if (user_role_id == null) {
			if (other.user_role_id != null)
				return false;
		} else if (!user_role_id.equals(other.user_role_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Attendants [attendat_id=" + attendat_id + ", user_id=" + user_id + ", event_id=" + event_id
				+ ", user_role_id=" + user_role_id + ", permissions_id=" + permissions_id + "]";
	}

	public Attendants(int attendat_id, Users user_id, Event event_id, UserRoles user_role_id,
			Permissions permissions_id) {
		super();
		this.attendat_id = attendat_id;
		this.user_id = user_id;
		this.event_id = event_id;
		this.user_role_id = user_role_id;
		this.permissions_id = permissions_id;
	}

	public Attendants() {
		super();
	}
	
}
