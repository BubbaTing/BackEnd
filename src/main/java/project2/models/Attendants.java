package project2.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import project2.models.Event;
import project2.models.Users;

@Entity
public class Attendants {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int attendat_id;
	
	//@ManyToOne(fetch=FetchType.LAZY)
	//@JoinColumn(name="userId")
	@Column(nullable = false)
	private int user_id;
	
	
	//@OneToMany(fetch=FetchType.LAZY)
	//@JoinColumn(name="eventId")
	@Column(nullable = false)
	private int event_id;

	//@OneToMany(fetch=FetchType.LAZY)
	//@JoinColumn(name="user_role_Id")
	@Column(nullable = false)
	private int user_role_id;
	
	//@OneToMany(fetch=FetchType.LAZY)
	//@JoinColumn(name="permissions_id")
	@Column(nullable = false)
	private int permissions_id;
		
		public int getAttendat_id() {
		return attendat_id;
	}

	public void setAttendat_id(int attendat_id) {
		this.attendat_id = attendat_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getEvent_id() {
		return event_id;
	}

	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}

	public int getUser_role_id() {
		return user_role_id;
	}

	public void setUser_role_id(int user_role_id) {
		this.user_role_id = user_role_id;
	}

	public int getPermissions_id() {
		return permissions_id;
	}

	public void setPermissions_id(int permissions_id) {
		this.permissions_id = permissions_id;
	}
	
		@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + attendat_id;
		result = prime * result + event_id;
		result = prime * result + permissions_id;
		result = prime * result + user_id;
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
		Attendants other = (Attendants) obj;
		if (attendat_id != other.attendat_id)
			return false;
		if (event_id != other.event_id)
			return false;
		if (permissions_id != other.permissions_id)
			return false;
		if (user_id != other.user_id)
			return false;
		if (user_role_id != other.user_role_id)
			return false;
		return true;
	}
	
		@Override
	public String toString() {
		return "Attendants [attendat_id=" + attendat_id + ", user_id=" + user_id + ", event_id=" + event_id
				+ ", user_role_id=" + user_role_id + ", permissions_id=" + permissions_id + "]";
	}
		
		public Attendants(int attendat_id, int user_id, int event_id, int user_role_id, int permissions_id) {
			super();
			this.attendat_id = attendat_id;
			this.user_id = user_id;
			this.event_id = event_id;
			this.user_role_id = user_role_id;
			this.permissions_id = permissions_id;
		}

		public Attendants() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
