package com.example.VotingSystem_SpringBoot.Entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Election_Updates {
	@Id
	private int Id;
	private String noticesender;
	private Date noticedate;
	private String notice;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getNoticesender() {
		return noticesender;
	}
	public void setNoticesender(String noticesender) {
		this.noticesender = noticesender;
	}
	public Date getNoticedate() {
		return noticedate;
	}
	public void setNoticedate(Date noticedate) {
		this.noticedate = noticedate;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	@Override
	public String toString() {
		return "Election_Updates [Id=" + Id + ", noticesender=" + noticesender + ", noticedate=" + noticedate
				+ ", notice=" + notice + "]";
	}
	public Election_Updates(int id, String noticesender, Date noticedate, String notice) {
		super();
		Id = id;
		this.noticesender = noticesender;
		this.noticedate = noticedate;
		this.notice = notice;
	}
	public Election_Updates() {
		super();
		// TODO Auto-generated constructor stub
	}
}