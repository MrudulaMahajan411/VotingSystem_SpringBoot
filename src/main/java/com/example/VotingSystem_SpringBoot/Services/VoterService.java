package com.example.VotingSystem_SpringBoot.Services;

import java.util.List;
import java.util.Optional;

import com.example.VotingSystem_SpringBoot.Entity.Voter;


public interface VoterService {
	public Voter saveVoter(Voter voter);

	public List<Voter> voterlist();
	

	public void deleteById(int id);

	public Voter findById(int id);
 
	public Voter updateVoter(Voter voter,int id);
	
	 Voter findVoterByUsernameAndPassword(String username, String password);
	    void updateVoter(Voter voter);
	
}
