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
		
		//����dao��ѯ�ܼ�¼��
		Integer totalCount = saleVisitDAO.getTotalCount(detachedCriteria);
		//����PageBean����
		PageBean pageBean = new PageBean(currentPage, totalCount, pageSize);
		//����DAO��ѯ��ҳ����
		List<SaleVisit> list = saleVisitDAO.getPageList(detachedCriteria,pageBean.getStart(),pageBean.getPageSize());
		//�����ݷ���PageBean��,������
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
