
package com.example.VotingSystem_SpringBoot.Services;

import java.util.List;

import com.example.VotingSystem_SpringBoot.Entity.Admin;
import com.example.VotingSystem_SpringBoot.Entity.Election_Updates;

public interface AdminServies  {
	public void saveAdmin(Admin admin);
	public List<Admin> addminList();

	
}
