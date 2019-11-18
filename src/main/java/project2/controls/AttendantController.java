package project2.controls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import project2.models.Attendants;
import project2.services.AttendantService;

@RestController
@RequestMapping("attend/*")
public class AttendantController {
	
	AttendantService attendServ; 
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(path="/attend/1")
	public Attendants saveAttendant(@RequestBody Attendants attend) {
		System.out.println("Attempting Attendant Write...");
		return attendServ.saveAttendant(attend);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(path="/attend/2")
	public Attendants getAttendantById(@RequestBody int id) {
		System.out.println("Attempting Attendant Write...");
		return attendServ.getAttendById(id);
	}
	
	@Autowired
	public AttendantController(AttendantService attendServ) {
		super();
		this.attendServ = attendServ;
	}
	
}
