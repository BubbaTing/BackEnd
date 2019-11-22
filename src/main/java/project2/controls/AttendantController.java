package project2.controls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import project2.entities.Attendants;
import project2.models.AttendantCreateRequest;
import project2.services.AttendantService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("attend/*")
public class AttendantController {
	
	AttendantService attendServ; 
	
	/**
	 * Writes an Attendants object to the database.
	 * @param attend
	 * @return
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(path="/attend/1")
	public Attendants saveAttendant(@RequestBody AttendantCreateRequest attend) {
		System.out.println("Attempting Attendant Write...");
		return attendServ.saveAttendant(attend);
	}
		
	/**
	 * Updates an attendants record given the incoming attendants user_id, event_id 
	 * exists in the database already.
	 * @param attend
	 * @return
	 */
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(path="/attend/2")
	public Attendants updateAttendants(@RequestBody Attendants attend) {
		System.out.println("Attempting Attendant Read by User...");
		return attendServ.updateAttendant(attend);
	}
	
	@Autowired
	public AttendantController(AttendantService attendServ) {
		super();
		this.attendServ = attendServ;
	}
	
	// We dont want this request exposed for the moment, if we need it we can uncomment and update it.
//	/**
//	 * Returns a list of attendants given a Userid.
//	 * @param id
//	 * @return
//	 */
//	@GetMapping
//	@ResponseStatus(HttpStatus.OK)
//	@RequestMapping(path="/attend/2")
//	public List<Attendants> getAttendantsByUserId(@RequestBody int id) {s
//		System.out.println("Attempting Attendant Read by User...");
//		return attendServ.getAttendsByUserId(id);
//	}
	
}
