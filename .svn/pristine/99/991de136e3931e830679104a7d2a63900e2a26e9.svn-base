package com.star.service.impl;

import java.util.List;

import com.star.dao.IBaseDictDAO;
import com.star.domain.BaseDict;
import com.star.service.IBaseDictService;

public class BaseDictServiceImpl implements IBaseDictService {
	
	private IBaseDictDAO baseDictDAO;

	@Override
	public List<BaseDict> getListByTypeCode(String dict_type_code) {
		return baseDictDAO.getListByTypeCode(dict_type_code);
	}
	
	public void setBaseDictDAO(IBaseDictDAO baseDictDAO) {
		this.baseDictDAO = baseDictDAO;
	}
}
