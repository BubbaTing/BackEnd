package project2.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AttendantsFirst {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int attendant_id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(
			name="user_id",
			referencedColumnName = "user_id")
	private Users user_id;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(
			name="event_id",
			referencedColumnName = "event_id")
	private Event event_id;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(
			name="user_role_id",
			referencedColumnName = "user_role_id")
	private UserRoles user_role_id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(
			name="permissions_id",
			referencedColumnName = "permissions_id")
	private Permissions permissions_id;
	
}
