package com.example.VotingSystem_SpringBoot.Services;

import java.util.List;

import com.example.VotingSystem_SpringBoot.Entity.Election_Updates;
import com.example.VotingSystem_SpringBoot.Entity.Voter;

public interface NoticeServices {
	public void SaveNotice(Election_Updates election_Updates);
	public List<Election_Updates> getAllNotices();
	public Election_Updates findById(int update_Id);
}
