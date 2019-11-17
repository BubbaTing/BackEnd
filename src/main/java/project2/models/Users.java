package project2.models;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;



@Entity
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "join_event" ,
	joinColumns= {@JoinColumn(name = "user_id")},
	inverseJoinColumns= {@JoinColumn(name = "event_id")})
	
	private List<Event> userId;
	
	@Column(nullable = false, length = 25)
	private String firstname;
	
	@Column(nullable = false, length = 25)
	private String lastname;
	
	@Column(nullable= false, length = 35)
	private String email;
	
	@Column(nullable = false, length = 150)
	private byte[] password;
	
	@Column(nullable = false, length=20)
	private byte[] salt;
	
	@Column(nullable = false)
	private Timestamp createdDate;
	
	private Timestamp lastLogin;
	@Column(nullable=true)
	private String avatarURL;

			
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAvatarURL() {
		return avatarURL;
	}

	public void setAvatarURL(String avatarURL) {
		this.avatarURL = avatarURL;
	}
	
	public List<Event> getUserId() {
		return userId;
	}

	public void setUserId(List<Event> userId) {
		this.userId = userId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte[] getPassword() {
		return password;
	}

	public void setPassword(byte[] password) {
		this.password = password;
	}

	public byte[] getSalt() {
		return salt;
	}

	public void setSalt(byte[] salt) {
		this.salt = salt;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

	
	
	
	public Users(int id, List<Event> userId, String firstname, String lastname, String email, byte[] password,
			byte[] salt, Timestamp createdDate, Timestamp lastLogin, String avatarURL) {
		super();
		this.id = id;
		this.userId = userId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.salt = salt;
		this.createdDate = createdDate;
		this.lastLogin = lastLogin;
		this.avatarURL = avatarURL;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", userId=" + userId + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + ", password=" + Arrays.toString(password) + ", salt=" + Arrays.toString(salt)
				+ ", createdDate=" + createdDate + ", lastLogin=" + lastLogin + ", avatarURL=" + avatarURL + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((avatarURL == null) ? 0 : avatarURL.hashCode());
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastLogin == null) ? 0 : lastLogin.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + Arrays.hashCode(password);
		result = prime * result + Arrays.hashCode(salt);
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		Users other = (Users) obj;
		if (avatarURL == null) {
			if (other.avatarURL != null)
				return false;
		} else if (!avatarURL.equals(other.avatarURL))
			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (id != other.id)
			return false;
		if (lastLogin == null) {
			if (other.lastLogin != null)
				return false;
		} else if (!lastLogin.equals(other.lastLogin))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (!Arrays.equals(password, other.password))
			return false;
		if (!Arrays.equals(salt, other.salt))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
