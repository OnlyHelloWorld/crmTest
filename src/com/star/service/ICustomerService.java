package com.star.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.star.domain.Customer;
import com.star.utils.PageBean;

public interface ICustomerService {


	PageBean getPageBean(DetachedCriteria detachedCriteria, Integer currentPage, Integer pageSize);

	void save(Customer customer);

	Customer getById(Long cust_id);

	List<Object[]> getIndustryCount();

	

}
