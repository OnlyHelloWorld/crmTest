package com.star.service;

import org.hibernate.criterion.DetachedCriteria;

import com.star.domain.SaleVisit;
import com.star.utils.PageBean;

public interface ISaleVisitService {

	void save(SaleVisit saleVisit);

	PageBean getPageBean(DetachedCriteria detachedCriteria, Integer currentPage, Integer pageSize);

	SaleVisit getById(Long visit_id);

}
