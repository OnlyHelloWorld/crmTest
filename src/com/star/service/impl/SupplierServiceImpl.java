package com.star.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.star.dao.ISupplierDAO;
import com.star.domain.Supplier;
import com.star.service.ISupplierService;
import com.star.utils.PageBean;

public class SupplierServiceImpl implements ISupplierService{
	
	private ISupplierDAO supplierDAO;

	@Override
	public PageBean getPageBean(DetachedCriteria detachedCriteria, Integer currentPage, Integer pageSize) {
		
		//调用dao查询总记录数
		Integer totalCount = supplierDAO.getTotalCount(detachedCriteria);
		//创建PageBean对象
		PageBean pageBean = new PageBean(currentPage, totalCount, pageSize);
		//调用DAO查询分页数据
		List<Supplier> list = supplierDAO.getPageList(detachedCriteria,pageBean.getStart(),pageBean.getPageSize());
		//将数据放入PageBean中,并返回
		pageBean.setList(list);
		
		return pageBean;
	}

	

	public ISupplierDAO getSupplierDAO() {
		return supplierDAO;
	}



	public void setSupplierDAO(ISupplierDAO supplierDAO) {
		this.supplierDAO = supplierDAO;
	}



	@Override
	public void save(Supplier supplier) {
		//维护customer与数据字典之间的关系(jsp和struts2已经封装好了)
		
		//调用DAO保存客户
		supplierDAO.saveOrUpdate(supplier);
	}

	@Override
	public Supplier getById(Long supplier_id) {
		//调用DAO
		return supplierDAO.getById(supplier_id);
	}



	@Override
	public void deleteItem(Long supplier_id) {
		// TODO Auto-generated method stub
		supplierDAO.deleteById(supplier_id);
	}



	@Override
	public List<Object[]> getIndustryCount() {
		// TODO Auto-generated method stub
		return supplierDAO.getIndustryCount();
	}


}
