package com.example.VotingSystem_SpringBoot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.VotingSystem_SpringBoot.Entity.Election_Updates;
import com.example.VotingSystem_SpringBoot.Entity.Voter;
import com.example.VotingSystem_SpringBoot.Repositories.NoticeRepository;
import com.example.VotingSystem_SpringBoot.Services.NoticeServices;

import jakarta.validation.Valid;

@Controller
public class Noticecontroller {
	@Autowired
	NoticeRepository noticeRepository;
	@Autowired
	NoticeServices noticeServices;

	@GetMapping("saveNotice")
	public String saveNotice(Election_Updates election_Updates) {
		return "writeNotice";
	}

	@PostMapping("/gosaveNotice")
	public String getsaveNotice(@Valid @ModelAttribute Election_Updates election_Updates, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "writeNotice";
		}
		noticeServices.SaveNotice(election_Updates);
		return "Admin_Dashbord";

	}
	  @GetMapping("/viewNotice")
		public String viewNotices(@ModelAttribute Election_Updates election_Updates, Model model) {
			List<Election_Updates> find = noticeRepository.findAll();
			model.addAttribute("notices", find);
			return "viewNotice";
		}


}
