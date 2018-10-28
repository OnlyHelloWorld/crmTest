package com.star.service;

import org.hibernate.criterion.DetachedCriteria;

import com.star.domain.SaleOrder;
import com.star.utils.PageBean;

public interface ISaleOrderService {

	void save(SaleOrder saleOrder);

	PageBean getPageBean(DetachedCriteria detachedCriteria, Integer currentPage, Integer pageSize);

	SaleOrder getById(Long order_id);

	void deleteItem(Long order_id);

}
