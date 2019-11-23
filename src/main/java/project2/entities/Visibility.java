package project2.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Visibility {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int visibility_id;
	
	@Column(nullable = false, length = 25)
	private String visibility_description;
	
    @OneToMany(mappedBy="visibility")
    private Set<Event> event;
    
	public Visibility(int visibility_id, String visibility_description, Set<Event> event) {
		super();
		this.visibility_id = visibility_id;
		this.visibility_description = visibility_description;
		this.event = event;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((event == null) ? 0 : event.hashCode());
		result = prime * result + ((visibility_description == null) ? 0 : visibility_description.hashCode());
		result = prime * result + visibility_id;
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
		Visibility other = (Visibility) obj;
		if (event == null) {
			if (other.event != null)
				return false;
		} else if (!event.equals(other.event))
			return false;
		if (visibility_description == null) {
			if (other.visibility_description != null)
				return false;
		} else if (!visibility_description.equals(other.visibility_description))
			return false;
		if (visibility_id != other.visibility_id)
			return false;
		return true;
	}



	public int getVisibility_id() {
		return visibility_id;
	}



	public void setVisibility_id(int visibility_id) {
		this.visibility_id = visibility_id;
	}



	public String getVisibility_description() {
		return visibility_description;
	}



	public void setVisibility_description(String visibility_description) {
		this.visibility_description = visibility_description;
	}



	public Visibility() {
		super();
	}
	
}
