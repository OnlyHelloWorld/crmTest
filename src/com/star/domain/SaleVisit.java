package com.star.domain;

import java.text.SimpleDateFormat;
import java.util.Date;


public class SaleVisit {

	/**
	 * `visit_id` bigint(32) NOT NULL,
  `visit_cust_id` bigint(32) DEFAULT NULL COMMENT '�ͻ�id',
  `visit_user_id` bigint(32) DEFAULT NULL COMMENT '������id',
  `visit_time` date DEFAULT NULL COMMENT '�ݷ�ʱ��',
  `visit_interviewee` varchar(32) DEFAULT NULL COMMENT '���ݷ���',
  `visit_addr` varchar(128) DEFAULT NULL COMMENT '�ݷõص�',
  `visit_detail` varchar(256) DEFAULT NULL COMMENT '�ݷ�����',
  `visit_nexttime` date DEFAULT NULL COMMENT '�´ΰݷ�ʱ��',
	 */
	//����sql���дʵ������
	private Long visit_id;
	private String visit_interviewee;
	private String visit_addr;
	private String visit_detail;
	private Date visit_time;
	private Date visit_nexttime;
	//�������ʵ��(��Ϊone2many)
	private Customer customer;
	private User user;
	
	
	public Long getVisit_id() {
		return visit_id;
	}
	public void setVisit_id(Long visit_id) {
		this.visit_id = visit_id;
	}
	public String getVisit_interviewee() {
		return visit_interviewee;
	}
	public void setVisit_interviewee(String visit_interviewee) {
		this.visit_interviewee = visit_interviewee;
	}
	public String getVisit_addr() {
		return visit_addr;
	}
	public void setVisit_addr(String visit_addr) {
		this.visit_addr = visit_addr;
	}
	public String getVisit_detail() {
		return visit_detail;
	}
	public void setVisit_detail(String visit_detail) {
		this.visit_detail = visit_detail;
	}
	public Date getVisit_time() {
		return visit_time;
	}
	public Date getVisit_nexttime() {
		return visit_nexttime;
	}
	//===============================
	public String getVisit_time_s() {
		return transferDate(visit_time, "yyyy-MM-dd");
	}
	public String getVisit_nexttime_s() {
		return transferDate(visit_nexttime, "yyyy-MM-dd");
	}
	public static String transferDate(Date date,String format) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		return simpleDateFormat.format(date);
	}
	//================================
	public void setVisit_time(Date visit_time) {
		this.visit_time = visit_time;
	}
	public void setVisit_nexttime(Date visit_nexttime) {
		this.visit_nexttime = visit_nexttime;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "SaleVisit [visit_id=" + visit_id + ", visit_interviewee=" + visit_interviewee + ", visit_addr="
				+ visit_addr + ", visit_detail=" + visit_detail + ", visit_time=" + visit_time + ", visit_nexttime="
				+ visit_nexttime + ", customer=" + customer + ", user=" + user + "]";
	}
	
	
	
}