package com.example.VotingSystem_SpringBoot.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.VotingSystem_SpringBoot.Entity.Admin;


@Repository
public interface AdminRepositorie extends JpaRepository<Admin, Integer> {
	Optional<Admin> findByusername(String username);

}
