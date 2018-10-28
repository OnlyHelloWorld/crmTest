package com.star.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.star.domain.Supplier;

public interface ISupplierDAO extends IBaseDAO<Supplier>{

	List<Object[]> getIndustryCount();

}
