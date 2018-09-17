package com.star.service.impl;

import com.star.dao.IUserDAO;
import com.star.domain.User;
import com.star.service.IUserService;
import com.star.utils.MD5Utils;

public class UserServiceImpl implements IUserService{

	
	private IUserDAO userDAO;

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
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
		if (!existUser.getUser_password().equals(MD5Utils.md5(u.getUser_password()))) {
			throw new RuntimeException("�û��������������");
		}
		//���ز�ѯ�����û�����

		return existUser;
	}

	@Override
	public void saveUser(User u) {
		//��ȡ�û�
		User user = userDAO.getByUserCode(u.getUser_code());
		//user!=null �쳣
		if (user != null) {
			throw new RuntimeException("�û����Ѿ���ע��!");
		}
		u.setUser_password(MD5Utils.md5(u.getUser_password()));
		//User== null ����
		userDAO.save(u);
		
	}


}
