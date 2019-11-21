package project2.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Attendants {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int attendant_id;
	
	private int user_id;
	private int event_id;
	private int user_role_id;
	
	
	public int getAttendant_id() {
		return attendant_id;
	}
	public void setAttendant_id(int attendant_id) {
		this.attendant_id = attendant_id;
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + attendant_id;
		result = prime * result + event_id;
		
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
		if (attendant_id != other.attendant_id)
			return false;
		if (event_id != other.event_id)
			return false;
		
		if (user_id != other.user_id)
			return false;
		if (user_role_id != other.user_role_id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Attendants [attendant_id=" + attendant_id + ", user_id=" + user_id + ", event_id=" + event_id
				+ ", user_role_id=" + user_role_id + "]";
	}
	public Attendants(int attendant_id, int user_id, int event_id, int user_role_id) {
		super();
		this.attendant_id = attendant_id;
		this.user_id = user_id;
		this.event_id = event_id;
		this.user_role_id = user_role_id;
	
	}
	public Attendants() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
