package com.star.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.opensymphony.xwork2.ActionContext;
import com.star.dao.IUserDAO;
import com.star.domain.Supplier;
import com.star.domain.User;
import com.star.service.IUserService;
import com.star.utils.MD5Utils;
import com.star.utils.PageBean;

public class UserServiceImpl implements IUserService{

	
	private IUserDAO userDAO;

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public User getById(Long user_id) {
		// TODO Auto-generated method stub
		return userDAO.getById(user_id);
	}



	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		userDAO.saveOrUpdate(user);
	}



	@Override
	public PageBean getPageBean(DetachedCriteria detachedCriteria, Integer currentPage, Integer pageSize) {
		//����dao��ѯ�ܼ�¼��
		Integer totalCount = userDAO.getTotalCount(detachedCriteria);
		//����PageBean����
		PageBean pageBean = new PageBean(currentPage, totalCount, pageSize);
		//����DAO��ѯ��ҳ����
		List<User> list = userDAO.getPageList(detachedCriteria,pageBean.getStart(),pageBean.getPageSize());
		//�����ݷ���PageBean��,������
		pageBean.setList(list);
		
		return pageBean;
	}

	
	@Override
	public User getUserByCodePassword(User u) {
		//�����û�����ѯ��¼�û�
		User existUser = userDAO.getByUserCode(u.getUser_code());
		//�ж��û��Ƿ����,������,�׳��쳣,��ʾ�û�
		if (existUser == null) {
			throw new RuntimeException("�û���������");
		}
		//�ж�����,����ȷ,�׳��쳣,��ʾ�û�
		if(!existUser.getUser_password().equals(MD5Utils.md5(u.getUser_password()))){
			throw new RuntimeException("�������!");
		}
		//���ز�ѯ�����û�����

		return existUser;
	}

	@Override
	public void saveUser(User u) {
		//1 ����Dao����ע��ĵ�½������û�����
		User existU = userDAO.getByUserCode(u.getUser_code());
		if(existU!=null){
			//2 �����õ�user����,�û����Ѿ�����,�׳��쳣
			throw new RuntimeException("�û����Ѿ�����!");
		}
		//ʹ��MD5��������м���
		u.setUser_password(MD5Utils.md5(u.getUser_password()));
		//3 ����Daoִ�б���
		userDAO.save(u);
		
	}



	

}
