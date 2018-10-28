package com.star.domain;

public class Supplier {
	/**
			 * CREATE TABLE `supplier` (
		  `supplier_id` bigint(20) NOT NULL AUTO_INCREMENT,
		  `supplier_name` varchar(255) DEFAULT NULL,
		  `supplier_source` varchar(255) DEFAULT NULL,
		  `supplier_industry` varchar(255) DEFAULT NULL,
		  `supplier_level` varchar(255) DEFAULT NULL,
		  `supplier_linkman` varchar(255) DEFAULT NULL,
		  `supplier_phone` varchar(255) DEFAULT NULL,
		  `supplier_mobile` varchar(255) DEFAULT NULL,
		  PRIMARY KEY (`supplier_id`),
		  KEY `FKeh5g36duab8g1h051pdjfwcgd` (`supplier_source`),
		  KEY `FK2xhr3arwp3tkuae1da4lqv352` (`supplier_industry`),
		  KEY `FKrty52nvbjg1echf0se39eng49` (`supplier_level`),
		  CONSTRAINT `FK2xhr3arwp3tkuae1da4lqv352` FOREIGN KEY (`supplier_industry`) REFERENCES `base_dict` (`dict_id`),
		  CONSTRAINT `FKeh5g36duab8g1h051pdjfwcgd` FOREIGN KEY (`supplier_source`) REFERENCES `base_dict` (`dict_id`),
		  CONSTRAINT `FKrty52nvbjg1echf0se39eng49` FOREIGN KEY (`supplier_level`) REFERENCES `base_dict` (`dict_id`)
		) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
	 */
	private Long supplier_id;
	
	private String supplier_name;
//	private String cust_source;
//	private String cust_industry;
//	private String cust_level;
	private String supplier_linkman;
	private String supplier_phone;
	private String supplier_mobile;
	
	private BaseDict supplier_source;
	private BaseDict supplier_industry;
	private BaseDict supplier_level;
	public Long getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(Long supplier_id) {
		this.supplier_id = supplier_id;
	}
	public String getSupplier_name() {
		return supplier_name;
	}
	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}
	public String getSupplier_linkman() {
		return supplier_linkman;
	}
	public void setSupplier_linkman(String supplier_linkman) {
		this.supplier_linkman = supplier_linkman;
	}
	public String getSupplier_phone() {
		return supplier_phone;
	}
	public void setSupplier_phone(String supplier_phone) {
		this.supplier_phone = supplier_phone;
	}
	public String getSupplier_mobile() {
		return supplier_mobile;
	}
	public void setSupplier_mobile(String supplier_mobile) {
		this.supplier_mobile = supplier_mobile;
	}
	public BaseDict getSupplier_source() {
		return supplier_source;
	}
	public void setSupplier_source(BaseDict supplier_source) {
		this.supplier_source = supplier_source;
	}
	public BaseDict getSupplier_industry() {
		return supplier_industry;
	}
	public void setSupplier_industry(BaseDict supplier_industry) {
		this.supplier_industry = supplier_industry;
	}
	public BaseDict getSupplier_level() {
		return supplier_level;
	}
	public void setSupplier_level(BaseDict supplier_level) {
		this.supplier_level = supplier_level;
	}
	@Override
	public String toString() {
		return "Supplier [supplier_id=" + supplier_id + ", supplier_name=" + supplier_name + ", supplier_linkman="
				+ supplier_linkman + ", supplier_phone=" + supplier_phone + ", supplier_mobile=" + supplier_mobile
				+ ", supplier_source=" + supplier_source + ", supplier_industry=" + supplier_industry
				+ ", supplier_level=" + supplier_level + "]";
	}
	
	

}
