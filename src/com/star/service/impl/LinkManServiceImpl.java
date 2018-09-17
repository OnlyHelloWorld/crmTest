package com.star.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.star.dao.ILinkManDAO;
import com.star.domain.LinkMan;
import com.star.service.ILinkManService;
import com.star.utils.PageBean;

public class LinkManServiceImpl implements ILinkManService{

	private ILinkManDAO linkManDAO;

	public void setLinkManDAO(ILinkManDAO linkManDAO) {
		this.linkManDAO = linkManDAO;
	}

	@Override
	public PageBean getPageBean(DetachedCriteria detachedCriteria, Integer currentPage, Integer pageSize) {
		
		//调用dao查询总记录数
		Integer totalCount = linkManDAO.getTotalCount(detachedCriteria);
		//创建PageBean对象
		PageBean pageBean = new PageBean(currentPage, totalCount, pageSize);
		//调用DAO查询分页数据
		List<LinkMan> list = linkManDAO.getPageList(detachedCriteria,pageBean.getStart(),pageBean.getPageSize());
		//将数据放入PageBean中,并返回
		pageBean.setList(list);
		
		return pageBean;
	}
	@Override
	public void save(LinkMan linkMan) {
		//维护customer与数据字典之间的关系(jsp和struts2已经封装好了)
		
		//调用DAO保存客户
		linkManDAO.saveOrUpdate(linkMan);
	}

	@Override
	public LinkMan getById(Long lkm_id) {
		// TODO Auto-generated method stub
		return linkManDAO.getById(lkm_id);
	}

	
	public void setCustomerDAO(ILinkManDAO linkManDAO) {
		this.linkManDAO = linkManDAO;
	}



}
