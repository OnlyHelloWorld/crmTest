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
		
		//����dao��ѯ�ܼ�¼��
		Integer totalCount = linkManDAO.getTotalCount(detachedCriteria);
		//����PageBean����
		PageBean pageBean = new PageBean(currentPage, totalCount, pageSize);
		//����DAO��ѯ��ҳ����
		List<LinkMan> list = linkManDAO.getPageList(detachedCriteria,pageBean.getStart(),pageBean.getPageSize());
		//�����ݷ���PageBean��,������
		pageBean.setList(list);
		
		return pageBean;
	}
	@Override
	public void save(LinkMan linkMan) {
		//ά��customer�������ֵ�֮��Ĺ�ϵ(jsp��struts2�Ѿ���װ����)
		
		//����DAO����ͻ�
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
