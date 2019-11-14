package project2.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false, length = 50)
	private String title;
	
	@Column(nullable=false)
	private int type;
	
	@Column(nullable=false)
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
}
