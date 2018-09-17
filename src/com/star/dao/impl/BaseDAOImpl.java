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
	
	//��ȡ����ʱ�ڵķ�������
	private Class clazz;
	

	public BaseDAOImpl() {
		//��ȡ��ǰ���͵Ĵ��з������͵ĸ���
		//ע��������ʱ�ڵĸ���,����һ��(����ʲ���)����ĸ���
		ParameterizedType ptClass = (ParameterizedType) this.getClass().getGenericSuperclass();
		//�������ʱ�ڵķ�������
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
		 * ͨ�����һ������Ϊʲô��ȡ�����ٽ���ɾ������
		 * ������Ϊ��Hibernate�н������Ϊ�ü���״̬:�־�̬,����̬,ɾ��̬��(�õȾ��Ǹ�ǲ�����)
		 * ɾ���������ǰѳ־û�����ת������뻹��ɶ��������
		 * ������Ҫ�ڶ���־û�״̬ʱ����ɾ��
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
		//���ò�ѯ�ľۺϺ���,�ܼ�¼��(�Ժ������ϸ����)
		dc.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(dc);
		//���֮ǰ��ƵľۺϺ���
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
