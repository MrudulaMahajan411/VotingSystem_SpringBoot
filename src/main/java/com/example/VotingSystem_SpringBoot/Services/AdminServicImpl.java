package com.example.VotingSystem_SpringBoot.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.VotingSystem_SpringBoot.Entity.Admin;
import com.example.VotingSystem_SpringBoot.Entity.Election_Updates;
import com.example.VotingSystem_SpringBoot.Repositories.AdminRepositorie;
import com.example.VotingSystem_SpringBoot.Repositories.NoticeRepository;

@Service
public class AdminServicImpl implements AdminServies {
	@Autowired
	AdminRepositorie adminRepo;
	
	public void saveAdmin(Admin admin) {
		adminRepo.save(admin);
	}

	@Override
	public List<Admin> addminList() {
		List<Admin> find = adminRepo.findAll();
		return find;
	}

}
