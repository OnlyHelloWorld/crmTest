package com.star.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.star.dao.ISaleVisitDAO;
import com.star.domain.SaleVisit;
import com.star.service.ISaleVisitService;
import com.star.utils.PageBean;

public class SaleVisitServiceImpl implements ISaleVisitService {

	private ISaleVisitDAO saleVisitDAO;
	
	public void setSaleVisitDAO(ISaleVisitDAO saleVisitDAO) {
		this.saleVisitDAO = saleVisitDAO;
	}

	@Override
	public PageBean getPageBean(DetachedCriteria detachedCriteria, Integer currentPage, Integer pageSize) {
		
		//调用dao查询总记录数
		Integer totalCount = saleVisitDAO.getTotalCount(detachedCriteria);
		//创建PageBean对象
		PageBean pageBean = new PageBean(currentPage, totalCount, pageSize);
		//调用DAO查询分页数据
		List<SaleVisit> list = saleVisitDAO.getPageList(detachedCriteria,pageBean.getStart(),pageBean.getPageSize());
		//将数据放入PageBean中,并返回
		pageBean.setList(list);
		
		return pageBean;
	}
	
	@Override
	public void save(SaleVisit saleVisit) {
		saleVisitDAO.saveOrUpdate(saleVisit);
	}

	@Override
	public SaleVisit getById(Long visit_id) {
		// TODO Auto-generated method stub
		return saleVisitDAO.getById(visit_id);
	}

	

}
