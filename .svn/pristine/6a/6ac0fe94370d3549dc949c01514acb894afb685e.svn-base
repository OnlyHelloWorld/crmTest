package com.star.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.star.dao.IBaseDAO;
import com.star.domain.Customer;

public class BaseDAOImpl<T> extends HibernateDaoSupport implements IBaseDAO<T>{
	
	//获取运行时期的泛型类型
	private Class clazz;
	

	public BaseDAOImpl() {
		//获取当前类型的带有泛型类型的父类
		//注意是运行时期的父类,并不一定(大概率不是)该类的父类
		ParameterizedType ptClass = (ParameterizedType) this.getClass().getGenericSuperclass();
		//获得运行时期的泛型类型
		clazz = (Class) ptClass.getActualTypeArguments()[0];
	}

	@Override
	public void save(T t) {

		getHibernateTemplate().save(t);
	}

	@Override
	public void deleteByObject(T t) {
		getHibernateTemplate().delete(t);
	}

	@Override
	public void deleteById(Serializable id) {
		/**
		 * 通哥解释一下这里为什么先取出来再进行删除操作
		 * 这是因为再Hibernate中将对象分为好几种状态:持久态,游离态,删除态等(用等就是哥记不清了)
		 * 删除操作就是把持久化对象转变成游离还是啥来着忘了
		 * 就是需要在对象持久化状态时进行删除
		 */
		T t = this.getById(id);
		getHibernateTemplate().delete(t);
		
	}

	@Override
	public void update(T t) {

		getHibernateTemplate().update(t);
	}

	@Override
	public T getById(Serializable id) {
		
		return (T) getHibernateTemplate().get(clazz, id);
	}

	@Override
	public Integer getTotalCount(DetachedCriteria dc) {
		//设置查询的聚合函数,总记录数(稍后添加详细解释)
		dc.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(dc);
		//清空之前设计的聚合函数
		dc.setProjection(null);
		if (list != null && list.size() > 0) {
			Long count = list.get(0);
			return count.intValue();
		}else {
		    return null;
		}

	}

	@Override
	public List<T> getPageList(DetachedCriteria dc, Integer start, Integer pageSize) {
		List<T> list = (List<T>) getHibernateTemplate().findByCriteria(dc, start, pageSize);
		return list;
	}

	@Override
	public void saveOrUpdate(T t) {
		getHibernateTemplate().saveOrUpdate(t);
		
	}

}
