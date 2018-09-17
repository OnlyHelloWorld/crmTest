package com.star.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.star.dao.ICustomerDAO;
import com.star.domain.Customer;
import com.star.service.ICustomerService;
import com.star.utils.PageBean;

public class CustomerServiceImpl implements ICustomerService{
	
	private ICustomerDAO customerDAO;

	@Override
	public PageBean getPageBean(DetachedCriteria detachedCriteria, Integer currentPage, Integer pageSize) {
		
		//����dao��ѯ�ܼ�¼��
		Integer totalCount = customerDAO.getTotalCount(detachedCriteria);
		//����PageBean����
		PageBean pageBean = new PageBean(currentPage, totalCount, pageSize);
		//����DAO��ѯ��ҳ����
		List<Customer> list = customerDAO.getPageList(detachedCriteria,pageBean.getStart(),pageBean.getPageSize());
		//�����ݷ���PageBean��,������
		pageBean.setList(list);
		
		return pageBean;
	}

	public void setCustomerDAO(ICustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@Override
	public void save(Customer customer) {
		//ά��customer�������ֵ�֮��Ĺ�ϵ(jsp��struts2�Ѿ���װ����)
		
		//����DAO����ͻ�
		customerDAO.saveOrUpdate(customer);
	}

	@Override
	public Customer getById(Long cust_id) {
		//����DAO
		return customerDAO.getById(cust_id);
	}

	@Override
	public List<Object[]> getIndustryCount() {
		
		return customerDAO.getIndustryCount();
	}


}