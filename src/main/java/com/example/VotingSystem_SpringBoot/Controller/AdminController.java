package com.example.VotingSystem_SpringBoot.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.VotingSystem_SpringBoot.Entity.Admin;
import com.example.VotingSystem_SpringBoot.Entity.Election_Updates;
import com.example.VotingSystem_SpringBoot.Repositories.AdminRepositorie;
import com.example.VotingSystem_SpringBoot.Services.AdminServies;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {
	@Autowired
	AdminRepositorie adminRepo;
	@Autowired
	AdminServies adminServies;

	@GetMapping("saveAdmin")
	public String saveAdmin(Admin admin) {
		return "adminregister";
	}

	@PostMapping("goadminregister")
	public String getAdminStatus(@Valid @ModelAttribute Admin admin, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "adminregister";
		}
		adminServies.saveAdmin(admin);
		return "adminlogin";

	}

	@PostMapping("/goadminlogin")
	public String handleAdminLogin1(@ModelAttribute Admin admin, Model model) {

		Optional<Admin> existingAdmin1 =adminRepo.findByusername(admin.getUsername());

		if (existingAdmin1.isPresent()) {
			Admin existingAdmin = existingAdmin1.get();
			System.out.println();
			System.out.println(admin.getPassword());
			System.out.println(existingAdmin.getPassword());

			if (existingAdmin.getPassword().equals(admin.getPassword())) {
				return "Admin_Dashbord";
			}
		}
		return "adminlogin";
	}
	

	

}
