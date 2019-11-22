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
	private String user_role_description;
	
    @OneToMany(mappedBy="visibility")
    private Set<Event> event;

	public int getVisibility_id() {
		return visibility_id;
	}

	public void setVisibility_id(int visibility_id) {
		this.visibility_id = visibility_id;
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
		if (user_role_description == null) {
			if (other.user_role_description != null)
				return false;
		} else if (!user_role_description.equals(other.user_role_description))
			return false;
		if (visibility_id != other.visibility_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Visibility [visibility_id=" + visibility_id + ", user_role_description=" + user_role_description + "]";
	}

	public Visibility(int visibility_id, String user_role_description) {
		super();
		this.visibility_id = visibility_id;
		this.user_role_description = user_role_description;
	}

	public Visibility() {
		super();
	}
	
}
