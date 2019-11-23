package project2.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Types {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int type_id;
		
	@Column(nullable = false, length = 25)
	private String type_description;
	
    @OneToMany(mappedBy="type")
    private Set<Event> event;

	public int getType_id() {
		return type_id;
	}

	public void setType_id(int type_id) {
		this.type_id = type_id;
	}

	public String getType_description() {
		return type_description;
	}

	public void setType_description(String type_description) {
		this.type_description = type_description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type_description == null) ? 0 : type_description.hashCode());
		result = prime * result + type_id;
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
		Types other = (Types) obj;
		if (type_description == null) {
			if (other.type_description != null)
				return false;
		} else if (!type_description.equals(other.type_description))
			return false;
		if (type_id != other.type_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Types [type_id=" + type_id + ", type_description=" + type_description + "]";
	}

	public Types(int type_id, String type_description) {
		super();
		this.type_id = type_id;
		this.type_description = type_description;
	}

	public Types() {
		super();
	}
    
	
    
}
