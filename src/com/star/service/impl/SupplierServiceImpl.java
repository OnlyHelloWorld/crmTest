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
		
		//����dao��ѯ�ܼ�¼��
		Integer totalCount = supplierDAO.getTotalCount(detachedCriteria);
		//����PageBean����
		PageBean pageBean = new PageBean(currentPage, totalCount, pageSize);
		//����DAO��ѯ��ҳ����
		List<Supplier> list = supplierDAO.getPageList(detachedCriteria,pageBean.getStart(),pageBean.getPageSize());
		//�����ݷ���PageBean��,������
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
		//ά��customer�������ֵ�֮��Ĺ�ϵ(jsp��struts2�Ѿ���װ����)
		
		//����DAO����ͻ�
		supplierDAO.saveOrUpdate(supplier);
	}

	@Override
	public Supplier getById(Long supplier_id) {
		//����DAO
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
