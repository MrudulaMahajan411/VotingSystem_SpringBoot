package com.example.VotingSystem_SpringBoot.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.VotingSystem_SpringBoot.Entity.Election_Updates;
import com.example.VotingSystem_SpringBoot.Repositories.NoticeRepository;


@Service
public class NoticeServicImpl implements NoticeServices {

	@Autowired
	NoticeRepository noticeRepository;

		@Override
		public void SaveNotice(Election_Updates election_Updates) {
			noticeRepository.save(election_Updates);

		}

		@Override
		public List<Election_Updates> getAllNotices() {
			return	noticeRepository.findAll();
		}
		@Override
		public Election_Updates findById(int Id) {
			Optional<Election_Updates> findById = noticeRepository.findById(Id);
			Election_Updates election_Updates = findById.get();
			return election_Updates;

		}

}
