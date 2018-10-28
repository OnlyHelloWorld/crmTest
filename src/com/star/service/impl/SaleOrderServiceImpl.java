package com.star.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.star.dao.ISaleOrderDAO;
import com.star.domain.SaleOrder;
import com.star.service.ISaleOrderService;
import com.star.utils.PageBean;

public class SaleOrderServiceImpl implements ISaleOrderService {

	private ISaleOrderDAO saleOrderDAO;
	
	public void setSaleOrderDAO(ISaleOrderDAO saleOrderDAO) {
		this.saleOrderDAO = saleOrderDAO;
	}

	@Override
	public PageBean getPageBean(DetachedCriteria detachedCriteria, Integer currentPage, Integer pageSize) {
		
		//调用DAO查询总记录数
		Integer totalCount = saleOrderDAO.getTotalCount(detachedCriteria);
		//创建PageBean对象
		PageBean pageBean = new PageBean(currentPage, totalCount, pageSize);
		//调用DAO查询分页数据
		List<SaleOrder> list = saleOrderDAO.getPageList(detachedCriteria,pageBean.getStart(),pageBean.getPageSize());
		//将数据放入PageBean中并返回
		pageBean.setList(list);
		
		return pageBean;
	}
	
	@Override
	public void save(SaleOrder saleOrder) {
		saleOrderDAO.saveOrUpdate(saleOrder);
	}

	@Override
	public SaleOrder getById(Long order_id) {
		// TODO Auto-generated method stub
		return saleOrderDAO.getById(order_id);
	}

	@Override
	public void deleteItem(Long order_id) {
		// TODO Auto-generated method stub
		saleOrderDAO.deleteById(order_id);
	}

	

}
