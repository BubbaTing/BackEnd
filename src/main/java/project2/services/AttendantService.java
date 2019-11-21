package project2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project2.daos.AttendantDao;
import project2.daos.EventDao;
import project2.daos.UserDao;
import project2.entities.Attendants;
import project2.models.AttendantCreateRequest;

@Service
public class AttendantService {
	AttendantDao attendDao;
	EventDao eventDao;
	UserDao userDao;
	
	@Autowired
	public AttendantService(AttendantDao attendDao, EventDao eventDao, UserDao userDao) {
		super();
		this.attendDao = attendDao;
		this.eventDao = eventDao;
		this.userDao = userDao;
	}
	
	/**
	 * Attempts to save an Attendant to the Database. Returns null if the AttendantCreateRequest was invalid or failed.
	 * @param acr
	 * @return
	 */
	@Transactional
	public Attendants saveAttendant(AttendantCreateRequest acr){
		Attendants attend = mapAttendantsReq(acr);
		System.out.println("ACR in: " + acr.toString());
		System.out.println("Saving Attendants :" + attend.toString());
		return attendDao.saveAttendant(attend);

	}
	
	/**
	 * Returns an attendant by ID.
	 * @param id
	 * @return
	 */
	@Transactional
	public Attendants getAttendsById(int id) {
		return attendDao.getAttendantsById(id);
	}
	
	/**
	 * Maps an AttendantCreateRequest to an Attendants object, returning the Attendants object.
	 * Returns null if none were found. This CAN return an Attendants object with null values.
	 * It is suggested that you validate with Attendants.hasNulls().
	 * @param attend
	 * @return
	 */
	@Transactional
	public Attendants mapAttendantsReq(AttendantCreateRequest attend) {
		Attendants newattend = new Attendants();
		
		newattend.setUser_id(attend.getUser_id());
		newattend.setEvent_id(attend.getEvent_id());
	
		newattend.setUser_role_id(attend.getUser_role_id());
		
		return newattend;
	}

	public List<Attendants> getAttendsByUserId(int userid) {
		return attendDao.getAttendsByUserId(userid);
	}
}
