package com.star.service;

import org.hibernate.criterion.DetachedCriteria;

import com.star.domain.User;
import com.star.utils.PageBean;

public interface IUserService {

	User getUserByCodePassword(User u);
	void saveUser(User u);
	User getById(Long user_id);
	void save(User user);
	PageBean getPageBean(DetachedCriteria detachedCriteria, Integer currentPage, Integer pageSize);
}
