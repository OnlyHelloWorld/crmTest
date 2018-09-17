package com.star.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.star.dao.IBaseDictDAO;
import com.star.domain.BaseDict;

public class BaseDictDAOImpl extends BaseDAOImpl<BaseDict> implements IBaseDictDAO {

	@Override
	public List<BaseDict> getListByTypeCode(String dict_type_code) {
		//创建离线查询对象

		DetachedCriteria dc = DetachedCriteria.forClass(BaseDict.class);
		//封装查询条件
		dc.add(Restrictions.eq("dict_type_code", dict_type_code));
		//执行查询
		List<BaseDict> list = (List<BaseDict>) getHibernateTemplate().findByCriteria(dc);
		return list;
	}

}
