package com.star.service;

import org.hibernate.criterion.DetachedCriteria;

import com.star.domain.LinkMan;
import com.star.utils.PageBean;

public interface ILinkManService {

	PageBean getPageBean(DetachedCriteria detachedCriteria, Integer currentPage, Integer pageSize);

	void save(LinkMan linkMan);

	LinkMan getById(Long lkm_id);

	void deleteItem(Long lkm_id);

}
