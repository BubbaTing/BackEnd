package project2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project2.daos.AttendantDao;
import project2.entities.Attendants;

@Service
public class AttendantService {
	AttendantDao attendDao = new AttendantDao();
	
	@Autowired
	public AttendantService(AttendantDao attendDao) {
		super();
		this.attendDao = attendDao;
	}
	
	@Transactional
	public Attendants saveAttendant(Attendants attend) {
		return attendDao.saveAttendant(attend);
	}
	
	@Transactional
	public Attendants getAttendById(int id) {
		return attendDao.getAttendantById(id);
	}
}
