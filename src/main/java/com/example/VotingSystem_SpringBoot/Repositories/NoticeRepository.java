package com.example.VotingSystem_SpringBoot.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.VotingSystem_SpringBoot.Entity.Election_Updates;


@Repository
public interface NoticeRepository extends JpaRepository<Election_Updates, Integer> {
	
	
}
