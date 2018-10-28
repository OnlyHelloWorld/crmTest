package com.star.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface IBaseDAO<T> {

	//更新
	void saveOrUpdate(T t);
	//增
	void save(T t);
	//删 根据对象删
	void deleteByObject(T t);
	//删 根据id删
	void deleteById(Serializable id);
	//改
	void update(T t);
	//查 根据id查    难度:掉头屑 *
	T getById(Serializable id);
	//查查查 快难死了 查个毛线   难度:掉头发 ***
	Integer getTotalCount(DetachedCriteria dc);
	//继续查 难死你通哥了 你大爷的 分页查询 难度:掉头 ***** 
	List<T> getPageList(DetachedCriteria dc,Integer start,Integer pageSize);
}
