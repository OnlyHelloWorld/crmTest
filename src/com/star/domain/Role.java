package com.star.domain;

public class Role {

	/*
	 * CREATE TABLE `sys_role` (
	  `role_id` bigint(32) NOT NULL AUTO_INCREMENT,
	  `role_name` varchar(32) NOT NULL COMMENT '½ÇÉ«Ãû³Æ',
	  `role_memo` varchar(128) DEFAULT NULL COMMENT '±¸×¢',
	  PRIMARY KEY (`role_id`)
		) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
	 */
	
	private Long role_id;
	private String role_name;
	private String role_memo;
	
	public Long getRole_id() {
		return role_id;
	}

	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getRole_memo() {
		return role_memo;
	}

	public void setRole_memo(String role_memo) {
		this.role_memo = role_memo;
	}

	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", role_name=" + role_name + ", role_memo=" + role_memo + "]";
	}
	
	
}
