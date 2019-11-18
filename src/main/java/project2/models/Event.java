package project2.models;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;


@Entity
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int event_id;


	@Column(nullable=false, length = 50)
	private String title;

	@Column(nullable=false)
	private int type;

	@Column(nullable=true)
	private Timestamp created;

	@Column(nullable=true)
	private Timestamp startTime;

	@Column(nullable=true)
	private Timestamp endTime;

	@Column(nullable=true, length = 250)
	private String description;

	@Column(nullable=false, length = 250)
	private String location;

	@Column(nullable=true, length = 250)
	private String address;

	@Column(nullable=true)
	private String imgAddr;

	@Column(nullable=false)
	private int visibility;
	
	
	public int getEvent_id() {
		return event_id;
	}

	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public int getType() {
		return type;
	}



	public void setType(int type) {
		this.type = type;
	}



	public Timestamp getCreated() {
		return created;
	}



	public void setCreated(Timestamp created) {
		this.created = created;
	}



	public Timestamp getStartTime() {
		return startTime;
	}



	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}



	public Timestamp getEndTime() {
		return endTime;
	}



	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getImgAddr() {
		return imgAddr;
	}



	public void setImgAddr(String imgAddr) {
		this.imgAddr = imgAddr;
	}



	public int getVisibility() {
		return visibility;
	}



	public void setVisibility(int visibility) {
		this.visibility = visibility;
	}

	

	public Event(int event_id, String title, int type, Timestamp created, Timestamp startTime, Timestamp endTime,
			String description, String location, String address, String imgAddr, int visibility) {
		super();
		this.event_id = event_id;
		this.title = title;
		this.type = type;
		this.created = created;
		this.startTime = startTime;
		this.endTime = endTime;
		this.description = description;
		this.location = location;
		this.address = address;
		this.imgAddr = imgAddr;
		this.visibility = visibility;
	}

	@Override
	public String toString() {
		return "Event [event_id=" + event_id + ", title=" + title + ", type=" + type + ", created=" + created
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", description=" + description + ", location="
				+ location + ", address=" + address + ", imgAddr=" + imgAddr + ", visibility=" + visibility + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + event_id;
		result = prime * result + ((imgAddr == null) ? 0 : imgAddr.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + type;
		result = prime * result + visibility;
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
		Event other = (Event) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (event_id != other.event_id)
			return false;
		if (imgAddr == null) {
			if (other.imgAddr != null)
				return false;
		} else if (!imgAddr.equals(other.imgAddr))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (type != other.type)
			return false;
		if (visibility != other.visibility)
			return false;
		return true;
	}

	public Event() {
		super();
	}


}
