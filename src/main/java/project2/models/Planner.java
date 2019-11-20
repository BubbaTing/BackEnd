package project2.models;

import project2.entities.Event;

public class Planner {
	
	private Event clientRequest;
	private int userId;
	
	public Event getClientRequest() {
		return clientRequest;
	}
	public void setClientRequest(Event clientRequest) {
		this.clientRequest = clientRequest;
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
		result = prime * result + ((clientRequest == null) ? 0 : clientRequest.hashCode());
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
		Planner other = (Planner) obj;
		if (clientRequest == null) {
			if (other.clientRequest != null)
				return false;
		} else if (!clientRequest.equals(other.clientRequest))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Planner [clientRequest=" + clientRequest + ", userId=" + userId + "]";
	}
	public Planner(Event clientRequest, int userId) {
		super();
		this.clientRequest = clientRequest;
		this.userId = userId;
	}
	public Planner() {
		super();
	}
}
