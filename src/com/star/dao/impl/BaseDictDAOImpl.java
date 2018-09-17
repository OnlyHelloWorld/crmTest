package com.star.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.star.dao.IBaseDictDAO;
import com.star.domain.BaseDict;

public class BaseDictDAOImpl extends BaseDAOImpl<BaseDict> implements IBaseDictDAO {

	@Override
	public List<BaseDict> getListByTypeCode(String dict_type_code) {
		//�������߲�ѯ����

		DetachedCriteria dc = DetachedCriteria.forClass(BaseDict.class);
		//��װ��ѯ����
		dc.add(Restrictions.eq("dict_type_code", dict_type_code));
		//ִ�в�ѯ
		List<BaseDict> list = (List<BaseDict>) getHibernateTemplate().findByCriteria(dc);
		return list;
	}

}
