package project2.models;

public class AttendantCreateRequest {
	private int user_id;
	private int event_id;
	private int user_role_id;
	private int permissions_id;
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
		AttendantCreateRequest other = (AttendantCreateRequest) obj;
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
		return "AttendantCreateRequest [user_id=" + user_id + ", event_id=" + event_id + ", user_role_id="
				+ user_role_id + ", permissions_id=" + permissions_id + "]";
	}
	public AttendantCreateRequest(int user_id, int event_id, int user_role_id, int permissions_id) {
		super();
		this.user_id = user_id;
		this.event_id = event_id;
		this.user_role_id = user_role_id;
		this.permissions_id = permissions_id;
	}
	public AttendantCreateRequest() {
		super();
	}
	
	
	
}
