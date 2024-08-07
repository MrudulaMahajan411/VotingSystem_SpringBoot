package com.example.VotingSystem_SpringBoot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class MainController {
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome";
	}
	@GetMapping("/Alogin")
	public String Alogin() {
		return "adminlogin";
	}
	@GetMapping("/Vlogin")
	public String Vlogin() {
		return "Voterlogin";
	}
	@GetMapping("/Adashbord")
	public String Adashbord () {
		return "Admin_Dashbord";
	}
	@GetMapping("/Vdashbord")
	public String Vdashbord() {
		return "Voter_Dashbord";
	}
	

	
}
