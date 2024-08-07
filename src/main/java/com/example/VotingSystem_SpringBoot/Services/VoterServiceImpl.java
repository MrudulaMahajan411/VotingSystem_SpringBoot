package com.example.VotingSystem_SpringBoot.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.VotingSystem_SpringBoot.Entity.Voter;
import com.example.VotingSystem_SpringBoot.Repositories.VoterRepository;

@Service
public class VoterServiceImpl implements VoterService {
	@Autowired
	VoterRepository voterrepo;

		@Override
		public Voter saveVoter(Voter voter) {
			// TODO Auto-generated method stub
			return voterrepo.save(voter);
		}

		@Override
		public List<Voter> voterlist() {
			List<Voter>find=voterrepo.findAll();
			return find;
		}

		@Override
		public void deleteById(int id) {
			voterrepo.deleteById(id);
			
		}

		@Override
		public Voter findById(int id) {
			Optional<Voter> findById = voterrepo.findById(id);
			Voter voter = findById.get();
			return voter;

		}

		@Override
		public Voter updateVoter(Voter voter,int id) {
			Optional<Voter> voterdatab = voterrepo.findById(id);
			if(voterdatab.isPresent()) {
				Voter newVoter=voterdatab.get();
				newVoter.setUsername(voter.getUsername());
				newVoter.setDOB(voter.getDOB());
				newVoter.setGender(voter.getGender());
				newVoter.setUsername(voter.getUsername());
				newVoter.setPassword(voter.getPassword());
				voterrepo.save(newVoter);
				return newVoter;
			}
			return null;
	
		}

		 public Voter findVoterByUsernameAndPassword(String username, String password) {
		        return voterrepo.findByUsernameAndPassword(username, password);
		    }

		    @Override
		    public void updateVoter(Voter voter) {
		        voterrepo.save(voter);
		    }

	

	}


