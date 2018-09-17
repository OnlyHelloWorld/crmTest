package com.star.service;

import java.util.List;

import com.star.domain.BaseDict;

public interface IBaseDictService {

	List<BaseDict> getListByTypeCode(String dict_type_code);

}
