package com.example.VotingSystem_SpringBoot.Controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.processing.Find;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.VotingSystem_SpringBoot.Entity.Voter;
import com.example.VotingSystem_SpringBoot.Repositories.VoterRepository;
import com.example.VotingSystem_SpringBoot.Services.VoterService;

import jakarta.validation.Valid;

@Controller
public class VoterController {

	@Autowired
	VoterRepository voterrepo;

	@Autowired
	VoterService voterService;

	@GetMapping("saveVoter")
	public String saveVoter(Voter voter) {
		return "voterregister";
	}

	@PostMapping("govoterregister")
	public String getVoterStatus(@Valid @ModelAttribute Voter voter, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "voterregister";
		}
		voterService.saveVoter(voter);
		return "Voterlogin";

	}

	@PostMapping("/govoterlogin")
	public String handleVoterLogin1(@ModelAttribute Voter voter, Model model) {

		Optional<Voter> existingVoterOpt1 = voterrepo.findByUsername(voter.getUsername());

		if (existingVoterOpt1.isPresent()) {
			Voter existingVoter = existingVoterOpt1.get();
			System.out.println();
			System.out.println(voter.getPassword());
			System.out.println(existingVoter.getPassword());

			if (existingVoter.getPassword().equals(voter.getPassword())) {
				return "Voter_Dashbord";
			}
		}

		return "Voterlogin";
	}
    @PostMapping("/deleteVoter/{id}")
    public String deleteVoter(@PathVariable("id") Integer id) {
        voterrepo.deleteById(id);
        return "redirect:/findvoters"; // Redirect back to the voter list page
    }


	@GetMapping("/findvoters")
	public String viewAllVoters(@ModelAttribute Voter voter, Model model) {
		List<Voter> find = voterrepo.findAll();
		model.addAttribute("voters", find);
		return "ViewVoters";
	}

	@GetMapping("/updateVoter")
	public String showUpdateForm() {
		return "UpdateVoterRequest";
	}

	@PostMapping("/findVoterForUpdate")
	public String findVoterForUpdate(@RequestParam("username") String username,
			@RequestParam("password") String password, Model model) {
		Voter voter = voterrepo.findByUsernameAndPassword(username, password);
		if (voter != null) {
			model.addAttribute("voter", voter);
			return "UpdateVoterForm"; // Redirect to the update form
		} else {
			model.addAttribute("error", "Invalid username or password");
			return "UpdateVoterRequest"; // Stay on the same page and show an error
		}
	}

	// Step 3: Handle the update operation
	@PostMapping("/updateVoterDetails")
	public String updateVoterDetails(@ModelAttribute Voter voter) {
		voterrepo.save(voter);
		return "redirect:/findvoters"; // Redirect back to the voter list page after update
	}
}
