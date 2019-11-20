package project2.controls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import project2.entities.Attendants;
import project2.models.AttendantCreateRequest;
import project2.services.AttendantService;

@RestController
@RequestMapping("attend/*")
public class AttendantController {
	
	AttendantService attendServ; 
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(path="/attend/1")
	public Attendants saveAttendant(@RequestBody AttendantCreateRequest attend) {
		System.out.println("Attempting Attendant Write...");
		System.out.println("ACR in: " + attend.toString());
		return attendServ.saveAttendant(attend);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(path="/attend/2")
	public List<Attendants> getAttendantsByUserId(@RequestBody int id) {
		System.out.println("Attempting Attendant Read by User...");
		return attendServ.getAttendsByUserId(id);
	}
	
	@Autowired
	public AttendantController(AttendantService attendServ) {
		super();
		this.attendServ = attendServ;
	}
	
}
