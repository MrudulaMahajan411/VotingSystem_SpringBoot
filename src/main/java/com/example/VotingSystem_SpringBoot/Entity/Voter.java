package com.example.VotingSystem_SpringBoot.Entity;


import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Voter {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@NotBlank(message = "Name Cannot be Blank")
	@Pattern(regexp = "^a-zA-z+$", message = "only character is allowed")
	@Size(min = 2, max = 10, message = "Name should have 2 to 10 characters")
	private String VoterName;
	private Date DOB;
	private String gender;
	private String username;
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVoterName() {
		return VoterName;
	}
	public void setVoterName(String voterName) {
		VoterName = voterName;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Voter [id=" + id + ", VoterName=" + VoterName + ", DOB=" + DOB + ", gender=" + gender + ", username="
				+ username + ", password=" + password + "]";
	}
	public Voter() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Voter(int id,
			@NotBlank(message = "Name Cannot be Blank") @Pattern(regexp = "^a-zA-z+$", message = "only character is allowed") @Size(min = 2, max = 10, message = "Name should have 2 to 10 characters") String voterName,
			Date dOB, String gender, String username, String password) {
		super();
		this.id = id;
		VoterName = voterName;
		DOB = dOB;
		this.gender = gender;
		this.username = username;
		this.password = password;
	}
	
	
}