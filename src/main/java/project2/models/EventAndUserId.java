package project2.models;

public class EventAndUserId {
	
	private int eventId;
	private int userId;
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + eventId;
		result = prime * result + userId;
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
		EventAndUserId other = (EventAndUserId) obj;
		if (eventId != other.eventId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "EventAndUserId [eventId=" + eventId + ", userId=" + userId + "]";
	}
	public EventAndUserId(int eventId, int userId) {
		super();
		this.eventId = eventId;
		this.userId = userId;
	}
	public EventAndUserId() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
