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
		//调用dao查询总记录数
		Integer totalCount = userDAO.getTotalCount(detachedCriteria);
		//创建PageBean对象
		PageBean pageBean = new PageBean(currentPage, totalCount, pageSize);
		//调用DAO查询分页数据
		List<User> list = userDAO.getPageList(detachedCriteria,pageBean.getStart(),pageBean.getPageSize());
		//将数据放入PageBean中,并返回
		pageBean.setList(list);
		
		return pageBean;
	}

	
	@Override
	public User getUserByCodePassword(User u) {
		//根据用户名查询登录用户
		User existUser = userDAO.getByUserCode(u.getUser_code());
		//判断用户是否存在,不存在,抛出异常,提示用户
		if (existUser == null) {
			throw new RuntimeException("用户名不存在");
		}
		//判断密码,不正确,抛出异常,提示用户
		if(!existUser.getUser_password().equals(MD5Utils.md5(u.getUser_password()))){
			throw new RuntimeException("密码错误!");
		}
		//返回查询到的用户对象

		return existUser;
	}

	@Override
	public void saveUser(User u) {
		//1 调用Dao根据注册的登陆名获得用户对象
		User existU = userDAO.getByUserCode(u.getUser_code());
		if(existU!=null){
			//2 如果获得到user对象,用户名已经存在,抛出异常
			throw new RuntimeException("用户名已经存在!");
		}
		//使用MD5对密码进行加密
		u.setUser_password(MD5Utils.md5(u.getUser_password()));
		//3 调用Dao执行保存
		userDAO.save(u);
		
	}



	

}
