package com.star.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface IBaseDAO<T> {

	//����
	void saveOrUpdate(T t);
	//��
	void save(T t);
	//ɾ ���ݶ���ɾ
	void deleteByObject(T t);
	//ɾ ����idɾ
	void deleteById(Serializable id);
	//��
	void update(T t);
	//�� ����id��    �Ѷ�:��ͷм *
	T getById(Serializable id);
	//���� �������� ���ë��   �Ѷ�:��ͷ�� ***
	Integer getTotalCount(DetachedCriteria dc);
	//������ ������ͨ���� ���ү�� ��ҳ��ѯ �Ѷ�:��ͷ ***** 
	List<T> getPageList(DetachedCriteria dc,Integer start,Integer pageSize);
}
