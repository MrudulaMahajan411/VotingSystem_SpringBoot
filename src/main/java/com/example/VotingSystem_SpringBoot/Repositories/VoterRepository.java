package com.example.VotingSystem_SpringBoot.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.VotingSystem_SpringBoot.Entity.Voter;

@Repository
public interface VoterRepository extends JpaRepository<Voter, Integer> {

	Optional<Voter> findByUsername(String username);

	Voter findByUsernameAndPassword(String username, String password);
}
