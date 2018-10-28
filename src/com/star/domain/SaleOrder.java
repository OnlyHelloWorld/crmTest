package com.star.domain;

import java.text.SimpleDateFormat;
import java.util.Date;


public class SaleOrder {

	/**CREATE TABLE `sale_order` (
			  `order_id` bigint(20) NOT NULL AUTO_INCREMENT,
			  `order_linkman` varchar(255) DEFAULT NULL,
			  `order_time` datetime DEFAULT NULL,
			  `order_nexttime` datetime DEFAULT NULL,
			  `order_supplier_id` bigint(20) DEFAULT NULL,
			  `order_user_id` bigint(20) DEFAULT NULL,
			  `order_addr` varchar(255) DEFAULT NULL,
			  `order_detail` varchar(255) DEFAULT NULL,
			  PRIMARY KEY (`order_id`),
			  KEY `FKgr4aivocixwcvkwxcmc0b4css` (`order_supplier_id`),
			  KEY `FKc92iepd26mixxfiris92hccjx` (`order_user_id`),
			  CONSTRAINT `FKc92iepd26mixxfiris92hccjx` FOREIGN KEY (`order_user_id`) REFERENCES `sys_user` (`user_id`),
			  CONSTRAINT `FKgr4aivocixwcvkwxcmc0b4css` FOREIGN KEY (`order_supplier_id`) REFERENCES `supplier` (`supplier_id`)
			) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
	*/
	//根据sql文件
	private Long order_id;
	private String order_linkman;
	private String order_addr;
	private String order_detail;
	private Date order_time;
	private Date order_nexttime;
	//one2many
	private Supplier order_supplier_id;
	private User order_user_id;
	
	
	
	
	public Long getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}
	public String getOrder_linkman() {
		return order_linkman;
	}
	public void setOrder_linkman(String order_linkman) {
		this.order_linkman = order_linkman;
	}
	public String getOrder_addr() {
		return order_addr;
	}
	public void setOrder_addr(String order_addr) {
		this.order_addr = order_addr;
	}
	public String getOrder_detail() {
		return order_detail;
	}
	public void setOrder_detail(String order_detail) {
		this.order_detail = order_detail;
	}
	public Date getOrder_time() {
		return order_time;
	}
	public void setOrder_time(Date order_time) {
		this.order_time = order_time;
	}
	public Date getOrder_nexttime() {
		return order_nexttime;
	}
	public void setOrder_nexttime(Date order_nexttime) {
		this.order_nexttime = order_nexttime;
	}
	public Supplier getOrder_supplier_id() {
		return order_supplier_id;
	}
	public void setOrder_supplier_id(Supplier order_supplier_id) {
		this.order_supplier_id = order_supplier_id;
	}
	public User getOrder_user_id() {
		return order_user_id;
	}
	public void setOrder_user_id(User order_user_id) {
		this.order_user_id = order_user_id;
	}
	//===============================
	public String getOrder_time_s() {
		return transferDate(order_time, "yyyy-MM-dd");
	}
	public String getOrder_nexttime_s() {
		return transferDate(order_nexttime, "yyyy-MM-dd");
	}
	public static String transferDate(Date date,String format) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		return simpleDateFormat.format(date);
	}
	//================================
	@Override
	public String toString() {
		return "SaleOrder [order_id=" + order_id + ", order_linkman=" + order_linkman + ", order_addr=" + order_addr
				+ ", order_detail=" + order_detail + ", order_time=" + order_time + ", order_nexttime=" + order_nexttime
				+ ", order_supplier_id=" + order_supplier_id + ", order_user_id=" + order_user_id + "]";
	}
	
	
	
	
}
