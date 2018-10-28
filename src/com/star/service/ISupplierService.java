package com.star.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.star.domain.Supplier;
import com.star.utils.PageBean;

public interface ISupplierService {


	PageBean getPageBean(DetachedCriteria detachedCriteria, Integer currentPage, Integer pageSize);

	void save(Supplier supplier);

	Supplier getById(Long supplier_id);


	void deleteItem(Long supplier_id);

	List<Object[]> getIndustryCount();

	

}
