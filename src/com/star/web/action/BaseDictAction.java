package com.star.web.action;

import java.util.List;

import org.apache.logging.log4j.core.config.json.JsonConfiguration;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import com.star.domain.BaseDict;
import com.star.service.IBaseDictService;
import net.sf.json.JSONArray;

public class BaseDictAction extends ActionSupport {

	private String dict_type_code;
	
	private IBaseDictService baseDictService;
	@Override
	public String execute() throws Exception {
		//1 ����Service����typecode��������ֵ����list
		List<BaseDict> list = baseDictService.getListByTypeCode(dict_type_code);
		//2 ��listת��Ϊ json��ʽ
		String json = JSONArray.fromObject(list).toString();
		//3 ��json���͸������
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		return null;//����struts2����Ҫ���н������
	}
	
	public String getDict_type_code() {
		return dict_type_code;
	}
	public void setDict_type_code(String dict_type_code) {
		this.dict_type_code = dict_type_code;
	}

	public void setBaseDictService(IBaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}
		
	
	
}
